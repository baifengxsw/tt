package cn.itcast.erp.biz.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.dao.IEmpDao;
import cn.itcast.erp.dao.IMenuDao;
import cn.itcast.erp.dao.IRoleDao;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.entity.Menu;
import cn.itcast.erp.entity.Role;
import cn.itcast.erp.entity.Tree;
import cn.itcast.erp.exception.ErpException;
import redis.clients.jedis.Jedis;
/**
 * 员工业务逻辑类
 * @author Administrator
 *
 */
public class EmpBiz extends BaseBiz<Emp> implements IEmpBiz {

	private int hashIterations = 2;
	
	private IEmpDao empDao;
	private IRoleDao roleDao;
	private IMenuDao menuDao;
	private Jedis jedis;
	
	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}
	
	public void setMenuDao(IMenuDao menuDao) {
		this.menuDao = menuDao;
	}




	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}




	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}



	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
		super.setBaseDao(this.empDao);
	}
	
	/**
	 * 用户登陆
	 * @param username
	 * @param pwd
	 * @return
	 */
	public Emp findByUsernameAndPwd(String username, String pwd){
		//查询前先加密
		pwd = encrypt(pwd, username);
		System.out.println(pwd);
		return empDao.findByUsernameAndPwd(username, pwd);
	}

	/**
	 * 修改密码
	 */
	public void updatePwd(Long uuid, String oldPwd, String newPwd) {
		//取出员工信息
		Emp emp = empDao.get(uuid);
		//加密旧密码
		String encrypted = encrypt(oldPwd, emp.getUsername());
		//旧密码是否正确的匹配
		if(!encrypted.equals(emp.getPwd())){
			//抛出 自定义异常
			throw new ErpException("旧密码不正确");
		}		
		empDao.updatePwd(uuid, encrypt(newPwd,emp.getUsername()));
	}
	
	/**
	 * 新增员工
	 */
	public void add(Emp emp){
		//String pwd = emp.getPwd();
		// source: 原密码
		// salt:   盐 =》扰乱码
		// hashIterations: 散列次数，加密次数
		//Md5Hash md5 = new Md5Hash(pwd, emp.getUsername(), hashIterations);
		//取出加密后的密码
		//设置初始密码
		String newPwd = encrypt(emp.getUsername(), emp.getUsername());
		//System.out.println(newPwd);
		//设置成加密后的密码
		emp.setPwd(newPwd);
		//保存到数据库中
		super.add(emp);
	}
	
	/**
	 * 重置密码
	 */
	public void updatePwd_reset(Long uuid, String newPwd){
		//取出员工信息
		Emp emp = empDao.get(uuid);
		empDao.updatePwd(uuid, encrypt(newPwd,emp.getUsername()));
	}
	
	
	/**
	 * 加密
	 * @param source
	 * @param salt
	 * @return
	 */
	private String encrypt(String source, String salt){
		Md5Hash md5 = new Md5Hash(source, salt, hashIterations);
		return md5.toString();
	}

	
	/**
	 * 读取用户角色
	 * @param uuid
	 * @return
	 */
	public List<Tree> readEmpRoles(Long uuid){
		List<Tree> treeList = new ArrayList<>();
		//获取用户
		Emp emp = empDao.get(uuid);
		//获取角色
		List<Role> roleMenus = emp.getRoles();
		
		//获取所有角色
		
		Tree t1 = null;
		for(Role role:roleDao.getList(null, null, null)) {
			t1= new Tree();
			t1.setId(String.valueOf(role.getUuid()));
			t1.setText(role.getName());
			if(roleMenus.contains(role)) {
				t1.setChecked(true);
			}
			treeList.add(t1);
		}
			
		return treeList;
		
	}
	/**
	 * 更新用户角色
	 * @param uuid
	 * @param checkedStr
	 */
	public void updateEmpRoles(Long uuid,String checkedStr) {
		//获取用户信息
		Emp emp = empDao.get(uuid);
		//清空该用户下所有的角色
		emp.setRoles(new ArrayList<Role>());
		//切割字符串
		String[] ids = checkedStr.split(",");
		for(String id :ids) {
			Role role = roleDao.get(Long.parseLong(id));
			emp.getRoles().add(role);
		}
		/**
		 * 更新用户角色后清除缓存
		 */
		try {
			jedis.del("menuList_"+uuid);
			System.out.println("清除menuList_"+uuid);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	/**
	 * 获取用户的真实menu
	 */
	
	@Override
	public Menu readMenuByEmpuuid(long uuid) {
		Menu root = menuDao.get("0");
		//用户菜单集合
		List<Menu> empMenus = empDao.getMenusByEmpuuid(uuid);
		//获取根菜单
		Menu menu = cloneMenu(root);
		
		//循环匹配模板
		Menu _m1 = null;
		Menu _m2 = null;
		for(Menu m1 :root.getMenus()) {
			_m1 = cloneMenu(m1);
			for(Menu m2:m1.getMenus()) {
				//用户包含相应的菜单 ，就将它加入
				if(empMenus.contains(m2)) {
					_m2 = cloneMenu(m2);
					_m1.getMenus().add(_m2);
				}
			}
			//有二级菜单才进行加入
			if(_m1.getMenus().size()>0) {
				menu.getMenus().add(_m1);
			}
		}
		
		return menu;
	}

	/**
	 * 获取menu
	 * 
	 */
	private Menu cloneMenu(Menu src) {
		Menu menu = new Menu();
		menu.setIcon(src.getIcon());
		menu.setMenuid(src.getMenuid());
		menu.setMenuname(src.getMenuname());
		menu.setUrl(src.getUrl());
		menu.setMenus(new ArrayList<Menu>());
		return menu;
	}


	/**
	 * 查询用户下的菜单权限
	 * @param uuid
	 * @return
	 */
	
	public List<Menu>getMenusByEmpuuid(Long uuid){
		//1:尝试从缓存里取出menuList
		String menuListJSON = jedis.get("menuList_"+uuid);
		List<Menu>menuList = null;
		if(null != menuListJSON) {
			//缓存中已经存在
			System.out.println("从缓存中取出");
			menuList = JSON.parseArray(menuListJSON,Menu.class);
			
		}else {
			//第一次进行查询
			System.out.println("第一次进行查询");
			 menuList = empDao.getMenusByEmpuuid(uuid);
			jedis.set("menuList_"+uuid, JSON.toJSONString(menuList));
		}
		return menuList;
		
	}
	
	
}

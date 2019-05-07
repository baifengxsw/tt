package cn.itcast.erp.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.itcast.erp.biz.IEmpBiz;
import cn.itcast.erp.entity.Emp;
import cn.itcast.erp.entity.Menu;
import redis.clients.jedis.Jedis;
/**
 * extends 这个类既有认真又有授权 web 层的授权考虑
 * @author baifeng
 *
 */
public class ErpRealm extends AuthorizingRealm{
	private IEmpBiz empBiz;
	

	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行了授权方法");
		//得到当前登录的用户
		Emp emp = (Emp)principals.getPrimaryPrincipal();
		//获取登录用户相应的菜单权限集合
		List<Menu> menus = empBiz.getMenusByEmpuuid(emp.getUuid());
		//设置返回的认证
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		for(Menu menu:menus) {
			info.addStringPermission(menu.getMenuname());
		}
		return info;
	}
	
	/**
	 * 认证
	 * @return 认证失败, 返回实现类 失败
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户名和密码
		UsernamePasswordToken upt = (UsernamePasswordToken) token;
		String pwd =  String.valueOf(upt.getPassword());
		Emp emp = empBiz.findByUsernameAndPwd(upt.getUsername(),pwd);
		if(null != emp) {
			//构造参数1 主角等于登录用户
			// 授权码
			//realm 的名称
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(emp, pwd, getName());
			System.out.println("realm:"+getName());
			return info;
		}
		return null;
	}

}

package cn.itcast.erp.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;

import cn.itcast.erp.biz.IDepBiz;
import cn.itcast.erp.entity.Dep;
public class DepAction {
	private IDepBiz depBiz;

	private Dep dep1;
	private int page;//页码
	private int rows;// 每页的记录数
	private Dep dep2;
	private Dep dep ; //作为添加用户所用
	private Long uuid;
	public Long getUuid() {
		return uuid;
	}
	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}
	public Dep getDep() {
		return dep;
	}
	public void setDep(Dep dep) {
		this.dep = dep;
	}

	private Object param;
	public Dep getDep2() {
		return dep2;
	}
	public void setDep2(Dep dep2) {
		this.dep2 = dep2;
	}
	public Object getParam() {
		return param;
	}
	public void setParam(Object param) {
		this.param = param;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public IDepBiz getDepBiz() {
		return depBiz;
	}
	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
	}
	/**
	 * struts2 要写set get 方法
	 * @param dep1
	 */
	public void setDep1(Dep dep1) {
		this.dep1 = dep1;
	}
	public Dep getDep1() {
		return dep1;
	}
	public void list() {
		List<Dep> list = depBiz.findList();
		String jsonString = JSON.toJSONString(list);
		writeJson(jsonString);
	
	}
	public void getList() {
		System.out.println("页码"+page+":"+"记录数"+rows);
		int firstResult = (page-1)*rows;
		List<Dep> list = depBiz.findList(dep1,dep2,param,firstResult,rows);
		Long total = depBiz.getCount(dep1,dep2,param);
		Map<String,Object>mapData = new HashMap<>();
		mapData.put("total",total);
		mapData.put("rows", list);
		String jsonString = JSON.toJSONString(mapData);
		writeJson(jsonString);
		
	}
	
	public void writeJson(String jsonString) {
		HttpServletResponse reponse = ServletActionContext.getResponse();
		reponse.setContentType("text/html;charset=utf-8");
		//对页面进行输出
		try {
			reponse.getWriter().write(jsonString);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	/**
	 * 将json 中的字符中 每个属性添加相应的前缀
	 * @param jsonString
	 * @param prefix
	 * @return
	 */
	private String mapData(String jsonString ,String prefix) {
		Map<String,Object> map = JSON.parseObject(jsonString);
		Map<String,Object> newMap = new HashMap<>();
		for(String key:map.keySet()) {
			String newKey = prefix+key;
			Object value = map.get(key);
			
			newMap.put(newKey, value);
		}
		return JSON.toJSONString(newMap);
	}
	
	public void add() {
		//{"sucess":true;"message":""}
		//返回前端的json数据
		Map<String,Object> rtn = new HashMap<>();
		try {
			depBiz.add(dep);
			rtn.put("success", true);
			rtn.put("message", "新增成功");
		}catch (Exception e) {
			rtn.put("success",false);
			rtn.put("message", "新增失败");
		}
		String jsonString = JSON.toJSONString(rtn);
		writeJson(jsonString);
	}
	
	public void delete() {
		//{"success":true;"message":""}
		//返回前端的相应数据
		Map<String ,Object> rtn = new HashMap<>();
		try {
			System.out.println(uuid);
			depBiz.delete(uuid);
			rtn.put("success", true);
			rtn.put("message", "删除成功");
		}catch (Exception e) {
			rtn.put("success", false);
			rtn.put("message", "删除失败");
		}
		String jsonString = JSON.toJSONString(rtn);
		writeJson(jsonString);
	}
	/**
	 * 通过编号 查询
	 */
	public void get() {
		Dep dep = depBiz.getDep(uuid);
		System.out.println(uuid);
		String jsonString = mapData(JSON.toJSONString(dep), "dep.");
		writeJson(jsonString);
	}
	
	/**
	 * 保存相应的数据
	 */
	public void update() {
		
		try {
			depBiz.update(dep);
			ajaxReturn(true, "保存成功");
		} catch (Exception e) {
			
			ajaxReturn(true,"保存失败");
		}
		
	}
	private void ajaxReturn(boolean flag,String message) {
		Map<String, Object> map = new HashMap<>();
		map.put("success", flag);
		map.put("message", message);
		writeJson(JSON.toJSONString(map));
	}
}

package cn.itcast.demo3;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.Product;

public class ProductAction2 extends ActionSupport {
	private Map<String,Product> map ;
	


	public Map<String, Product> getMap() {
		return map;
	}



	public void setMap(Map<String, Product> map) {
		this.map = map;
	}



	@Override
	public String execute() throws Exception {
		for(String key:map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		return NONE;
	}



}

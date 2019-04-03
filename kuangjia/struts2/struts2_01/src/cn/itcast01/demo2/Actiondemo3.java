package cn.itcast01.demo2;

import com.opensymphony.xwork2.Action;

/**
 * action 实现接口
 * @author baifeng
 *
 */
public class Actiondemo3 implements Action {
	/**
	 * 提供一个方法 并且返回String ，并且不能传参 因为反射怎么知道参数嘛
	 */
	public String execute() {
		System.out.println("Actiondemo3执行了");
		return null;
	}
}

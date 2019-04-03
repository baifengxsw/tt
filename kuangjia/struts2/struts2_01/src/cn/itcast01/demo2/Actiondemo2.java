package cn.itcast01.demo2;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * action 实现继承
 * @author baifeng
 *
 */
public class Actiondemo2 extends ActionSupport{
	/**
	 * 提供一个方法 并且返回String ，并且不能传参 因为反射怎么知道参数嘛
	 */
	public String execute() {
		System.out.println("Actiondemo3执行了");
		return NONE;
	}
}

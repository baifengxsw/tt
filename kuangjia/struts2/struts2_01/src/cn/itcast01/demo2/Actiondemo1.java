package cn.itcast01.demo2;
/**
 * struts的入门测试
 * @author baifeng
 *
 */
public class Actiondemo1 {
	/**
	 * 提供一个方法 并且返回String ，并且不能传参 因为反射怎么知道参数嘛
	 */
	public String execute() {
		System.out.println("Actiondemo1执行了");
		return null;
	}
}

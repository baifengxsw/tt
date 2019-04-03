package cn.itcast01.demo1;
/**
 * struts的入门测试
 * @author baifeng
 *
 */
public class HelloAction {
	/**
	 * 提供一个方法 并且返回String ，并且不能传参 因为反射怎么知道参数嘛
	 */
	public String execute() {
		System.out.println("HelloAction执行了");
		return "success";
	}
}

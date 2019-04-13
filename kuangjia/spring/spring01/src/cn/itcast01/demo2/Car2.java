package cn.itcast01.demo2;

public class Car2 {
	private String name;
	private int age;

	public void setName(String name) {
		this.name = name;
	}

	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", age=" + age + "]";
	}
	
}

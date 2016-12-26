package test.apptest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class mybatisusers {
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	@Test
	public String toString() {
		return "mybatistest [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}
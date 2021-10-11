package tuckerproject;

import java.io.Serializable;

public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;

	String function;
	String ID;
	String name;
	String age;
	String birthday;
	String address;
	String school;
	String activity1;
	String activity2; 
	
	public void SetFunction(String function) {
		this.function = function;
	}
	
	public void SetID(String ID) {
		this.ID = ID;
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	
	public void SetAge(String age) {
		this.age = age;
	}
	
	public void SetBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public void SetAddress(String address) {
		this.address = address;
	}
	
	public void SetSchool(String school) {
		this.school = school;
	}
	
	public void SetActivity1(String activity1) {
		this.activity1 = activity1;
	}
	
	public void SetActivity2(String activity2) {
		this.activity2 = activity2;
	}
	
	public String getFunction() {
		return this.function;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAge() {
		return this.age;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getSchool() {
		return this.school;
	}
	
	public String getActivity1() {
		return this.activity1;
	}
	
	public String getActivity2() {
		return this.activity2;
	}
}

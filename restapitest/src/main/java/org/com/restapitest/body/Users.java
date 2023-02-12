package org.com.restapitest.body;

public class Users {

	String name;
	String job;
	//String total;
	//String total_pages;

	public Users(String name, String job) {
		super();
		this.name = name;
		this.job = job;
		//		this.total = total;
		//		this.total_pages = total_pages;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name; //So name which is local to the method here gets assigned to this.name,means the name variable which belongs to this class.
		//name=this.name; Not correct as Assignment happens from left to right

	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}
}
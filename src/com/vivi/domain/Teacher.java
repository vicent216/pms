package com.vivi.domain;

public class Teacher extends Person implements TeacherI {
	String job = null;
	String depart = null;
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	@Override
	public String toString() {
		return "Teacher [job=" + job + ", depart=" + depart + ", num=" + num
				+ ", name=" + name + ", gender=" + gender + ", birth=" + birth
				+ ", IdCard=" + IdCard + "]";
	}
	
	
}

package com.vivi.domain;

public class Assistant extends Postgraduate implements TeacherI {

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
	
	
}

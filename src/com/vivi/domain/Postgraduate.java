package com.vivi.domain;

public class Postgraduate extends Student {
	String major = null;
	Teacher teacher = null;
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Postgraduate [major=" + major + ", teacher=" + teacher
				+ ", classNum=" + classNum + ", num=" + num + ", name=" + name
				+ ", gender=" + gender + ", birth=" + birth + ", IdCard="
				+ IdCard + "]";
	}

	 
	
	

}

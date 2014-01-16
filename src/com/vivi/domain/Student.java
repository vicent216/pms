package com.vivi.domain;

public class Student extends Person {
	String classNum = null;

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	@Override
	public String toString() {
		return "Student [classNum=" + classNum + ", num=" + num + ", name="
				+ name + ", gender=" + gender + ", birth=" + birth
				+ ", IdCard=" + IdCard + "]";
	}
	

}

package com.vivi.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class TeacherFormBean {
	private String num = null;
	private String name = null;
	private String gender = null;
	private String birth = null;
	private String idCard = null;
	private String job = null;
	private String depart = null;
	private Map<String, String> errors = new HashMap<String, String>();
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
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
	public Map<String, String> getErrors() {
		return errors;
	}
	public boolean validate() {
		if(name==null||"".equals(name.trim())){
			errors.put("name", "请输入用户名");
		}
		
		if(birth==null||"".equals(birth.trim())){
			errors.put("birth", "请输入出生日期");
		}else{
			DateLocaleConverter dlc = new DateLocaleConverter();
			
			try {
				dlc.convert(birth);
			} catch (Exception e) {
				errors.put("birth", "请输入正确格式的日期.比如：2013-09-31");
			}
		}
		return errors.isEmpty();
	}


}

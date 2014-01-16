package com.vivi.util;

import java.util.Comparator;

import com.vivi.domain.Person;
import com.vivi.domain.Postgraduate;
import com.vivi.domain.Student;
import com.vivi.domain.Teacher;

public class ComparatorUtil {
	
	public static Comparator makeComparator(String attr) {
		
		if ("num".equals(attr)) {
			class NumCompare<T extends Person> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getNum().compareTo(p2.getNum());
				}
			}
			return new NumCompare();
		} else if ("name".equals(attr)) {
			class NameCompare<T extends Person> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getName().compareTo(p2.getName());
				}
			}
			return new NameCompare();
		} else if ("gender".equals(attr)) {
			class GenderCompare<T extends Person> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getGender().compareTo(p2.getGender());
				}
			}
			return new GenderCompare();
		} else if ("birth".equals(attr)) {
			class BirthCompare<T extends Person> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getBirth().compareTo(p2.getBirth());
				}
			}
			return new BirthCompare();
		} else if ("idCard".equals(attr)) {
			class IdCardCompare<T extends Person> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getIdCard().compareTo(p2.getIdCard());
				}
			}
			return new IdCardCompare();
		} else if ("classNum".equals(attr)) {
			class ClassNumCompare<T extends Student> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getClassNum().compareTo(p2.getClassNum());
				}
			}
			return new ClassNumCompare();
		} else if ("job".equals(attr)) {
			class JobCompare<T extends Teacher> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getJob().compareTo(p2.getJob());
				}
			}
			return new JobCompare();
		} else if ("depart".equals(attr)) {
			class DepartCompare<T extends Teacher> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getDepart().compareTo(p2.getDepart());
				}
			}
			return new DepartCompare();
		} else if ("major".equals(attr)) {
			class MajorCompare<T extends Postgraduate> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getMajor().compareTo(p2.getMajor());
				}
			}
			return new MajorCompare();
		} else if ("teacher".equals(attr)) {
			class TeacherCompare<T extends Postgraduate> implements Comparator<T> {
				public int compare(T p1, T p2) {
					return p1.getTeacher().getName().compareTo(p2.getTeacher().getName());
				}
			}
			return new TeacherCompare();
		}
		
		return null;
	}

}

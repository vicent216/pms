package com.vivi.dao;

import java.util.List;

import com.vivi.domain.Student;

public interface StudentDao {
	/**
	 * 在文件末尾添加学生信息
	 * @param stu 要添加的学生对象
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addStudent(Student stu);
	/**
	 * 在指定位置插入学生信息
	 * @param stu 要添加的学生对象
	 * @param pos 要插入的位置
	 * @return 插入成功返回true，否则返回false
	 */
	public boolean insertStudent(Student stu, int pos);
	/**
	 * 通过编号删除学生信息
	 * @param num 需要删除的学生编号
	 * @return 成功返回true，否则返回false
	 */
	public boolean deleteStudentById(String num);
	/**
	 * 通过属性查找学生
	 * @param num 需要查找的学生编号
	 * @return 找到返回该学生对象，否则返回null
	 */
	public Student findStudentById(String num);
	/**
	 * 通过属性查找学生
	 * @param attr 指定的属性段
	 * @param str 查找的字符串
	 * @return 成功返回Student对象，否则返回null
	 */
	public List<Student> findStudentByAttr(String attr, String str);
	/**
	 * 列出所有学生对象
	 * @return 学生对象列表
	 */
	public List<Student> showStudents();
	/**
	 * 将学生对象存入XML文件中
	 * @param students 学生对象列表
	 * @return 成功返回true，否则返回false
	 */
	public boolean saveStudents(List<Student> students);
	

}

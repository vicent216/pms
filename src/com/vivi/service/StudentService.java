package com.vivi.service;

import java.util.List;

import com.vivi.domain.Student;

public interface StudentService {
	/**
	 * 增加学生信息
	 * 
	 * @param stu
	 *            要增加的学生对象
	 * @return 添加成功返回true
	 */
	public boolean addStudent(Student stu);

	/**
	 * 删除指定编号的学生
	 * 
	 * @param num
	 *            删除的编号
	 * @return 成功返回true
	 */
	public boolean deleteStudent(String num);

	/**
	 * 通过指定字段查找学生
	 * 
	 * @param attr
	 *            属性范围
	 * @param str
	 *            属性值
	 * @return 成功返回查找到的学生列表
	 */
	public List<Student> findStudent(String attr, String str);

	/**
	 * 更新指定学生信息
	 * 
	 * @param stu
	 *            改动后的学生对象
	 * @param num
	 *            改动的学生编号
	 * @return 成功返回true
	 */
	public boolean updateStudent(Student stu, String num);

	/**
	 * 在指定位置插入学生信息
	 * 
	 * @param stu
	 *            要插入的学生对象
	 * @param pos
	 *            插入的位置
	 * @return 成功返回true
	 */
	public boolean insertStudent(Student stu, String pos);

	/**
	 * 显示所有学生信息
	 * 
	 * @return 学生信息列表
	 */
	public List<Student> showStudents();

	/**
	 * 通过不同字段排序
	 * 
	 * @param attr
	 *            排序的字段名称
	 * @param i
	 *            0代表升序，1代表降序
	 * @return 返回排序后的列表
	 */
	public List<Student> sortStudents(String attr, int i);

	/**
	 * 保存学生信息
	 * 
	 * @param students
	 *            要保存的学生列表
	 */
	public void saveStudents(List<Student> students);

}
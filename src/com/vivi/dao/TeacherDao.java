package com.vivi.dao;

import java.util.List;

import com.vivi.domain.Teacher;

public interface TeacherDao {
	/**
	 * 在文件末尾添加教师信息
	 * @param stu 要添加的教师对象
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addTeacher(Teacher stu);
	/**
	 * 在指定位置插入教师信息
	 * @param stu 要添加的教师对象
	 * @param pos 要插入的位置
	 * @return 插入成功返回true，否则返回false
	 */
	public boolean insertTeacher(Teacher stu, int pos);
	/**
	 * 通过编号删除教师信息
	 * @param num 需要删除的教师编号
	 * @return 成功返回true，否则返回false
	 */
	public boolean deleteTeacherById(String num);
	/**
	 * 通过属性查找教师
	 * @param num 需要查找的教师编号
	 * @return 找到返回该教师对象，否则返回null
	 */
	public Teacher findTeacherById(String num);
	/**
	 * 通过属性查找教师
	 * @param attr 指定的属性段
	 * @param str 查找的字符串
	 * @return 成功返回Teacher对象，否则返回null
	 */
	public List<Teacher> findTeacherByAttr(String attr, String str);
	/**
	 * 列出所有教师对象
	 * @return 教师对象列表
	 */
	public List<Teacher> showTeachers();
	/**
	 * 将教师对象存入XML文件中
	 * @param students 教师对象列表
	 * @return 成功返回true，否则返回false
	 */
	public boolean saveTeachers(List<Teacher> students);
	

}

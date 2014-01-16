package com.vivi.service;

import java.util.List;

import com.vivi.domain.Teacher;

public interface TeacherService {
	/**
	 * 增加教师信息
	 * @param stu 要增加的教师对象
	 * @return 添加成功返回true
	 */
	public boolean addTeacher(Teacher stu);
	/**
	 * 删除指定编号的教师
	 * @param num 删除的编号
	 * @return 成功返回true
	 */
	public boolean deleteTeacher(String num);
	/**
	 * 通过指定字段查找教师
	 * @param attr 属性范围
	 * @param str 属性值
	 * @return 成功返回查找到的教师列表
	 */
	public List<Teacher> findTeacher(String attr, String str);
	/**
	 * 更新指定教师信息
	 * @param stu 改动后的教师对象
	 * @param num 改动的教师编号
	 * @return 成功返回true
	 */
	public boolean updateTeacher(Teacher stu, String num);
	/**
	 * 在指定位置插入教师信息
	 * @param stu 要插入的教师对象
	 * @param pos 插入的位置
	 * @return 成功返回true
	 */
	public boolean insertTeacher(Teacher stu, String pos);
	/**
	 * 显示所有教师信息
	 * @return 教师信息列表
	 */
	public List<Teacher> showTeachers();
	/**
	 * 通过不同字段排序
	 * @param attr 排序的字段名称
	 * @param i 0代表升序，1代表降序
	 * @return 返回排序后的列表
	 */
	public List<Teacher> sortTeachers(String attr, int i);
	/**
	 * 保存教师信息
	 * @param students 要保存的教师列表
	 */
	public void saveTeachers(List<Teacher> students);

}
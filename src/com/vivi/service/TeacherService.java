package com.vivi.service;

import java.util.List;

import com.vivi.domain.Teacher;

public interface TeacherService {
	/**
	 * ���ӽ�ʦ��Ϣ
	 * @param stu Ҫ���ӵĽ�ʦ����
	 * @return ��ӳɹ�����true
	 */
	public boolean addTeacher(Teacher stu);
	/**
	 * ɾ��ָ����ŵĽ�ʦ
	 * @param num ɾ���ı��
	 * @return �ɹ�����true
	 */
	public boolean deleteTeacher(String num);
	/**
	 * ͨ��ָ���ֶβ��ҽ�ʦ
	 * @param attr ���Է�Χ
	 * @param str ����ֵ
	 * @return �ɹ����ز��ҵ��Ľ�ʦ�б�
	 */
	public List<Teacher> findTeacher(String attr, String str);
	/**
	 * ����ָ����ʦ��Ϣ
	 * @param stu �Ķ���Ľ�ʦ����
	 * @param num �Ķ��Ľ�ʦ���
	 * @return �ɹ�����true
	 */
	public boolean updateTeacher(Teacher stu, String num);
	/**
	 * ��ָ��λ�ò����ʦ��Ϣ
	 * @param stu Ҫ����Ľ�ʦ����
	 * @param pos �����λ��
	 * @return �ɹ�����true
	 */
	public boolean insertTeacher(Teacher stu, String pos);
	/**
	 * ��ʾ���н�ʦ��Ϣ
	 * @return ��ʦ��Ϣ�б�
	 */
	public List<Teacher> showTeachers();
	/**
	 * ͨ����ͬ�ֶ�����
	 * @param attr ������ֶ�����
	 * @param i 0��������1������
	 * @return �����������б�
	 */
	public List<Teacher> sortTeachers(String attr, int i);
	/**
	 * �����ʦ��Ϣ
	 * @param students Ҫ����Ľ�ʦ�б�
	 */
	public void saveTeachers(List<Teacher> students);

}
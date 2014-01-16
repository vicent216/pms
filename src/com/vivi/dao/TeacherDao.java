package com.vivi.dao;

import java.util.List;

import com.vivi.domain.Teacher;

public interface TeacherDao {
	/**
	 * ���ļ�ĩβ��ӽ�ʦ��Ϣ
	 * @param stu Ҫ��ӵĽ�ʦ����
	 * @return ��ӳɹ�����true�����򷵻�false
	 */
	public boolean addTeacher(Teacher stu);
	/**
	 * ��ָ��λ�ò����ʦ��Ϣ
	 * @param stu Ҫ��ӵĽ�ʦ����
	 * @param pos Ҫ�����λ��
	 * @return ����ɹ�����true�����򷵻�false
	 */
	public boolean insertTeacher(Teacher stu, int pos);
	/**
	 * ͨ�����ɾ����ʦ��Ϣ
	 * @param num ��Ҫɾ���Ľ�ʦ���
	 * @return �ɹ�����true�����򷵻�false
	 */
	public boolean deleteTeacherById(String num);
	/**
	 * ͨ�����Բ��ҽ�ʦ
	 * @param num ��Ҫ���ҵĽ�ʦ���
	 * @return �ҵ����ظý�ʦ���󣬷��򷵻�null
	 */
	public Teacher findTeacherById(String num);
	/**
	 * ͨ�����Բ��ҽ�ʦ
	 * @param attr ָ�������Զ�
	 * @param str ���ҵ��ַ���
	 * @return �ɹ�����Teacher���󣬷��򷵻�null
	 */
	public List<Teacher> findTeacherByAttr(String attr, String str);
	/**
	 * �г����н�ʦ����
	 * @return ��ʦ�����б�
	 */
	public List<Teacher> showTeachers();
	/**
	 * ����ʦ�������XML�ļ���
	 * @param students ��ʦ�����б�
	 * @return �ɹ�����true�����򷵻�false
	 */
	public boolean saveTeachers(List<Teacher> students);
	

}

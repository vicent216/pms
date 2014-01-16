package com.vivi.dao;

import java.util.List;

import com.vivi.domain.Student;

public interface StudentDao {
	/**
	 * ���ļ�ĩβ���ѧ����Ϣ
	 * @param stu Ҫ��ӵ�ѧ������
	 * @return ��ӳɹ�����true�����򷵻�false
	 */
	public boolean addStudent(Student stu);
	/**
	 * ��ָ��λ�ò���ѧ����Ϣ
	 * @param stu Ҫ��ӵ�ѧ������
	 * @param pos Ҫ�����λ��
	 * @return ����ɹ�����true�����򷵻�false
	 */
	public boolean insertStudent(Student stu, int pos);
	/**
	 * ͨ�����ɾ��ѧ����Ϣ
	 * @param num ��Ҫɾ����ѧ�����
	 * @return �ɹ�����true�����򷵻�false
	 */
	public boolean deleteStudentById(String num);
	/**
	 * ͨ�����Բ���ѧ��
	 * @param num ��Ҫ���ҵ�ѧ�����
	 * @return �ҵ����ظ�ѧ�����󣬷��򷵻�null
	 */
	public Student findStudentById(String num);
	/**
	 * ͨ�����Բ���ѧ��
	 * @param attr ָ�������Զ�
	 * @param str ���ҵ��ַ���
	 * @return �ɹ�����Student���󣬷��򷵻�null
	 */
	public List<Student> findStudentByAttr(String attr, String str);
	/**
	 * �г�����ѧ������
	 * @return ѧ�������б�
	 */
	public List<Student> showStudents();
	/**
	 * ��ѧ���������XML�ļ���
	 * @param students ѧ�������б�
	 * @return �ɹ�����true�����򷵻�false
	 */
	public boolean saveStudents(List<Student> students);
	

}

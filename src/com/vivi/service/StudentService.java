package com.vivi.service;

import java.util.List;

import com.vivi.domain.Student;

public interface StudentService {
	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param stu
	 *            Ҫ���ӵ�ѧ������
	 * @return ��ӳɹ�����true
	 */
	public boolean addStudent(Student stu);

	/**
	 * ɾ��ָ����ŵ�ѧ��
	 * 
	 * @param num
	 *            ɾ���ı��
	 * @return �ɹ�����true
	 */
	public boolean deleteStudent(String num);

	/**
	 * ͨ��ָ���ֶβ���ѧ��
	 * 
	 * @param attr
	 *            ���Է�Χ
	 * @param str
	 *            ����ֵ
	 * @return �ɹ����ز��ҵ���ѧ���б�
	 */
	public List<Student> findStudent(String attr, String str);

	/**
	 * ����ָ��ѧ����Ϣ
	 * 
	 * @param stu
	 *            �Ķ����ѧ������
	 * @param num
	 *            �Ķ���ѧ�����
	 * @return �ɹ�����true
	 */
	public boolean updateStudent(Student stu, String num);

	/**
	 * ��ָ��λ�ò���ѧ����Ϣ
	 * 
	 * @param stu
	 *            Ҫ�����ѧ������
	 * @param pos
	 *            �����λ��
	 * @return �ɹ�����true
	 */
	public boolean insertStudent(Student stu, String pos);

	/**
	 * ��ʾ����ѧ����Ϣ
	 * 
	 * @return ѧ����Ϣ�б�
	 */
	public List<Student> showStudents();

	/**
	 * ͨ����ͬ�ֶ�����
	 * 
	 * @param attr
	 *            ������ֶ�����
	 * @param i
	 *            0��������1������
	 * @return �����������б�
	 */
	public List<Student> sortStudents(String attr, int i);

	/**
	 * ����ѧ����Ϣ
	 * 
	 * @param students
	 *            Ҫ�����ѧ���б�
	 */
	public void saveStudents(List<Student> students);

}
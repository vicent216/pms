package com.vivi.service;

import java.util.List;

import com.vivi.domain.Postgraduate;

public interface PostgraduateService {
	/**
	 * �����о�����Ϣ
	 * @param stu Ҫ���ӵ��о�������
	 * @return ��ӳɹ�����true
	 */
	public boolean addPostgraduate(Postgraduate stu);
	/**
	 * ɾ��ָ����ŵ��о���
	 * @param num ɾ���ı��
	 * @return �ɹ�����true
	 */
	public boolean deletePostgraduate(String num);
	/**
	 * ͨ��ָ���ֶβ����о���
	 * @param attr ���Է�Χ
	 * @param str ����ֵ
	 * @return �ɹ����ز��ҵ����о����б�
	 */
	public List<Postgraduate> findPostgraduate(String attr, String str);
	/**
	 * ����ָ���о�����Ϣ
	 * @param stu �Ķ�����о�������
	 * @param num �Ķ����о������
	 * @return �ɹ�����true
	 */
	public boolean updatePostgraduate(Postgraduate stu, String num);
	/**
	 * ��ָ��λ�ò����о�����Ϣ
	 * @param stu Ҫ������о�������
	 * @param pos �����λ��
	 * @return �ɹ�����true
	 */
	public boolean insertPostgraduate(Postgraduate stu, String pos);
	/**
	 * ��ʾ�����о�����Ϣ
	 * @return �о�����Ϣ�б�
	 */
	public List<Postgraduate> showPostgraduates();
	/**
	 * ͨ����ͬ�ֶ�����
	 * @param attr ������ֶ�����
	 * @param i 0��������1������
	 * @return �����������б�
	 */
	public List<Postgraduate> sortPostgraduates(String attr, int i);
	/**
	 * �����о�����Ϣ
	 * @param postgraduates Ҫ������о����б�
	 */
	public void savePostgraduates(List<Postgraduate> postgraduates);

}
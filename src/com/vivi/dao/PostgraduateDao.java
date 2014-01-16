package com.vivi.dao;

import java.util.List;

import com.vivi.domain.Postgraduate;

public interface PostgraduateDao {
	/**
	 * ���ļ�ĩβ����о�����Ϣ
	 * @param stu Ҫ��ӵ��о�������
	 * @return ��ӳɹ�����true�����򷵻�false
	 */
	public boolean addPostgraduate(Postgraduate stu);
	/**
	 * ��ָ��λ�ò����о�����Ϣ
	 * @param stu Ҫ��ӵ��о�������
	 * @param pos Ҫ�����λ��
	 * @return ����ɹ�����true�����򷵻�false
	 */
	public boolean insertPostgraduate(Postgraduate stu, int pos);
	/**
	 * ͨ�����ɾ���о�����Ϣ
	 * @param num ��Ҫɾ�����о������
	 * @return �ɹ�����true�����򷵻�false
	 */
	public boolean deletePostgraduateById(String num);
	/**
	 * ͨ�����Բ����о���
	 * @param num ��Ҫ���ҵ��о������
	 * @return �ҵ����ظ��о������󣬷��򷵻�null
	 */
	public Postgraduate findPostgraduateById(String num);
	/**
	 * ͨ�����Բ����о���
	 * @param attr ָ�������Զ�
	 * @param str ���ҵ��ַ���
	 * @return �ɹ�����Postgraduate���󣬷��򷵻�null
	 */
	public List<Postgraduate> findPostgraduateByAttr(String attr, String str);
	/**
	 * �г������о�������
	 * @return �о��������б�
	 */
	public List<Postgraduate> showPostgraduates();
	/**
	 * ���о����������XML�ļ���
	 * @param postgraduates �о��������б�
	 * @return �ɹ�����true�����򷵻�false
	 */
	public boolean savePostgraduates(List<Postgraduate> postgraduates);
	

}

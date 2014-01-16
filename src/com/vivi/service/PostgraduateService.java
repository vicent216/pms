package com.vivi.service;

import java.util.List;

import com.vivi.domain.Postgraduate;

public interface PostgraduateService {
	/**
	 * 增加研究生信息
	 * @param stu 要增加的研究生对象
	 * @return 添加成功返回true
	 */
	public boolean addPostgraduate(Postgraduate stu);
	/**
	 * 删除指定编号的研究生
	 * @param num 删除的编号
	 * @return 成功返回true
	 */
	public boolean deletePostgraduate(String num);
	/**
	 * 通过指定字段查找研究生
	 * @param attr 属性范围
	 * @param str 属性值
	 * @return 成功返回查找到的研究生列表
	 */
	public List<Postgraduate> findPostgraduate(String attr, String str);
	/**
	 * 更新指定研究生信息
	 * @param stu 改动后的研究生对象
	 * @param num 改动的研究生编号
	 * @return 成功返回true
	 */
	public boolean updatePostgraduate(Postgraduate stu, String num);
	/**
	 * 在指定位置插入研究生信息
	 * @param stu 要插入的研究生对象
	 * @param pos 插入的位置
	 * @return 成功返回true
	 */
	public boolean insertPostgraduate(Postgraduate stu, String pos);
	/**
	 * 显示所有研究生信息
	 * @return 研究生信息列表
	 */
	public List<Postgraduate> showPostgraduates();
	/**
	 * 通过不同字段排序
	 * @param attr 排序的字段名称
	 * @param i 0代表升序，1代表降序
	 * @return 返回排序后的列表
	 */
	public List<Postgraduate> sortPostgraduates(String attr, int i);
	/**
	 * 保存研究生信息
	 * @param postgraduates 要保存的研究生列表
	 */
	public void savePostgraduates(List<Postgraduate> postgraduates);

}
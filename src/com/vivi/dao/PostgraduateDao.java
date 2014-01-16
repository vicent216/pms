package com.vivi.dao;

import java.util.List;

import com.vivi.domain.Postgraduate;

public interface PostgraduateDao {
	/**
	 * 在文件末尾添加研究生信息
	 * @param stu 要添加的研究生对象
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean addPostgraduate(Postgraduate stu);
	/**
	 * 在指定位置插入研究生信息
	 * @param stu 要添加的研究生对象
	 * @param pos 要插入的位置
	 * @return 插入成功返回true，否则返回false
	 */
	public boolean insertPostgraduate(Postgraduate stu, int pos);
	/**
	 * 通过编号删除研究生信息
	 * @param num 需要删除的研究生编号
	 * @return 成功返回true，否则返回false
	 */
	public boolean deletePostgraduateById(String num);
	/**
	 * 通过属性查找研究生
	 * @param num 需要查找的研究生编号
	 * @return 找到返回该研究生对象，否则返回null
	 */
	public Postgraduate findPostgraduateById(String num);
	/**
	 * 通过属性查找研究生
	 * @param attr 指定的属性段
	 * @param str 查找的字符串
	 * @return 成功返回Postgraduate对象，否则返回null
	 */
	public List<Postgraduate> findPostgraduateByAttr(String attr, String str);
	/**
	 * 列出所有研究生对象
	 * @return 研究生对象列表
	 */
	public List<Postgraduate> showPostgraduates();
	/**
	 * 将研究生对象存入XML文件中
	 * @param postgraduates 研究生对象列表
	 * @return 成功返回true，否则返回false
	 */
	public boolean savePostgraduates(List<Postgraduate> postgraduates);
	

}

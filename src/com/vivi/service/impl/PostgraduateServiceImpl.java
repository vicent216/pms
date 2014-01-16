package com.vivi.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.vivi.dao.PostgraduateDao;
import com.vivi.dao.impl.PostgraduateDaoImpl;
import com.vivi.domain.Person;
import com.vivi.domain.Postgraduate;
import com.vivi.service.PostgraduateService;
import com.vivi.util.ComparatorUtil;

public class PostgraduateServiceImpl implements PostgraduateService {
	PostgraduateDao dao = new PostgraduateDaoImpl();

	public boolean addPostgraduate(Postgraduate stu) {
		Boolean result = false;
		Postgraduate check = dao.findPostgraduateById(stu.getNum());
		if (check == null) {
			result = dao.addPostgraduate(stu);
		}
		return result;
	}

	public boolean deletePostgraduate(String num) {
		boolean result = false;
		Postgraduate check = dao.findPostgraduateById(num);
		if (check != null) {
			result = dao.deletePostgraduateById(num);
		}
		return result;
	}

	public List<Postgraduate> findPostgraduate(String attr, String str) {
		return dao.findPostgraduateByAttr(attr, str);
	}

	public boolean updatePostgraduate(Postgraduate stu, String num) {
		boolean result = false;
		Postgraduate check = dao.findPostgraduateById(num);
		if ((check != null) && (num == stu.getNum())) {
			dao.deletePostgraduateById(num);
			result = dao.addPostgraduate(stu);
		}
		return result;
	}

	public boolean insertPostgraduate(Postgraduate stu, String pos) {
		boolean result = false;
		Postgraduate check = dao.findPostgraduateById(stu.getNum());
		if (check == null) {
			result = dao.insertPostgraduate(stu, Integer.parseInt(pos));
		}
		return result;
	}

	public List<Postgraduate> showPostgraduates() {
		return dao.showPostgraduates();
	}

	public List<Postgraduate> sortPostgraduates(String attr, int i) {
		List<Postgraduate> postgraduates = dao.showPostgraduates();
		
		Collections.sort(postgraduates, ComparatorUtil.makeComparator(attr));
		
		return postgraduates;
	}

	public void savePostgraduates(List<Postgraduate> postgraduates) {
		dao.savePostgraduates(postgraduates);

	}

}

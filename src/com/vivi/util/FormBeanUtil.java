package com.vivi.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormBeanUtil {
	public static <T>T fillFormBean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, request.getParameterMap());
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}

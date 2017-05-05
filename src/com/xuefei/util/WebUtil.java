package com.xuefei.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtil {
	public static <T>T copyRequestToBean(HttpServletRequest request,Class<T> clazz){
		Map<String, String[]> map = request.getParameterMap();
		T t = null;
		try {
			t = clazz.newInstance();//反射构造对象
			BeanUtils.copyProperties(t, map);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}
}

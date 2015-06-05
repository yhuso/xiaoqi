package com.diary.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {

	public static String printAllProperties(Object obj) {
		BeanInfo beaninfo = null;
		try {
			beaninfo = Introspector.getBeanInfo(obj.getClass());
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 得到谁的beaninfo？当然是Person的
		// 获得JavaBean中所有属性的描述
		PropertyDescriptor[] porpertydescriptors = beaninfo.getPropertyDescriptors();
		StringBuilder sb = new StringBuilder();
		Object value = null;
		// 遍历
		for (PropertyDescriptor pd : porpertydescriptors) {
			Method getMethod = pd.getReadMethod();
			try {
				value = getMethod.invoke(obj);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sb.append(pd.getName()+"="+value+",\n");
		}
		return sb.substring(0, sb.length()-2);
	}
}

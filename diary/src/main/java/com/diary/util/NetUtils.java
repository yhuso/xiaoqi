package com.diary.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class NetUtils {
	//获得访问主机IP
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (isInvalid(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
			if (isInvalid(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
				if (isInvalid(ip)) {
					ip = request.getRemoteAddr();
				}
			}
		}
		return ip;
	}

	/**
	 * 
	 * 功能描述:无效返回true
	 *
	 * <pre>
	 * Modify Reason:(修改原因,不需覆盖，直接追加.)
	 *     bianjie:   2015年6月11日      新建
	 * </pre>
	 *
	 * @param ip
	 * @return
	 */
	private static boolean isInvalid(String ip) {
		return StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip);
	}
}

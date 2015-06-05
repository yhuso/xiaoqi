package com.diary.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5AndShaUtil {
	/**
	 * 功能描述:生成一个sha1加密计算摘要
	 *
	 * <pre>
	 * Modify Reason:(修改原因,不需覆盖，直接追加.)
	 *     bianjie:   2015年6月3日      新建
	 * </pre>
	 *
	 * @param password
	 * @return
	 */
	public static String makesha1(String password) {
		MessageDigest md;
		try {
			// 生成一个sha1加密计算摘要
			md = MessageDigest.getInstance("sha1"); // 同样可以使用md5
			// 计算md5函数
			md.update(password.getBytes());
			// digest()最后确定返回sha1 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16); //参数也可以用其它进制
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
}

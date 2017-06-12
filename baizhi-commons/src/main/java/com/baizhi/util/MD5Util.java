package com.baizhi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {

	/**
	 * 根据密码获取他的uuid的类
	 */
	public static String getMd5Code(String password){
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("md5");
			//加密
			byte[] bs = messageDigest.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			//将byte转换为16进制的长度是32位的字符串
			for(byte b:bs){
				int c=b&0xff;
				if(c<16){
					sb.append(0);
				}
				sb.append(Integer.toHexString(c));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}

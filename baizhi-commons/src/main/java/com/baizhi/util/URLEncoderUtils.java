package com.baizhi.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 获取URLEncoder值 将中文做URLEncoder操作，到浏览器时自动解析
 * @author GXL
 *
 */
public class URLEncoderUtils {
	public static String getEncoder(String msg,String charset){
		try {
			return URLEncoder.encode(msg, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getEncoder(String msg){
		return getEncoder(msg, "UTF-8");
	}
}

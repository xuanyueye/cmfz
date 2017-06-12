package com.baizhi.util;

import java.util.Random;

/**
 * 
 * 获取随机盐的工具类
 *
 */
public class SaltUtil{
	/**
	 * 获取随机盐的方法(取4位)
	 */
	public static String getSalt(){
		char[] code="abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		//随机数
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		//StringBuilder对比StringBuffer 线程不安全 效率高 轻量级
		for(int i=0;i<4;i++){//
			int j = random.nextInt(code.length);//对整个code随机取一个数的下标
			sb.append(code[j]);
		}
		return sb.toString();
	}
}

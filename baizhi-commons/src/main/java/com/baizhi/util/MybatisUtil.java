package com.baizhi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
	private  static final ThreadLocal<SqlSession> tls=new ThreadLocal<SqlSession>();
	private  static InputStream ins=null;
	private  static SqlSessionFactory sqlSessionFactory =null;
	static{
		//读取文件
		try {
			ins = Resources.getResourceAsStream("mybatis-config.xml");
			//创建SqlSessionFactory
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(ins);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//关闭输入流
			try {ins.close();} catch (IOException e1) {e1.printStackTrace();}
		}
	}
	
	/**
	 * 获取sqlSession的方法
	 */
	public static SqlSession  getSqlSession(){
		 //从ThreadLocal获取sqlSession
		SqlSession sqlSession =tls.get();
		 if(sqlSession==null){
			 //如果sqlSession不存在;则通过sqlSessionFactory获取sqlSession，并放入到ThreadLocal中
			 sqlSession = sqlSessionFactory.openSession();
			 tls.set(sqlSession);
		 }
		 return sqlSession;
	}
	
	/**
	 * 关闭资源
	 */
	public static void release(){
		//从tls取出sqlSession，保证是同一个sqlSession
		SqlSession sqlSession =tls.get();
		if(sqlSession!=null){
			//关闭sqlSession时，必须移除ThreadLocal；否则下次会取到一个关闭的ThreadLocal，影响使用
			sqlSession.close();
			tls.remove();
		}
	}
	/**
	 * 获取DAO接口实现类对象
	 */
	public static <T> T getMapper(Class<T> clazz){
		SqlSession sqlSession =getSqlSession();
		System.out.println(clazz);
		T t = sqlSession.getMapper(clazz);
		System.out.println(t);
		return t;
	}
	/**
	 * 获取DAO对象的通用方法
	 */
	
//	public static  Object getMapper(Class clazz){
//		return getSqlSession().getMapper(clazz);
//	}
	/**
	 * 提交事务
	 */
	public static void commit(){
		tls.get().commit();
		release();
	}
	/**
	 * 回滚事务
	 */
	public static void rollback(){
		tls.get().rollback();
		release();
	}
}

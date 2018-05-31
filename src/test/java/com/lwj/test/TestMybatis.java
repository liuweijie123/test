package com.lwj.test;

import org.apache.ibatis.session.SqlSession;

import com.lwj.bean.UserBean;
import com.lwj.mapper.UserMapper;
import com.lwj.util.MyBatisUtil;

public class TestMybatis {
	
	public static void insertUser(String name,String password,Double account){
		SqlSession session = MyBatisUtil.getSqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		UserBean user = new UserBean(name,password,account);
		try {
			mapper.insertUser(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		
	}
	public static void main(String[] args) {
		insertUser("qyy", "0000", 18.0);

	}

}

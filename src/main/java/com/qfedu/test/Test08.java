package com.qfedu.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.domain.Account;
import com.qfedu.domain.User;
import com.qfedu.mapper.UserMapper;

public class Test08 {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findById(5);
		System.out.println(user.getUsername());
		for (Account account : user.getAccounts()) {
			System.out.println(account.getNumber());
			System.out.println(account.getBalance());
		}
		User user2 = userMapper.findByUsername("wangdachui");
		System.out.println(user2.getUsername());
		System.out.println(user2.getAccounts());
		session.commit();
		session.close();
	}
}

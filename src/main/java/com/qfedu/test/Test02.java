package com.qfedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.domain.User;
import com.qfedu.mapper.UserMapper;

public class Test02 {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findById(3);
		System.out.println(user.getUsername());
		System.out.println(user.getEmail());
		User user2 = userMapper.findByUsername("hellokitty");
		System.out.println(user2.getUsername());
		System.out.println(user2.getEmail());
		List<User> userList = userMapper.findAll();
		for (User temp : userList) {
			System.out.println(temp.getUsername());
		}
		session.commit();
		session.close();
	}
}

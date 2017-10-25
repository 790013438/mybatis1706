package com.qfedu.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.domain.User;
import com.qfedu.mapper.UserMapper;

public class Test01 {

	public static void main(String[] args) throws IOException {
		User user = new User();
		user.setUsername("wangdachui");
		user.setPassword("1qaz2wsx");
		user.setEmail("chuichui@qq.com");
		InputStream inputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		boolean flag = userMapper.save(user);
		System.out.println(flag);
		session.commit();
		session.close();
	}
}

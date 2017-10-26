package com.qfedu.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.domain.User;
import com.qfedu.mapper.UserMapper;

public class Test09 {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		Map<String, Object> params  = new HashMap<>();
		params.put("userid", 5);
		params.put("username", "wangdachui");
		params.put("password", "123123");
		params.put("email", "twoshits@yahoo.com.cn");
		List<User> users = userMapper.findByParam(params);
		for (User user : users) {
			System.out.println(user.getUsername());
			System.out.println(user.getEmail());
		}
		session.commit();
		session.close();
	}
}

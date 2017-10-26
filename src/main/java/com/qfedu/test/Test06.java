package com.qfedu.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.domain.Account;
import com.qfedu.domain.User;
import com.qfedu.mapper.AccountMapper;
import com.qfedu.mapper.UserMapper;

public class Test06 {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = userMapper.findByUsername("wangdachui");
		Account account = new Account();
		account.setNumber("2233445566778899");
		account.setBalance(1000000.0);
		account.setUser(user);
		AccountMapper accountMapper = session.getMapper(AccountMapper.class);
		accountMapper.save(account);
		session.commit();
		session.close();
	}
}

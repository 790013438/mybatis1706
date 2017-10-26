package com.qfedu.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qfedu.domain.Account;
import com.qfedu.mapper.AccountMapper;

public class Test07 {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = 
				Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sessionFactory.openSession();
		AccountMapper accountMapper = session.getMapper(AccountMapper.class);
		Account account = accountMapper.findById(2);
		System.out.println(account.getNumber());
		System.out.println(account.getUser().getUsername());
		System.out.println(account.getUser().getEmail());
		session.commit();
		session.close();
	}
}

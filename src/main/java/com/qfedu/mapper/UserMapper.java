package com.qfedu.mapper;

import java.util.List;

import com.qfedu.domain.User;

public interface UserMapper {
	
	boolean deleteById(Integer id);
	
	boolean delete(User user);
	
	boolean update(User user);

	boolean save(User user);
	
	User findById(Integer id);
	
	User findByUsername(String username);
	
	List<User> findAll();
}

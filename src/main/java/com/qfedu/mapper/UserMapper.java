package com.qfedu.mapper;

import java.util.List;
import java.util.Map;

import com.qfedu.domain.User;

public interface UserMapper {
	
	List<User> findByParam(Map<String, Object> params);
	
	boolean deleteById(Integer id);
	
	boolean delete(User user);
	
	boolean update(User user);

	boolean save(User user);
	
	User findById(Integer id);
	
	User findByUsername(String username);
	
	List<User> findAll();
}

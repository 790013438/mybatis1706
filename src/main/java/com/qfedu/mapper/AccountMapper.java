package com.qfedu.mapper;

import com.qfedu.domain.Account;

public interface AccountMapper {

	boolean save(Account account);
	
	Account findById(Integer id);
}

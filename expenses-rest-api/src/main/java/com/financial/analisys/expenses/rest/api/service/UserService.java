package com.financial.analisys.expenses.rest.api.service;

import java.util.List;

import com.financial.analisys.expenses.rest.api.domain.UserBO;

public interface UserService {

	UserBO createUser(UserBO user);

	void updateUser(UserBO user);

	void deleteUser(String id);

	UserBO getUser(String id);

	List<UserBO> getAllUsers();

}

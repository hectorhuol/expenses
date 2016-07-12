package com.financial.analisys.expenses.gateways;

import java.util.List;

import com.financial.analisys.expenses.domain.User;

public interface UsersGateway {

	public User createUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public User getUser(User user);

	public List<User> getAllUsers();

}

package com.financial.analisys.expenses.managers;

import java.util.List;

import com.financial.analisys.expenses.domain.User;
import com.financial.analisys.expenses.exceptions.UserException;
import com.financial.analisys.expenses.gateways.UsersGateway;
import com.financial.analisys.expenses.validators.UsersValidator;
import com.financial.analisys.expenses.validators.ValidationResult;
import com.financial.analisys.expenses.validators.ValidationType;

public class UsersManager {

	private UsersGateway usersGateway;
	private UsersValidator usersValidator;

	private UsersManager() {
	}

	private UsersManager(UsersGateway usersGateway,
			UsersValidator usersValidator) {
		this.usersGateway = usersGateway;
		this.usersValidator = usersValidator;
	}

	public static UsersManager getNewUsersManager(UsersGateway usersGateway,
			UsersValidator usersValidator) {
		return new UsersManager(usersGateway, usersValidator);
	}

	public User createUser(User user) {
		try {
			ValidationResult result = usersValidator.validate(user,
					ValidationType.CREATE);
			if (result.isValid())
				return usersGateway.createUser(user);
			throw new UserException(result.getReason());
		} catch (Exception e) {
			throw new UserException(e);
		}
	}

	public void updateUser(User user) {
		try {
			ValidationResult result = usersValidator.validate(user,
					ValidationType.UPDATE);
			if (result.isValid())
				usersGateway.updateUser(user);
			else
				throw new UserException(result.getReason());
		} catch (Exception e) {
			throw new UserException(e);
		}
	}

	public void deleteUser(User user) {
		try {
			ValidationResult result = usersValidator.validate(user,
					ValidationType.DELETE);
			if (result.isValid())
				usersGateway.deleteUser(user);
			else
				throw new UserException(result.getReason());
		} catch (Exception e) {
			throw new UserException(e);
		}
	}

	public User getUser(User user) {
		try {
			ValidationResult result = usersValidator.validate(user,
					ValidationType.READ);
			if (result.isValid())
				return usersGateway.getUser(user);
			throw new UserException(result.getReason());
		} catch (Exception e) {
			throw new UserException(e);
		}
	}

	public List<User> getAllUsers() {
		return usersGateway.getAllUsers();
	}
}
package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.domain.User;
import com.financial.analisys.expenses.exceptions.UserException;
import com.financial.analisys.expenses.gateways.UsersGateway;
import com.financial.analisys.expenses.rest.api.domain.UserBO;
import com.financial.analisys.expenses.rest.api.repository.UserRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPIUsersGatewayImpl implements UsersGateway {

	private UserRepository userRepository;
	
	public RestAPIUsersGatewayImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	public User createUser(User user) {
		try {
			UserBO userBO = userRepository.save(BOUtils.transformObject(user, UserBO.class));
			user.setUserId(userBO.getUserId());
			return user;
		} catch (Exception e) {
			throw new UserException(e);
		}
	}

	
	public void updateUser(User user) {
		try {
			userRepository.save(BOUtils.transformObject(user, UserBO.class));
		} catch (Exception e) {
			throw new UserException("The user could not be updated");
		}		
	}

	public void deleteUser(User user) {
		try {
			userRepository.delete(BOUtils.transformObject(user, UserBO.class));
		} catch (Exception e) {
			throw new UserException("The user could not be updated");
		}
	}

	public User getUser(User user) {
		try {
			UserBO userBO = userRepository.findOne(user.getUserId());
			return BOUtils.transformObject(userBO, User.class);
		} catch (Exception e) {
			throw new UserException("The user could not be updated");
		}

	}

	public List<User> getAllUsers() {
		try {
			List<UserBO> list = userRepository.findAll();			
			return BOUtils.transformObjectList(list, User.class);
		} catch (Exception e) {
			throw new UserException("The user could not be updated");
		}
	}
}
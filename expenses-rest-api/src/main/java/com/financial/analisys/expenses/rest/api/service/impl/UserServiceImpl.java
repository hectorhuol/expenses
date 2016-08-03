package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.domain.User;
import com.financial.analisys.expenses.rest.api.domain.UserBO;
import com.financial.analisys.expenses.rest.api.service.UserService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public UserBO createUser(UserBO userBO) {
		try {
			User user = expensesAPIFacade.getUsersManager().createUser(
					BOUtils.transformObject(userBO, User.class));
			userBO.setUserId(user.getUserId());
			return userBO;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateUser(UserBO userBO) {
		try {
			expensesAPIFacade.getUsersManager().updateUser(
					BOUtils.transformObject(userBO, User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteUser(String id) {
		try {
			User user = new User();
			user.setUserId(id);
			expensesAPIFacade.getUsersManager().deleteUser(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public UserBO getUser(String id) {
		try {
			User user = new User();
			user.setUserId(id);
			user = expensesAPIFacade.getUsersManager().getUser(user);
			return BOUtils.transformObject(user, UserBO.class);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<UserBO> getAllUsers() {
		try {
			List<User> user = expensesAPIFacade.getUsersManager().getAllUsers();
			return BOUtils.transformObjectList(user, UserBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

package com.financial.analisys.expenses.rest.api.service.expensesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.factory.FinancialsAnalisysFactory;
import com.financial.analisys.expenses.factory.GatewayType;
import com.financial.analisys.expenses.factory.ValidatorType;
import com.financial.analisys.expenses.managers.UsersManager;
import com.financial.analisys.expenses.rest.api.repository.UserRepository;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.factory.ExpensesAPIFactoryImpl;

@Service
public class ExpensesAPIFacade {	
	
	private UsersManager usersManager;
	private FinancialsAnalisysFactory financialsFactory;
	
	@Autowired
	public ExpensesAPIFacade(UserRepository userRepository) {
		financialsFactory = new ExpensesAPIFactoryImpl(userRepository);
		usersManager = UsersManager.getNewUsersManager(
				financialsFactory.createUsersGateway(GatewayType.CUSTOM),
				financialsFactory.createUsersValidator(ValidatorType.DEFAULT));
	}

	public UsersManager getUsersManager() {
		return usersManager;
	}

}

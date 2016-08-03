package com.financial.analisys.expenses.rest.api.service.expensesImpl.factory;

import com.financial.analisys.expenses.factory.GatewayType;
import com.financial.analisys.expenses.factory.impl.FinancialsAnalisysFactoryImpl;
import com.financial.analisys.expenses.gateways.UsersGateway;
import com.financial.analisys.expenses.rest.api.repository.UserRepository;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway.RestAPIUsersGatewayImpl;

public class ExpensesAPIFactoryImpl extends FinancialsAnalisysFactoryImpl {
	
	private UserRepository userRepository;

	public ExpensesAPIFactoryImpl(UserRepository userRepository) {
		this.userRepository = userRepository;		
	}
	
	public UsersGateway createUsersGateway(GatewayType gatewayType) {
		switch (gatewayType) {
		case CUSTOM:
			return new RestAPIUsersGatewayImpl(userRepository);
		default:
			return null;
		}
	}

}
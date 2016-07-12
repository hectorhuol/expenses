package com.financial.analisys.expenses.factory;

import com.financial.analisys.expenses.gateways.CardsGateway;
import com.financial.analisys.expenses.gateways.CategoriesGateway;
import com.financial.analisys.expenses.gateways.CompanionsGateway;
import com.financial.analisys.expenses.gateways.ExpensesGateway;
import com.financial.analisys.expenses.gateways.ExpensesReportsGateway;
import com.financial.analisys.expenses.gateways.UsersGateway;
import com.financial.analisys.expenses.validators.CardsValidator;
import com.financial.analisys.expenses.validators.CategoriesValidator;
import com.financial.analisys.expenses.validators.CompanionsValidator;
import com.financial.analisys.expenses.validators.ExpensesValidator;
import com.financial.analisys.expenses.validators.UsersValidator;

public interface FinancialsAnalisysFactory {

	public CardsGateway createCardsGateway(GatewayType cardsGatewayType);

	public CategoriesGateway createCategoriesGateway(
			GatewayType categoriesGatewayType);

	public CompanionsGateway createCompanionsGateway(
			GatewayType companionsGatewayType);

	public ExpensesGateway createExpensesGateway(GatewayType expensesGatewayType);

	public ExpensesReportsGateway createExpensesReportsGateway(
			GatewayType expensesReportsGatewayType);

	public UsersGateway createUsersGateway(GatewayType usersGatewayType);

	public UsersValidator createUsersValidator(ValidatorType validatorType);

	public CategoriesValidator createCategoriesValidator(
			ValidatorType validatorType);

	public CardsValidator createCardsValidator(ValidatorType validatorType);

	public CompanionsValidator createCompanionsValidator(
			ValidatorType validatorType);

	public ExpensesValidator createExpensesValidator(ValidatorType validatorType);

}

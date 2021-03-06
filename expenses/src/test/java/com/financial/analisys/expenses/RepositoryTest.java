package com.financial.analisys.expenses;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import com.financial.analisys.expenses.domain.Card;
import com.financial.analisys.expenses.domain.CardType;
import com.financial.analisys.expenses.domain.Category;
import com.financial.analisys.expenses.domain.Companion;
import com.financial.analisys.expenses.domain.Expense;
import com.financial.analisys.expenses.domain.User;
import com.financial.analisys.expenses.factory.FinancialsAnalisysFactory;
import com.financial.analisys.expenses.factory.GatewayType;
import com.financial.analisys.expenses.factory.impl.FinancialsAnalisysFactoryImpl;
import com.financial.analisys.expenses.gateways.CardsGateway;
import com.financial.analisys.expenses.gateways.CategoriesGateway;
import com.financial.analisys.expenses.gateways.CompanionsGateway;
import com.financial.analisys.expenses.gateways.ExpensesGateway;
import com.financial.analisys.expenses.gateways.ExpensesReportsGateway;
import com.financial.analisys.expenses.gateways.UsersGateway;
import com.financial.analisys.expenses.gateways.mapimpl.Repository;
import com.financial.analisys.expenses.utils.FinancialUtils;

public class RepositoryTest {

	FinancialsAnalisysFactory financialsAnalisysFactory;
	CardsGateway cardsGateway;
	CategoriesGateway categoriesGateway;
	CompanionsGateway companionsGateway;
	ExpensesGateway expensesGateway;
	ExpensesReportsGateway expensesReportsGateway;
	UsersGateway usersGateway;
	Card card;
	Category category;
	Companion companion;
	Expense expense;
	User user;

	@Before
	public void setup() {
		initData();
	}

	private void initData() {
		financialsAnalisysFactory = new FinancialsAnalisysFactoryImpl();

		card = new Card();
		card.setCardId("1");
		card.setName("Name");
		card.setType(CardType.CREDIT);

		category = new Category();
		category.setCategoryId("1");
		category.setName("Name");

		companion = new Companion();
		companion.setCompanionId("1");
		companion.setName("Name");
		companion.setAlias("Alias");

		user = new User();
		user.setUserId("1");
		user.setUserName("Name");
		user.setPassword("1234");

		expense = new Expense();
		expense.setExpenseId("1");
		expense.setValue(10.0);
		expense.setDateAndHour(FinancialUtils
				.getLocalDateTimeString(LocalDateTime.now()));
		expense.setLocation("Location");
		expense.setCity("City");
		expense.setUser(user);
		expense.getCompanions().add(companion);
		expense.setCategory(category);
		expense.setCard(card);

		Repository
				.setPropertiesPath("src/test/resources/repository.properties");

	}

	@Test
	public void testCardsRepository() {
		cardsGateway = financialsAnalisysFactory
				.createCardsGateway(GatewayType.MAP);
		cardsGateway.createCard(card);
	}

	@Test
	public void testCategoriesRepository() {
		categoriesGateway = financialsAnalisysFactory
				.createCategoriesGateway(GatewayType.MAP);
		categoriesGateway.createCategory(category);
	}

	@Test
	public void testCompanionsRepository() {
		companionsGateway = financialsAnalisysFactory
				.createCompanionsGateway(GatewayType.MAP);
		companionsGateway.createCompanion(companion);
	}

	@Test
	public void testUsersGateway() {
		usersGateway = financialsAnalisysFactory
				.createUsersGateway(GatewayType.MAP);
		usersGateway.createUser(user);
	}

	@Test
	public void testExpensesRepository() {
		expensesGateway = financialsAnalisysFactory
				.createExpensesGateway(GatewayType.MAP);
		expensesGateway.createExpense(expense);
	}
}
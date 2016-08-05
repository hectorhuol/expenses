package com.financial.analisys.expenses.managers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.financial.analisys.expenses.domain.Category;
import com.financial.analisys.expenses.domain.Companion;
import com.financial.analisys.expenses.domain.Expense;
import com.financial.analisys.expenses.domain.User;
import com.financial.analisys.expenses.exceptions.ExpenseException;
import com.financial.analisys.expenses.gateways.ExpensesGateway;
import com.financial.analisys.expenses.gateways.ExpensesReportsGateway;
import com.financial.analisys.expenses.validators.ExpensesValidator;
import com.financial.analisys.expenses.validators.ValidationResult;
import com.financial.analisys.expenses.validators.ValidationType;

public class ExpensesManager {

	private ExpensesGateway expensesGateway;
	private ExpensesReportsGateway expensesReportsGateway;
	private ExpensesValidator expensesValidator;

	private ExpensesManager() {
	}

	private ExpensesManager(ExpensesGateway expensesGateway,
			ExpensesReportsGateway expensesReportsGateway,
			ExpensesValidator expensesValidator) {
		this.expensesGateway = expensesGateway;
		this.expensesValidator = expensesValidator;
		this.expensesReportsGateway = expensesReportsGateway;
	}

	public static ExpensesManager getNewExpensesManager(
			ExpensesGateway expensesGateway,
			ExpensesReportsGateway expensesReportsGateway,
			ExpensesValidator expensesValidator) {
		return new ExpensesManager(expensesGateway, expensesReportsGateway,
				expensesValidator);
	}

	public Expense createExpense(Expense expense) {
		try {
			ValidationResult result = expensesValidator.validate(expense,
					ValidationType.CREATE);
			if (result.isValid())
				return expensesGateway.createExpense(expense);
			throw new ExpenseException(result.getReason());
		} catch (Exception e) {
			throw new ExpenseException(e);
		}

	}

	public void updateExpense(Expense expense) {
		try {
			ValidationResult result = expensesValidator.validate(expense,
					ValidationType.UPDATE);
			if (result.isValid())
				expensesGateway.updateExpense(expense);
			else
				throw new ExpenseException(result.getReason());
		} catch (Exception e) {
			throw new ExpenseException(e);
		}
	}

	public void deleteExpense(Expense expense) {
		try {
			ValidationResult result = expensesValidator.validate(expense,
					ValidationType.DELETE);
			if (result.isValid())
				expensesGateway.deleteExpense(expense);
			else
				throw new ExpenseException(result.getReason());
		} catch (Exception e) {
			throw new ExpenseException(e);
		}
	}

	public Expense getExpense(Expense expense) {
		try {
			ValidationResult result = expensesValidator.validate(expense,
					ValidationType.READ);
			if (result.isValid())
				return expensesGateway.getExpense(expense);
			throw new ExpenseException(result.getReason());
		} catch (Exception e) {
			throw new ExpenseException(e);
		}
	}

	public List<Expense> getAllUserExpenses(User user) {
		return expensesGateway.getAllUserExpenses(user);
	}

	public List<Expense> getExpensesByCategoryByUser(Category category,
			User user) {
		return expensesReportsGateway.getExpensesByCategoryByUser(category,
				user);
	}

	public List<Expense> getExpensesByCityByUser(String cityName, User user) {
		return expensesReportsGateway.getExpensesByCityByUser(cityName, user);
	}

	public List<Expense> getExpensesByCompanionsByUser(
			List<Companion> companions, User user) {
		return expensesReportsGateway.getExpensesByCompanionsByUser(companions,
				user);
	}

	public List<Expense> getExpensesByMonthByUser(LocalDate month, User user) {
		return expensesReportsGateway.getExpensesByMonthByUser(month, user);
	}

	public List<Expense> getExpensesByDayByUser(LocalDate day, User user) {
		return expensesReportsGateway.getExpensesByDayByUser(day, user);
	}

	public List<Expense> getExpensesBetweenDatesByUser(LocalDateTime startDate,
			LocalDateTime finishDate, User user) {
		return expensesReportsGateway.getExpensesBetweenDatesByUser(startDate,
				finishDate, user);
	}
}
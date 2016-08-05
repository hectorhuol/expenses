package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.domain.Category;
import com.financial.analisys.expenses.domain.Companion;
import com.financial.analisys.expenses.domain.Expense;
import com.financial.analisys.expenses.domain.User;
import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.service.ExpenseService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;
import com.financial.analisys.expenses.utils.FinancialUtils;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public ExpenseBO createExpense(ExpenseBO expenseBO) {
		try {
			Expense expense = expensesAPIFacade.getExpensesManager()
					.createExpense(
							BOUtils.transformObject(expenseBO, Expense.class));
			expenseBO.setExpenseId(expense.getExpenseId());
			return expenseBO;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateExpense(ExpenseBO expenseBO) {
		try {
			expensesAPIFacade.getExpensesManager().updateExpense(
					BOUtils.transformObject(expenseBO, Expense.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteExpense(String id) {
		try {
			Expense expense = new Expense();
			expense.setExpenseId(id);
			expensesAPIFacade.getExpensesManager().deleteExpense(expense);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ExpenseBO getExpense(String id) {
		try {
			Expense expense = new Expense();
			expense.setExpenseId(id);
			expense = expensesAPIFacade.getExpensesManager()
					.getExpense(expense);
			return BOUtils.transformObject(expense, ExpenseBO.class);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ExpenseBO> getAllUserExpenses(String userId) {
		try {
			User user = new User();
			user.setUserId(userId);
			List<Expense> expenses = expensesAPIFacade.getExpensesManager()
					.getAllUserExpenses(user);
			return BOUtils.transformObjectList(expenses, ExpenseBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ExpenseBO> getExpensesByCategoryByUser(String categoryId,
			String userId) {
		try {
			User user = new User();
			user.setUserId(userId);
			Category category = new Category();
			category.setCategoryId(categoryId);
			List<Expense> expenses = expensesAPIFacade.getExpensesManager()
					.getExpensesByCategoryByUser(category, user);
			return BOUtils.transformObjectList(expenses, ExpenseBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ExpenseBO> getExpensesByCityByUser(String cityName,
			String userId) {
		try {
			User user = new User();
			user.setUserId(userId);
			List<Expense> expenses = expensesAPIFacade.getExpensesManager()
					.getExpensesByCityByUser(cityName, user);
			return BOUtils.transformObjectList(expenses, ExpenseBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ExpenseBO> getExpensesByCompanionsByUser(
			List<String> companionsIds, String userId) {
		try {
			User user = new User();
			user.setUserId(userId);
			List<Companion> companions = getCompanionsList(companionsIds);
			List<Expense> expenses = expensesAPIFacade.getExpensesManager()
					.getExpensesByCompanionsByUser(companions, user);
			return BOUtils.transformObjectList(expenses, ExpenseBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private List<Companion> getCompanionsList(List<String> companionsIds) {
		List<Companion> companions = new ArrayList<Companion>();
		for (String companionId : companionsIds) {
			Companion companion = new Companion();
			companion.setCompanionId(companionId);
			companions.add(companion);
		}
		return companions;
	}

	@Override
	public List<ExpenseBO> getExpensesByMonthByUser(String month, String userId) {
		try {
			User user = new User();
			user.setUserId(userId);
			List<Expense> expenses = expensesAPIFacade.getExpensesManager()
					.getExpensesByMonthByUser(
							FinancialUtils.getLocalDateTime(month)
									.toLocalDate(), user);
			return BOUtils.transformObjectList(expenses, ExpenseBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ExpenseBO> getExpensesByDayByUser(String day, String userId) {
		try {
			User user = new User();
			user.setUserId(userId);
			List<Expense> expenses = expensesAPIFacade.getExpensesManager()
					.getExpensesByDayByUser(
							FinancialUtils.getLocalDateTime(day).toLocalDate(),
							user);
			return BOUtils.transformObjectList(expenses, ExpenseBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<ExpenseBO> getExpensesBetweenDatesByUser(String startDate,
			String finishDate, String userId) {
		try {
			User user = new User();
			user.setUserId(userId);
			List<Expense> expenses = expensesAPIFacade.getExpensesManager()
					.getExpensesBetweenDatesByUser(
							FinancialUtils.getLocalDateTime(startDate),
							FinancialUtils.getLocalDateTime(finishDate), user);
			return BOUtils.transformObjectList(expenses, ExpenseBO.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}

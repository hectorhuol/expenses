package com.financial.analisys.expenses.rest.api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.financial.analisys.expenses.domain.Category;
import com.financial.analisys.expenses.domain.Companion;
import com.financial.analisys.expenses.domain.Expense;
import com.financial.analisys.expenses.domain.User;

public interface ExpenseService {

	Expense createExpense(Expense expense);

	void updateExpense(Expense expense);

	void deleteExpense(Expense expense);

	Expense getExpense(Expense expense);

	List<Expense> getAllUsersExpenses(User user);
	
	List<Expense> getExpensesByCategoryByUser(Category category,
			User user);

	List<Expense> getExpensesByCityByUser(String cityName,
			User user);

	List<Expense> getExpensesByCompanionsByUser(
			List<Companion> companions, User user);

	List<Expense> getExpensesByMonthByUser(LocalDate month,
			User user);

	List<Expense> getExpensesByDayByUser(LocalDate day, User user);

	List<Expense> getExpensesBetweenDatesByUser(LocalDateTime startDate,
			LocalDateTime finishDate, User user);

}

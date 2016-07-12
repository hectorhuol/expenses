package com.financial.analisys.expenses.gateways;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.financial.analisys.expenses.domain.Category;
import com.financial.analisys.expenses.domain.Companion;
import com.financial.analisys.expenses.domain.Expense;
import com.financial.analisys.expenses.domain.User;

public interface ExpensesReportsGateway {

	public List<Expense> getExpensesByCategoryByUser(Category category,
			User user);

	public List<Expense> getExpensesByCityByUser(String cityName,
			User user);

	public List<Expense> getExpensesByCompanionsByUser(
			List<Companion> companions, User user);

	public List<Expense> getExpensesByMonthByUser(LocalDate month,
			User user);

	public List<Expense> getExpensesByDayByUser(LocalDate day, User user);

	public List<Expense> getExpensesBetweenDatesByUser(LocalDateTime startDate,
			LocalDateTime finishDate, User user);

}

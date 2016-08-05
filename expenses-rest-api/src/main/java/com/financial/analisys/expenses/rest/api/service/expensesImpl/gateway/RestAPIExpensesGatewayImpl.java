package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.domain.Expense;
import com.financial.analisys.expenses.domain.User;
import com.financial.analisys.expenses.exceptions.ExpenseException;
import com.financial.analisys.expenses.gateways.ExpensesGateway;
import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.repository.ExpenseRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPIExpensesGatewayImpl implements ExpensesGateway {

	private ExpenseRepository expenseRepository;

	public RestAPIExpensesGatewayImpl(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	@Override
	public Expense createExpense(Expense expense) {
		try {
			ExpenseBO expenseBO = expenseRepository.save(BOUtils
					.transformObject(expense, ExpenseBO.class));
			expense.setExpenseId(expenseBO.getExpenseId());
			return expense;
		} catch (Exception e) {
			throw new ExpenseException(e);
		}
	}
	
	@Override
	public void updateExpense(Expense expense) {
		try {
			expenseRepository.save(BOUtils.transformObject(expense,
					ExpenseBO.class));
		} catch (Exception e) {
			throw new ExpenseException(e);
		}
	}
	
	@Override
	public void deleteExpense(Expense expense) {
		try {
			expenseRepository.delete(BOUtils.transformObject(expense,
					ExpenseBO.class));
		} catch (Exception e) {
			throw new ExpenseException(e);
		}
	}

	@Override
	public Expense getExpense(Expense expense) {
		try {
			ExpenseBO expenseBO = expenseRepository.findOne(expense
					.getExpenseId());
			return BOUtils.transformObject(expenseBO, Expense.class);
		} catch (Exception e) {
			throw new ExpenseException(e);
		}

	}
	
	@Override
	public List<Expense> getAllUserExpenses(User user) {
		try {
			List<ExpenseBO> list = expenseRepository.findAll();
			return BOUtils.transformObjectList(list, Expense.class);
		} catch (Exception e) {
			throw new ExpenseException(e);
		}
	}
}
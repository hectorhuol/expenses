package com.financial.analisys.expenses.rest.api.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.financial.analisys.expenses.exceptions.CardException;
import com.financial.analisys.expenses.exceptions.CategoryException;
import com.financial.analisys.expenses.exceptions.CompanionException;
import com.financial.analisys.expenses.exceptions.ExpenseException;
import com.financial.analisys.expenses.exceptions.TechnicalException;
import com.financial.analisys.expenses.exceptions.UserException;
import com.financial.analisys.expenses.rest.api.error.model.ErrorModel;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = TechnicalException.class)
	public ResponseEntity<ErrorModel> handleTechnicalException(
			HttpServletRequest req, TechnicalException e) {
		ErrorModel error = new ErrorModel();
		error.setMessage(e.getMessage());
		error.setErrorURI(req.getRequestURI());
		return new ResponseEntity<ErrorModel>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorModel> handleRuntimeException(
			HttpServletRequest req, RuntimeException e) {
		ErrorModel error = new ErrorModel();
		error.setMessage(e.getMessage());
		error.setErrorURI(req.getRequestURI());
		return new ResponseEntity<ErrorModel>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = CardException.class)
	public ResponseEntity<ErrorModel> handleCardException(
			HttpServletRequest req, CardException e) {
		ErrorModel error = new ErrorModel();
		error.setMessage(e.getMessage());
		error.setErrorURI(req.getRequestURI());
		return new ResponseEntity<ErrorModel>(error, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = CategoryException.class)
	public ResponseEntity<ErrorModel> handleCategoryException(
			HttpServletRequest req, CategoryException e) {
		ErrorModel error = new ErrorModel();
		error.setMessage(e.getMessage());
		error.setErrorURI(req.getRequestURI());
		return new ResponseEntity<ErrorModel>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = CompanionException.class)
	public ResponseEntity<ErrorModel> handleCompanionException(
			HttpServletRequest req, CompanionException e) {
		ErrorModel error = new ErrorModel();
		error.setMessage(e.getMessage());
		error.setErrorURI(req.getRequestURI());
		return new ResponseEntity<ErrorModel>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ExpenseException.class)
	public ResponseEntity<ErrorModel> handleExpenseException(
			HttpServletRequest req, ExpenseException e) {
		ErrorModel error = new ErrorModel();
		error.setMessage(e.getMessage());
		error.setErrorURI(req.getRequestURI());
		return new ResponseEntity<ErrorModel>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<ErrorModel> handleUserException(
			HttpServletRequest req, UserException e) {
		ErrorModel error = new ErrorModel();
		error.setMessage(e.getMessage());
		error.setErrorURI(req.getRequestURI());
		return new ResponseEntity<ErrorModel>(error, HttpStatus.BAD_REQUEST);
	}

}

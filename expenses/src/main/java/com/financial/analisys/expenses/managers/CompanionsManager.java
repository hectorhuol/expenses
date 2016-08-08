package com.financial.analisys.expenses.managers;

import java.util.List;

import com.financial.analisys.expenses.domain.Companion;
import com.financial.analisys.expenses.exceptions.CompanionException;
import com.financial.analisys.expenses.exceptions.TechnicalException;
import com.financial.analisys.expenses.gateways.CompanionsGateway;
import com.financial.analisys.expenses.validators.CompanionsValidator;
import com.financial.analisys.expenses.validators.ValidationResult;
import com.financial.analisys.expenses.validators.ValidationType;

public class CompanionsManager {

	private CompanionsGateway companionsGateway;
	private CompanionsValidator companionsValidator;

	private CompanionsManager() {
	}

	private CompanionsManager(CompanionsGateway companionsGateway,
			CompanionsValidator companionsValidator) {
		this.companionsGateway = companionsGateway;
		this.companionsValidator = companionsValidator;
	}

	public static CompanionsManager getNewCompanionsManager(
			CompanionsGateway companionsGateway,
			CompanionsValidator companionsValidator) {
		return new CompanionsManager(companionsGateway, companionsValidator);
	}

	public Companion createCompanion(Companion companion) {
		try {
			ValidationResult result = companionsValidator.validate(companion,
					ValidationType.CREATE);
			if (result.isValid())
				return companionsGateway.createCompanion(companion);
			throw new CompanionException(result.getReason());
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	public void updateCompanion(Companion companion) {
		try {
			ValidationResult result = companionsValidator.validate(companion,
					ValidationType.UPDATE);
			if (result.isValid())
				companionsGateway.updateCompanion(companion);
			else
				throw new CompanionException(result.getReason());
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	public void deleteCompanion(Companion companion) {
		try {
			ValidationResult result = companionsValidator.validate(companion,
					ValidationType.DELETE);
			if (result.isValid())
				companionsGateway.deleteCompanion(companion);
			else
				throw new CompanionException(result.getReason());
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	public Companion getCompanion(Companion companion) {
		try {
			ValidationResult result = companionsValidator.validate(companion,
					ValidationType.READ);
			if (result.isValid())
				return companionsGateway.getCompanion(companion);
			throw new CompanionException(result.getReason());
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	public List<Companion> getAllCompanions() {
		return companionsGateway.getAllCompanions();
	}
}
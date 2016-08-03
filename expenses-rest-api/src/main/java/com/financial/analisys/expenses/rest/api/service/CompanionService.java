package com.financial.analisys.expenses.rest.api.service;

import java.util.List;

import com.financial.analisys.expenses.domain.Companion;

public interface CompanionService {

	public Companion createCompanion(Companion companion);

	public void updateCompanion(Companion companion);

	public void deleteCompanion(Companion companion);

	public Companion getCompanion(Companion companion);

	public List<Companion> getAllCompanions();

}

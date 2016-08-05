package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.domain.Companion;
import com.financial.analisys.expenses.exceptions.CompanionException;
import com.financial.analisys.expenses.gateways.CompanionsGateway;
import com.financial.analisys.expenses.rest.api.domain.CompanionBO;
import com.financial.analisys.expenses.rest.api.repository.CompanionRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPICompanionsGatewayImpl implements CompanionsGateway {

	private CompanionRepository companionRepository;

	public RestAPICompanionsGatewayImpl(CompanionRepository companionRepository) {
		this.companionRepository = companionRepository;
	}

	@Override
	public Companion createCompanion(Companion companion) {
		try {
			CompanionBO companionBO = companionRepository.save(BOUtils
					.transformObject(companion, CompanionBO.class));
			companion.setCompanionId(companionBO.getCompanionId());
			return companion;
		} catch (Exception e) {
			throw new CompanionException(e);
		}
	}

	@Override
	public void updateCompanion(Companion companion) {
		try {
			companionRepository.save(BOUtils.transformObject(companion,
					CompanionBO.class));
		} catch (Exception e) {
			throw new CompanionException(e);
		}
	}
	
	@Override
	public void deleteCompanion(Companion companion) {
		try {
			companionRepository.delete(BOUtils.transformObject(companion,
					CompanionBO.class));
		} catch (Exception e) {
			throw new CompanionException(e);
		}
	}
	
	@Override
	public Companion getCompanion(Companion companion) {
		try {
			CompanionBO companionBO = companionRepository.findOne(companion
					.getCompanionId());
			return BOUtils.transformObject(companionBO, Companion.class);
		} catch (Exception e) {
			throw new CompanionException(e);
		}

	}
	
	@Override
	public List<Companion> getAllCompanions() {
		try {
			List<CompanionBO> list = companionRepository.findAll();
			return BOUtils.transformObjectList(list, Companion.class);
		} catch (Exception e) {
			throw new CompanionException(e);
		}
	}
}
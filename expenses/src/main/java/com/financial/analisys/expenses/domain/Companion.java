package com.financial.analisys.expenses.domain;

public class Companion {

	private String companionId;
	private String name;
	private String alias;

	public String getCompanionId() {
		return companionId;
	}

	public void setCompanionId(String companionId) {
		this.companionId = companionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Companion) {
			Companion companion = (Companion) obj;
			return companion.getCompanionId().equals(this.getCompanionId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(this.getCompanionId()) * 17;
	}
}
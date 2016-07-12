package com.financial.analisys.expenses.domain;

public class Category {

	private String categoryId;
	private String name;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Category) {
			Category category = (Category) obj;
			return category.getCategoryId().equals(this.getCategoryId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.valueOf(this.getCategoryId()) * 17;
	}
}
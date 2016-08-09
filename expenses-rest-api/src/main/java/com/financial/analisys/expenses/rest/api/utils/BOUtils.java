package com.financial.analisys.expenses.rest.api.utils;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.financial.analisys.expenses.exceptions.TechnicalException;

public class BOUtils {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T transformObject(Object objectSource,
			Class<T> destinationType){
		try {
			String json = getJSON(objectSource);
			T type = objectMapper.readValue(json, destinationType);
			return type;

		} catch (Exception e) {
			throw new TechnicalException("The object could not be transformed", e);
		}
	}

	public static <T> List<T> transformObjectList(Object objectSource,
			Class<T> destinationType) {
		try {
			String json = getJSON(objectSource);
			CollectionType javaType = objectMapper.getTypeFactory()
					.constructCollectionType(List.class, destinationType);
			List<T> type = objectMapper.readValue(json, javaType);
			return type;

		} catch (Exception e) {
			throw new TechnicalException("The list could not be transformed");
		}
	}

	private static String getJSON(Object objectSource)
			throws JsonProcessingException {
		String json = null;
		if (objectSource != null)
			json = objectMapper.writeValueAsString(objectSource);
		return json;
	}

	public static boolean isObjectNull(Object object) {
		return object != null;
	}
}

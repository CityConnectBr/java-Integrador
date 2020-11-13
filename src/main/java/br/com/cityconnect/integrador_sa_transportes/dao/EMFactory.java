package br.com.cityconnect.integrador_sa_transportes.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;

public final class EMFactory {

	private EMFactory() {
	}

	// /////////////////////////////////////////////////////////////////
	// ENTITY MANAGER FACTORY
	// /////////////////////////////////////////////////////////////////

	private static EntityManagerFactory entityManagerFactory;

	protected static EntityManagerFactory entityManagerFactorInstance() {
		if (entityManagerFactory == null) {
			Map<String, Object> addedOrOverridenProperties = new HashMap<>();
			try {
				PropertiesUtil pu = new PropertiesUtil();

				addedOrOverridenProperties.put("javax.persistence.jdbc.url", "jdbc:mysql://"+pu.getValue(PropertiesUtil.KEY_DB_HOST)+"/"+pu.getValue(PropertiesUtil.KEY_DB_NAME)+"?useTimezone=true&serverTimezone=America/Sao_Paulo");
				addedOrOverridenProperties.put("javax.persistence.jdbc.user", pu.getValue(PropertiesUtil.KEY_DB_USER));
				addedOrOverridenProperties.put("javax.persistence.jdbc.password", pu.getValue(PropertiesUtil.KEY_DB_PASS));
				
			} catch (IOException e) {
				e.printStackTrace();
			}

			entityManagerFactory = Persistence.createEntityManagerFactory("satransportesPU", addedOrOverridenProperties);
		}

		return entityManagerFactory;
	}

}
package br.com.cityconnect.integrador_sa_transportes.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class DAOFactory {

	private DAOFactory() {
	}

	// /////////////////////////////////////////////////////////////////
	// ENTITY MANAGER FACTORY
	// /////////////////////////////////////////////////////////////////

	private static EntityManagerFactory entityManagerFactory;

	protected static EntityManagerFactory entityManagerFactorInstance() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("satransportesPU");
		}

		return entityManagerFactory;
	}

}
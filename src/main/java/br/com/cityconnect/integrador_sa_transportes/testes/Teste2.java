package br.com.cityconnect.integrador_sa_transportes.testes;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.cityconnect.integrador_sa_transportes.annotations.ExcludeGson;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class Teste2 {

	public static void main(String[] args) {
		ExclusionStrategy strategy = new ExclusionStrategy() {
			@Override
			public boolean shouldSkipClass(Class<?> clazz) {
				return false;
			}

			@Override
			public boolean shouldSkipField(FieldAttributes field) {
				return field.getAnnotation(ExcludeGson.class) != null;
			}
		};

		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().addSerializationExclusionStrategy(strategy).create();
		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();

		// Permissionario p =

		for (Permissionario p : permissionarioDAO.findAll()) {

			System.out.println(p);
			System.out.println(gson.toJson(p));
		}

	}

}

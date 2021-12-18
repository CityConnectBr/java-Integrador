package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.EntidadeCurso;

public class EntidadeCursoService extends MainService<EntidadeCurso> {

	public EntidadeCursoService() {
		super("/integracao/entidadescurso");
	}

	@Override
	protected EntidadeCurso jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), EntidadeCurso.class);
	}

	@Override
	protected EntidadeCurso[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), EntidadeCurso[].class);
	}
	
	@Override
	public EntidadeCurso[] getAll() throws Exception {
		return new EntidadeCurso[0];
	}

}

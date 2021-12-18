package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.CursoDoCondutor;

public class CursoDoCondutorService extends MainService<CursoDoCondutor> {

	public CursoDoCondutorService() {
		super("/integracao/cursodocondutor");
	}

	@Override
	protected CursoDoCondutor jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), CursoDoCondutor.class);
	}

	@Override
	protected CursoDoCondutor[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), CursoDoCondutor[].class);
	}
	
	@Override
	public CursoDoCondutor[] getAll() throws Exception {
		return new CursoDoCondutor[0];
	}

}

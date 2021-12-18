package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.TipoDeCurso;

public class TipoDeCursoService extends MainService<TipoDeCurso> {

	public TipoDeCursoService() {
		super("/integracao/tiposdecurso");
	}

	@Override
	protected TipoDeCurso jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), TipoDeCurso.class);
	}

	@Override
	protected TipoDeCurso[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), TipoDeCurso[].class);
	}
	
	@Override
	public TipoDeCurso[] getAll() throws Exception {
		return new TipoDeCurso[0];
	}

}

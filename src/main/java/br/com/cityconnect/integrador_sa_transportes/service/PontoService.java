package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.Ponto;

public class PontoService extends MainService<Ponto> {

	public PontoService() {
		super("/integracao/pontos");
	}

	@Override
	protected Ponto jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), Ponto.class);
	}

	@Override
	protected Ponto[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), Ponto[].class);
	}
	
	@Override
	public Ponto[] getAll() throws Exception {
		return new Ponto[0];
	}

}

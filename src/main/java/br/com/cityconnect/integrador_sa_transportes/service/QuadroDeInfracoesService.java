package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.QuadroDeInfracoes;

public class QuadroDeInfracoesService extends MainService<QuadroDeInfracoes> {

	public QuadroDeInfracoesService() {
		super("/integracao/quadrodeinfracoes");
	}

	@Override
	protected QuadroDeInfracoes jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), QuadroDeInfracoes.class);
	}

	@Override
	protected QuadroDeInfracoes[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), QuadroDeInfracoes[].class);
	}
	
	@Override
	public QuadroDeInfracoes[] getAll() throws Exception {
		return new QuadroDeInfracoes[0];
	}

}

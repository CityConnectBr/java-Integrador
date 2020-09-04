package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.CorVeiculo;

public class CorVeiculoService extends MainService<CorVeiculo> {

	public CorVeiculoService() {
		super("/integracao/coresveiculos");
	}

	@Override
	protected CorVeiculo jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), CorVeiculo.class);
	}

	@Override
	protected CorVeiculo[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), CorVeiculo[].class);

	}

}

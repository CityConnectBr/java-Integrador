package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.TipoVeiculo;

public class TipoVeiculoService extends MainService<TipoVeiculo> {

	public TipoVeiculoService() {
		super("/integracao/tiposveiculos");
	}

	@Override
	protected TipoVeiculo jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), TipoVeiculo.class);
	}

	@Override
	protected TipoVeiculo[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), TipoVeiculo[].class);

	}

}

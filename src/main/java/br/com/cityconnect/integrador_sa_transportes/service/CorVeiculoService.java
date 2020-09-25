package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.CorVeiculo;
import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloCarroceria;

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
	
	@Override
	public CorVeiculo[] getAll() throws Exception {
		return new CorVeiculo[0];
	}

}

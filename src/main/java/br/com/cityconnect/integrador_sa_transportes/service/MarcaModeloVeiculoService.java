package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloVeiculo;

public class MarcaModeloVeiculoService extends MainService<MarcaModeloVeiculo> {

	public MarcaModeloVeiculoService() {
		super("/integracao/marcasmodelosveiculos");
	}

	@Override
	protected MarcaModeloVeiculo jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), MarcaModeloVeiculo.class);
	}

	@Override
	protected MarcaModeloVeiculo[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), MarcaModeloVeiculo[].class);

	}

}

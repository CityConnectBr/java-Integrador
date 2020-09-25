package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.TipoCombustivel;

public class TipoCombustivelService extends MainService<TipoCombustivel> {

	public TipoCombustivelService() {
		super("/integracao/tiposcombustiveis");
	}

	@Override
	protected TipoCombustivel jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), TipoCombustivel.class);
	}

	@Override
	protected TipoCombustivel[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), TipoCombustivel[].class);

	}
	
	@Override
	public TipoCombustivel[] getAll() throws Exception {
		return new TipoCombustivel[0];
	}

}

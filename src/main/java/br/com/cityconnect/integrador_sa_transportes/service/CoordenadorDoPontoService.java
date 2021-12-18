package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.CoordenadorDoPonto;

public class CoordenadorDoPontoService extends MainService<CoordenadorDoPonto> {

	public CoordenadorDoPontoService() {
		super("/integracao/coordenadoresdeponto");
	}

	@Override
	protected CoordenadorDoPonto jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), CoordenadorDoPonto.class);
	}

	@Override
	protected CoordenadorDoPonto[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), CoordenadorDoPonto[].class);
	}
	
	@Override
	public CoordenadorDoPonto[] getAll() throws Exception {
		return new CoordenadorDoPonto[0];
	}

}

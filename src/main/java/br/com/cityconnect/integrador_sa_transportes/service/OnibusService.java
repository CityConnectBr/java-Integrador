package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.Onibus;


public class OnibusService extends MainService<Onibus> {

	public OnibusService() {
		super("/integracao/onibus");
	}

	@Override
	protected Onibus jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), Onibus.class);
	}

	@Override
	protected Onibus[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), Onibus[].class);
	}
	
	@Override
	public Onibus[] getAll() throws Exception {
		return new Onibus[0];
	}

}

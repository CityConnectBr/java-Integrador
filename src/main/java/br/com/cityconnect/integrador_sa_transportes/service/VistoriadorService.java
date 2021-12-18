package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.Vistoriador;

public class VistoriadorService extends MainService<Vistoriador> {

	public VistoriadorService() {
		super("/integracao/vistoriadores");
	}

	@Override
	protected Vistoriador jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), Vistoriador.class);
	}

	@Override
	protected Vistoriador[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), Vistoriador[].class);
	}
	
	@Override
	public Vistoriador[] getAll() throws Exception {
		return new Vistoriador[0];
	}

}

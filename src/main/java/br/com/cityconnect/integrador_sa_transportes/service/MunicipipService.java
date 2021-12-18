package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.Municipio;

public class MunicipipService extends MainService<Municipio> {

	public MunicipipService() {
		super("/integracao/municipios");
	}

	@Override
	protected Municipio jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), Municipio.class);
	}

	@Override
	protected Municipio[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), Municipio[].class);
	}
	
	@Override
	public Municipio[] getAll() throws Exception {
		return new Municipio[0];
	}

}

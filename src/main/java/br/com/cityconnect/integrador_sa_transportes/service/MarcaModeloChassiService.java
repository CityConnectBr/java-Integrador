package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloChassi;

public class MarcaModeloChassiService extends MainService<MarcaModeloChassi> {

	public MarcaModeloChassiService() {
		super("/integracao/marcasmodeloschassis");
	}

	@Override
	protected MarcaModeloChassi jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), MarcaModeloChassi.class);
	}

	@Override
	protected MarcaModeloChassi[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), MarcaModeloChassi[].class);

	}

}

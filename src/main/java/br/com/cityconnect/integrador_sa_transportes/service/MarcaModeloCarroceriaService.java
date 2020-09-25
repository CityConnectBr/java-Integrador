package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloCarroceria;

public class MarcaModeloCarroceriaService extends MainService<MarcaModeloCarroceria> {

	public MarcaModeloCarroceriaService() {
		super("/integracao/marcasmodeloscarrocerias");
	}

	@Override
	protected MarcaModeloCarroceria jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), MarcaModeloCarroceria.class);
	}

	@Override
	protected MarcaModeloCarroceria[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), MarcaModeloCarroceria[].class);

	}
	
	@Override
	public MarcaModeloCarroceria[] getAll() throws Exception {
		return new MarcaModeloCarroceria[0];
	}

}

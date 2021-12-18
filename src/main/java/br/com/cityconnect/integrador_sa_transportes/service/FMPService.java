package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.FMP;

public class FMPService extends MainService<FMP> {

	public FMPService() {
		super("/integracao/fmp");
	}

	@Override
	protected FMP jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), FMP.class);
	}

	@Override
	protected FMP[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), FMP[].class);
	}
	
	@Override
	public FMP[] getAll() throws Exception {
		return new FMP[0];
	}

}

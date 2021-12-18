package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.ValoresDaInfracao;

public class ValoresDaInfracaoService extends MainService<ValoresDaInfracao> {

	public ValoresDaInfracaoService() {
		super("/integracao/valoresdainfracao");
	}

	@Override
	protected ValoresDaInfracao jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), ValoresDaInfracao.class);
	}

	@Override
	protected ValoresDaInfracao[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), ValoresDaInfracao[].class);
	}
	
	@Override
	public ValoresDaInfracao[] getAll() throws Exception {
		return new ValoresDaInfracao[0];
	}

}

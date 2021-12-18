package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.Certidao;

public class CertidaoService extends MainService<Certidao> {

	public CertidaoService() {
		super("/integracao/certidoes");
	}

	@Override
	protected Certidao jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), Certidao.class);
	}

	@Override
	protected Certidao[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), Certidao[].class);
	}
	
	@Override
	public Certidao[] getAll() throws Exception {
		return new Certidao[0];
	}

}

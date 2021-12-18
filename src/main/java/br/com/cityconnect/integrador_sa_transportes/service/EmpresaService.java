package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.Empresa;

public class EmpresaService extends MainService<Empresa> {

	public EmpresaService() {
		super("/integracao/empresas");
	}

	@Override
	protected Empresa jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), Empresa.class);
	}

	@Override
	protected Empresa[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), Empresa[].class);
	}
	
	@Override
	public Empresa[] getAll() throws Exception {
		return new Empresa[0];
	}

}

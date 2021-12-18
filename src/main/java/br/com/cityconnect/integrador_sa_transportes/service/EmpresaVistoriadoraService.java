package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.EmpresaVistoriadora;

public class EmpresaVistoriadoraService extends MainService<EmpresaVistoriadora> {

	public EmpresaVistoriadoraService() {
		super("/integracao/empresasvistoriadoras");
	}

	@Override
	protected EmpresaVistoriadora jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), EmpresaVistoriadora.class);
	}

	@Override
	protected EmpresaVistoriadora[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), EmpresaVistoriadora[].class);
	}
	
	@Override
	public EmpresaVistoriadora[] getAll() throws Exception {
		return new EmpresaVistoriadora[0];
	}

}

package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.ObservacaoDoPermissionario;

public class OpservacaoDoPermissionarioService extends MainService<ObservacaoDoPermissionario> {

	public OpservacaoDoPermissionarioService() {
		super("/integracao/observacoesdopermissionario");
	}

	@Override
	protected ObservacaoDoPermissionario jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), ObservacaoDoPermissionario.class);
	}

	@Override
	protected ObservacaoDoPermissionario[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), ObservacaoDoPermissionario[].class);
	}
	
	@Override
	public ObservacaoDoPermissionario[] getAll() throws Exception {
		return new ObservacaoDoPermissionario[0];
	}

}

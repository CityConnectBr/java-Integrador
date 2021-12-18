package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.CursoDoPermissionario;

public class CursoDoPermissionarioService extends MainService<CursoDoPermissionario> {

	public CursoDoPermissionarioService() {
		super("/integracao/cursodopermissionario");
	}

	@Override
	protected CursoDoPermissionario jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), CursoDoPermissionario.class);
	}

	@Override
	protected CursoDoPermissionario[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), CursoDoPermissionario[].class);
	}
	
	@Override
	public CursoDoPermissionario[] getAll() throws Exception {
		return new CursoDoPermissionario[0];
	}

}

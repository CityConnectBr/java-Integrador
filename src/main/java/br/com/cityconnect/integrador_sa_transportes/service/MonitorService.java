package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.Monitor;

public class MonitorService extends MainService<Monitor> {

	public MonitorService() {
		super("/integracao/monitores");
	}

	@Override
	protected Monitor jsonToObj(String json) {
		System.out.println("AKIIIIII");
		System.out.println(json);
		return gson.fromJson(json.toString(), Monitor.class);
	}

	@Override
	protected Monitor[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), Monitor[].class);
	}
	
	@Override
	public Monitor[] getAll() throws Exception {
		return new Monitor[0];
	}

}

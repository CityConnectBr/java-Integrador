package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONObject;

import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;


public class CondutorAuxiliarService extends MainService<CondutorAuxiliar> {

	public CondutorAuxiliarService() {
		super("/integracao/condutores");
	}

	@Override
	protected CondutorAuxiliar jsonToObj(String json) {
		JSONObject jsonObject = new JSONObject(json);

		// tratando endereco
		if (jsonObject.has("endereco")) {
			JSONObject jsonEndereco = jsonObject.getJSONObject("endereco");
			jsonObject.remove("endereco");
			jsonEndereco.keySet().stream().filter(key -> !key.toString().equals("id"))
					.forEach(key -> jsonObject.put(key, jsonEndereco.get(key)));
		}
		
		// tratando permissionario
		if (jsonObject.has("permissionario")) {
			JSONObject jsonPermissionario = jsonObject.getJSONObject("permissionario");
			jsonObject.remove("permissionario");
			jsonObject.put("permissionario_id", jsonPermissionario.get("id_integracao"));
		}

		return gson.fromJson(jsonObject.toString(), CondutorAuxiliar.class);
	}

	@Override
	protected CondutorAuxiliar[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), CondutorAuxiliar[].class);
	}

}

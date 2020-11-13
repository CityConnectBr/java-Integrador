package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.cityconnect.integrador_sa_transportes.entity.Monitor;

public class MonitorService extends MainService<Monitor> {

	public MonitorService() {
		super("/integracao/monitores");
	}

	@Override
	protected Monitor jsonToObj(String json) {
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

		return gson.fromJson(jsonObject.toString(), Monitor.class);
	}

	@Override
	protected Monitor[] jsonListToObjList(String json) {

		JSONArray jsonArray = new JSONArray(json);

		Monitor[] auxiliarList = new Monitor[jsonArray.length()];

		for (int i = 0; i < jsonArray.length(); i++) {
			if (jsonArray.get(i) != null) {
				auxiliarList[i] = (jsonToObj(jsonArray.get(i).toString()));
			}
		}

		return auxiliarList;
	}

}

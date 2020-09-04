package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONObject;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class PermissionarioService extends MainService<Permissionario> {

	public PermissionarioService() {
		super("/integracao/permissionarios");
	}

	@Override
	protected Permissionario jsonToObj(String json) {		
		JSONObject jsonObject = new JSONObject(json);
		
		// tratando endereco
		if (jsonObject.has("endereco")) {
			JSONObject jsonEndereco = jsonObject.getJSONObject("endereco");
			jsonObject.remove("endereco");
			jsonEndereco.keySet().stream().filter(key -> !key.toString().equals("id"))
					.forEach(key -> jsonObject.put(key, jsonEndereco.get(key)));
		}
		// tratando modalidade
		JSONObject jsonModalidade = jsonObject.getJSONObject("modalidade");
		jsonObject.remove("modalidade");
		jsonObject.put("modalidade_transporte", jsonModalidade.get("identificador").toString().toUpperCase());

		return gson.fromJson(jsonObject.toString(), Permissionario.class);
	}
	
	@Override
	protected Permissionario[] jsonListToObjList(String json) {
		return null;
	}

	

}

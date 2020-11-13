package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.cityconnect.integrador_sa_transportes.entity.AgenteFiscalizacao;

public class AgenteFiscalizacaoService extends MainService<AgenteFiscalizacao> {

	public AgenteFiscalizacaoService() {
		super("/integracao/fiscais");
	}

	@Override
	protected AgenteFiscalizacao jsonToObj(String json) {
		JSONObject jsonObject = new JSONObject(json);

		// tratando endereco
		if (jsonObject.has("endereco")) {
			JSONObject jsonEndereco = jsonObject.getJSONObject("endereco");
			jsonObject.remove("endereco");
			jsonEndereco.keySet().stream().filter(key -> !key.toString().equals("id"))
					.forEach(key -> jsonObject.put(key, jsonEndereco.get(key)));
		}
		
		return gson.fromJson(jsonObject.toString(), AgenteFiscalizacao.class);
	}

	@Override
	protected AgenteFiscalizacao[] jsonListToObjList(String json) {

		JSONArray jsonArray = new JSONArray(json);

		AgenteFiscalizacao[] auxiliarList = new AgenteFiscalizacao[jsonArray.length()];

		for (int i = 0; i < jsonArray.length(); i++) {
			if (jsonArray.get(i) != null) {
				auxiliarList[i] = (jsonToObj(jsonArray.get(i).toString()));
			}
		}

		return auxiliarList;
	}

}

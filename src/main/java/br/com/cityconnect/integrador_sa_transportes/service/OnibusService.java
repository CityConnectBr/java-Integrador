package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONObject;

import br.com.cityconnect.integrador_sa_transportes.entity.Onibus;
import br.com.cityconnect.integrador_sa_transportes.entity.Veiculo;


public class OnibusService extends MainService<Onibus> {

	public OnibusService() {
		super("/integracao/onibus");
	}

	@Override
	protected Onibus jsonToObj(String json) {
		JSONObject jsonObject = new JSONObject(json);

		// tratando chassi
		if (jsonObject.has("marca_modelo_chassi")) {
			JSONObject jsonChassi = jsonObject.getJSONObject("marca_modelo_chassi");
			jsonObject.put("marca_modelo_chassi_id", jsonChassi.get("id_integracao"));
			jsonObject.remove("marca_modelo_chassi");
		}

		// tratando carroceria
		if (jsonObject.has("marca_modelo_carroceria")) {
			JSONObject jsonCarroceria = jsonObject.getJSONObject("marca_modelo_carroceria");
			jsonObject.put("marca_modelo_carroceria_id", jsonCarroceria.get("id_integracao"));
			jsonObject.remove("marca_modelo_carroceria");
		}

		// tratando combustivel
		if (jsonObject.has("tipo_combustivel")) {
			JSONObject jsonCombustivel = jsonObject.getJSONObject("tipo_combustivel");
			jsonObject.put("tipo_combustivel_id", jsonCombustivel.get("id_integracao"));
			jsonObject.remove("tipo_combustivel");
		}

		// tratando chassi
		if (jsonObject.has("cor")) {
			JSONObject jsonCor = jsonObject.getJSONObject("cor");
			jsonObject.put("cor_id", jsonCor.get("id_integracao"));
			jsonObject.remove("cor");
		}
				
		return gson.fromJson(jsonObject.toString(), Onibus.class);
	}

	@Override
	protected Onibus[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), Onibus[].class);
	}

}

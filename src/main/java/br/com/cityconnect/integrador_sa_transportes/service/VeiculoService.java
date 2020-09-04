package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONObject;

import br.com.cityconnect.integrador_sa_transportes.entity.Veiculo;


public class VeiculoService extends MainService<Veiculo> {

	public VeiculoService() {
		super("/integracao/veiculos");
	}

	@Override
	protected Veiculo jsonToObj(String json) {
		JSONObject jsonObject = new JSONObject(json);

		// tratando veiculo
		if (jsonObject.has("marca_modelo_veiculo")) {
			JSONObject jsonChassi = jsonObject.getJSONObject("marca_modelo_veiculo");
			jsonObject.put("marca_modelo_veiculo_id", jsonChassi.get("id_integracao"));
			jsonObject.remove("marca_modelo_veiculo");
		}

		// tratando combustivel
		if (jsonObject.has("tipo_combustivel")) {
			JSONObject jsonCombustivel = jsonObject.getJSONObject("tipo_combustivel");
			jsonObject.put("tipo_combustivel_id", jsonCombustivel.get("id_integracao"));
			jsonObject.remove("tipo_combustivel");
		}
		
		// tratando cor
		if (jsonObject.has("cor")) {
			JSONObject jsonCor = jsonObject.getJSONObject("cor");
			jsonObject.put("cor_id", jsonCor.get("id_integracao"));
			jsonObject.remove("cor");
		}

		// tratando permissionario
		if (jsonObject.has("permissionario")) {
			JSONObject jsonCarroceria = jsonObject.getJSONObject("permissionario");
			jsonObject.put("permissionario_id", jsonCarroceria.get("id_integracao"));
			jsonObject.remove("permissionario");
		}

				
		return gson.fromJson(jsonObject.toString(), Veiculo.class);
	}

	@Override
	protected Veiculo[] jsonListToObjList(String json) {
		return null;
	}

}

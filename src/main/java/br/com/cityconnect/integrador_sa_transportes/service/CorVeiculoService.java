package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import br.com.cityconnect.integrador_sa_transportes.entity.CorVeiculo;

public class CorVeiculoService extends ServiceMain<CorVeiculo> {

	public CorVeiculoService() {
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token", super.token);
		url = super.urlBase + "/integracao/coresveiculos";
	}

	public void sendUpdate(CorVeiculo obj) {

		String permissionarioJson = gson.toJson(obj);

		System.out.println(url + "/" + obj.getIdIntegracao());
		restTemplate.put(url + "/" + obj.getIdIntegracao(),
				new HttpEntity<String>(permissionarioJson.toString(), headers), String.class);
	}

	@Override
	public CorVeiculo get(Integer codigo) {

		try {
			ResponseEntity<String> response = restTemplate.exchange(url + "/" + codigo, HttpMethod.GET,
					new HttpEntity(headers), String.class);

			return jsonToPermissionario(new JSONObject(response.getBody()));

		} catch (HttpClientErrorException e) {
			if (e.getMessage().contains("404")) {
				return null;
			}

			throw e;
		}

	}

	private CorVeiculo jsonToPermissionario(JSONObject jsonObject) {

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

		return gson.fromJson(jsonObject.toString(), CorVeiculo.class);
	}

}

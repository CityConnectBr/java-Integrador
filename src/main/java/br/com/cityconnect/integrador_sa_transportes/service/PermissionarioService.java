package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class PermissionarioService extends ServiceMain<Permissionario> {

	public PermissionarioService() {
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token", super.token);
		url = super.urlBase + "/integracao/permissionarios";
	}

	public void sendUpdate(Permissionario permissionario) {

		String permissionarioJson = gson.toJson(permissionario);
		
		System.out.println(url + "/" + permissionario.getIdIntegracao());
		restTemplate.put(url + "/" + permissionario.getIdIntegracao(),
				new HttpEntity<String>(permissionarioJson.toString(), headers), String.class);
	}

	

	@Override
	public Permissionario get(Integer codigo) {

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

	private Permissionario jsonToPermissionario(JSONObject jsonObject) {

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

}

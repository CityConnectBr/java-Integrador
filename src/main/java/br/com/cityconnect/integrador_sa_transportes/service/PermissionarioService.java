package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class PermissionarioService extends ServiceMain {

	private final String url = super.urlBase + "/integracao/permissionarios";

	private RestTemplate restTemplate = new RestTemplate();
	private Gson gson = new Gson();

	public void sendUpdate(Permissionario permissionario) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String permissionarioJson = gson.toJson(permissionario);

		System.out.println(url + "/" + permissionario.getIdIntegracao());
		restTemplate.put(url + "/" + permissionario.getIdIntegracao(), new HttpEntity<String>(permissionarioJson.toString(), headers),
				String.class);
	}

	public String send(Permissionario permissionario) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String permissionarioJson = gson.toJson(permissionario);

		return new JSONObject(restTemplate.postForObject(url,
				new HttpEntity<String>(permissionarioJson.toString(), headers), String.class)).get("id").toString();
	}

	public Permissionario get(Integer codigo) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		try {
			return jsonToPermissionario(new JSONObject(restTemplate.getForObject(url + "/" + codigo, String.class)));
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

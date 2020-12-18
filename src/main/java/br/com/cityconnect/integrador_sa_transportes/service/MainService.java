package br.com.cityconnect.integrador_sa_transportes.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;

import org.json.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;

import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;
import br.com.cityconnect.integrador_sa_transportes.util.Util;

public abstract class MainService<T extends Serializable> {

	private Util util = new Util();

	public MainService(String endPoint) {
		try {
			PropertiesUtil pu = new PropertiesUtil();

			this.urlBase = pu.getValue(PropertiesUtil.KEY_URL_API);
			this.token = pu.getValue(PropertiesUtil.KEY_API_TOKEN);

		} catch (IOException e) {
			e.printStackTrace();
		}

		url = urlBase + endPoint;
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("token", token);
	}

	protected String urlBase = null;// "http://192.168.15.80:8000/";
	// protected final String urlBase =
	// "https://api.santo-andre-transporte.cityconnect.com.br/";
	protected String token = null;// "$2y$10$3.Cnop0hlPRgK1GA.RVR2uN1pZgpBrd.vCHWrERLiECPMaBF6UWzi";

	protected RestTemplate restTemplate = new RestTemplate();
	protected Gson gson = new Gson();
	protected HttpHeaders headers = new HttpHeaders();

	protected String url = "";

	protected String toJsonField(String field, Object value) {
		if (value == null) {
			return "\"" + field + "\":null";
		} else if (value instanceof Double || value instanceof Integer || value instanceof BigDecimal
				|| value instanceof Float) {
			return "\"" + field + "\":" + String.valueOf(value);
		} else {
			return "\"" + field + "\":\"" + String.valueOf(value) + "\"";
		}
	}

	public void sendUpdate(Object obj, String id) {

		String permissionarioJson = gson.toJson(obj);

		System.out.println(url + "/" + id);
		restTemplate.put(url + "/" + id, new HttpEntity<String>(permissionarioJson.toString(), headers), String.class);
	}

	public void sendUpdatePhoto(InputStream input, String id) throws Exception {

		File fotoTemp = new File(util.getSenhaAleatorio(20) + ".jpg");

		if (this.util.writeFile(input, fotoTemp)) {
			try {
				LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
				FileSystemResource value = new FileSystemResource(fotoTemp);
				map.add("foto", value);

				headers.setContentType(MediaType.MULTIPART_FORM_DATA);
				HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(map, headers);
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.exchange(url + "/" + id + "/foto", HttpMethod.POST, requestEntity, String.class);
			} catch (Exception e) {
				throw e;
			} finally {
				if (fotoTemp != null && fotoTemp.exists()) {
					fotoTemp.deleteOnExit();
				}
				headers.setContentType(MediaType.APPLICATION_JSON);
			}
		}
	}

	public void sendUpdateWithRealId(Object obj, String id) {

		String permissionarioJson = gson.toJson(obj);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
		builder.pathSegment(id);
		builder.queryParam("id_real", true);

		System.out.println(builder.toUriString());
		restTemplate.put(builder.toUriString(), new HttpEntity<String>(permissionarioJson.toString(), headers),
				String.class);
	}

	public String send(Object obj) {

		String permissionarioJson = gson.toJson(obj);

		return new JSONObject(restTemplate.postForObject(url,
				new HttpEntity<String>(permissionarioJson.toString(), headers), String.class)).get("id").toString();
	}

	public T get(String id) throws Exception {

		try {
			ResponseEntity<String> response = restTemplate.exchange(url + "/" + id, HttpMethod.GET,
					new HttpEntity(headers), String.class);

			return jsonToObj(response.getBody());
		} catch (Exception e) {
			if (e.getMessage().contains("404")) {
				return null;
			}

			throw e;
		}

	}

	public T[] getAllNews() throws Exception {

		try {
			ResponseEntity<String> response = restTemplate.exchange(url + "/news", HttpMethod.GET,
					new HttpEntity(headers), String.class);

			return jsonListToObjList(response.getBody());
		} catch (Exception e) {
			if (e.getMessage().contains("404")) {
				return null;
			}

			throw e;
		}

	}

	public T[] getAll() throws Exception {

		try {
			ResponseEntity<String> response = restTemplate.exchange(url + "/", HttpMethod.GET, new HttpEntity(headers),
					String.class);

			return jsonListToObjList(response.getBody());
		} catch (Exception e) {
			if (e.getMessage().contains("404")) {
				return null;
			}

			throw e;
		}

	}

	public boolean sendDelete(String id) throws Exception {
		try {
			ResponseEntity<String> response = restTemplate.exchange(url + "/" + id, HttpMethod.DELETE,
					new HttpEntity(headers), String.class);

			return Boolean.TRUE;
		} catch (Exception e) {
			if (e.getMessage().contains("404")) {
				return Boolean.FALSE;
			}

			throw e;
		}
	}

	protected abstract T jsonToObj(String json);

	protected abstract T[] jsonListToObjList(String json);

}

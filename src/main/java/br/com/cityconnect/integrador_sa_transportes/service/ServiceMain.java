package br.com.cityconnect.integrador_sa_transportes.service;

import java.io.Serializable;
import java.math.BigDecimal;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public abstract class ServiceMain<T extends Serializable> {

	protected final String urlBase = "http://192.168.15.33:8000/";
	//protected final String urlBase = "https://api.santo-andre-transporte.cityconnect.com.br/";
	protected final String token = "$2y$10$3.Cnop0hlPRgK1GA.RVR2uN1pZgpBrd.vCHWrERLiECPMaBF6UWzi";
	
	protected RestTemplate restTemplate = new RestTemplate();
	protected Gson gson = new Gson();
	protected HttpHeaders headers = new HttpHeaders();

	protected String url = "";
		
	protected String toJsonField(String field, Object value) {
		if(value == null) {
			return "\""+field+"\":null";
		}else if(value instanceof Double || value instanceof Integer || value instanceof BigDecimal || value instanceof Float) {
			return "\""+field+"\":"+String.valueOf(value);
		}else {
			return "\""+field+"\":\""+String.valueOf(value)+"\"";
		}		
	}
	
	public String send(T obj) {

		String permissionarioJson = gson.toJson(obj);

		return new JSONObject(restTemplate.postForObject(url,
				new HttpEntity<String>(permissionarioJson.toString(), headers), String.class)).get("id").toString();
	}
	
	public abstract T get(Integer codigo);
	public abstract void sendUpdate(T object);


}

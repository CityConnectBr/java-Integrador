package br.com.cityconnect.integrador_sa_transportes.testes;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.cityconnect.integrador_sa_transportes.dao.MonitorDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Monitor;
import br.com.cityconnect.integrador_sa_transportes.util.Util;

public class Teste1 {

	public static void main(String args[]) {
		MonitorDAO monitorDAO = new MonitorDAO();
		
		List<Monitor> monitores = monitorDAO.findAll();
		for(Monitor m : monitores) {
			String json = new Gson().toJson(m);

			System.out.println(json);
		}
		
	}
	
	private static void teste1() {
		final String uri = "http://localhost:8000/api/integracao/motoristas";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
		
	}
	
	private static void teste2() {
		final String uri = "http://localhost:8000/api/integracao/motoristas";

		RestTemplate restTemplate = new RestTemplate();


		 String requestJson = "{nome:'teste123'}";

		 HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 
		 HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		 ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
		 System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
		 System.out.println("Response ="+response.getBody());
		
	}
	
	private static void teste3() {
		
		// request url
		String url = "http://localhost:8000/api/integracao/motoristas";

		// create an instance of RestTemplate
		RestTemplate restTemplate = new RestTemplate();


String requestJson = "{\"nome\":\"Is there pain in your hand?\"}";
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);

HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
String answer = restTemplate.postForObject(url, entity, String.class);
System.out.println(answer);
		
	}
	
	

}

package br.com.cityconnect.integrador_sa_transportes.testes;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.cityconnect.integrador_sa_transportes.util.Util;

public class Teste1 {

	public static void main(String args[]) {
		Util util = new Util();

		System.out.println(util.formatTelephone("24", null));
		System.out.println(util.formatTelephone(null, "12345678"));
		System.out.println(util.formatTelephone("24", "12345678"));
		System.out.println(util.formatTelephone("24", "912345678"));
		System.out.println(util.formatTelephone("24", "2222-4444"));
		System.out.println(util.formatTelephone("24", "92222-4444"));
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

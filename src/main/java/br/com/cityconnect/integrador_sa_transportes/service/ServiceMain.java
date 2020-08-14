package br.com.cityconnect.integrador_sa_transportes.service;

import java.math.BigDecimal;

public class ServiceMain {

	//protected final String urlBase = "http://localhost:8000/";
	protected final String urlBase = "https://api.santo-andre-transporte.cityconnect.com.br/";
	protected final String token = "$2y$10$3.Cnop0hlPRgK1GA.RVR2uN1pZgpBrd.vCHWrERLiECPMaBF6UWzi";
	
	protected String toJsonField(String field, Object value) {
		if(value == null) {
			return "\""+field+"\":null";
		}else if(value instanceof Double || value instanceof Integer || value instanceof BigDecimal || value instanceof Float) {
			return "\""+field+"\":"+String.valueOf(value);
		}else {
			return "\""+field+"\":\""+String.valueOf(value)+"\"";
		}		
	}


}

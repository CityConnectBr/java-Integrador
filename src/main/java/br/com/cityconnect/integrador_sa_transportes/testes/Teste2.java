package br.com.cityconnect.integrador_sa_transportes.testes;

import java.sql.SQLException;

import com.google.gson.Gson;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class Teste2 {
	
	public static void main(String args[]) throws SQLException {
		
		Gson g = new Gson();
		
		Permissionario p = new Permissionario();
		
		p.setNome("elon");
		
		System.out.println(g.toJson(p));
		
		
		
	}

}

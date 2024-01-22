package br.com.cityconnect.integrador_sa_transportes.testes;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.cityconnect.integrador_sa_transportes.annotations.ExcludeGson;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TalaoDoFiscalDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class Teste3 {
	
	public static void main(String[] args) {
		
		TalaoDoFiscalDAO tDao = new TalaoDoFiscalDAO();
		
		System.out.println(">>>>");
		tDao.findAll();
		



	}

}

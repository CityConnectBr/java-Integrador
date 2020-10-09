package br.com.cityconnect.integrador_sa_transportes.testes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

import br.com.cityconnect.integrador_sa_transportes.dao.VeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.service.PermissionarioService;

public class Teste2 {

	public static void main(String args[]) throws Exception {

		PermissionarioService service = new PermissionarioService();
		
		System.out.println(service.getClass().getMethod("getAllNews").invoke(service, null));

	}

}

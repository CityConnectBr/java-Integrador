package br.com.cityconnect.integrador_sa_transportes.testes;

import com.google.gson.Gson;

import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.service.PermissionarioService;

public class Teste4 {
	
	public static void main(String[] args) {
		PermissionarioDAO pDAO = new PermissionarioDAO();
		PermissionarioService pService = new PermissionarioService();
		
		Permissionario permissionario = pService.get(2);

		System.out.println(permissionario.getId());
		System.out.println(permissionario.getIdIntegracao());
		
		permissionario = pDAO.findById("2");
		
		System.out.println(permissionario.getId());
		System.out.println(permissionario.getIdIntegracao());		
		
		String permissionarioJson = new Gson().toJson(permissionario);

		System.out.println(permissionarioJson);
		
		//System.out.println(pDAO.findById("1"));
		
		//System.out.println(pService.get(1));
		
	}

}

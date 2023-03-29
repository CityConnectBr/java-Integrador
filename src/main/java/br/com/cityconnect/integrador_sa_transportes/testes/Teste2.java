package br.com.cityconnect.integrador_sa_transportes.testes;

import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class Teste2 {

	public static void main(String[] args) {
		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();
		
		for(Permissionario p : permissionarioDAO.findAll()) {
			System.out.println(p.getBairro());
		}

	}

}

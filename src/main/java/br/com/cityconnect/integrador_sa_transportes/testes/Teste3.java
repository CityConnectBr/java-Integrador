package br.com.cityconnect.integrador_sa_transportes.testes;

import java.sql.SQLException;

import com.google.common.base.CaseFormat;

import br.com.cityconnect.integrador_sa_transportes.controller.PermissionarioController;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.service.PermissionarioService;

public class Teste3 {

	public static void main(String[] args) throws SQLException {

		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();
		PermissionarioService permissionarioService = new PermissionarioService();
		
		PermissionarioController mc = new PermissionarioController();
		
		mc.sincronizar();
		
		//motoristaDAO.getAll().forEach(m -> System.out.println(m));
		
		/*Permissionario m = new Permissionario();
		m.setNome("MAFALDA CORREA MARÇ");
		m.setId(new Long("980333"));

		permissionarioService.send(m);*/
	}

}

package br.com.cityconnect.integrador_sa_transportes.testes;

import java.util.concurrent.TimeUnit;

import br.com.cityconnect.integrador_sa_transportes.controller.PermissionarioController;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.service.PermissionarioService;

public class Teste3 {

	public static void main(String[] args) throws Exception {

		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();
		PermissionarioService permissionarioService = new PermissionarioService();
		
		PermissionarioController mc = new PermissionarioController();
		
		while (true) {
			mc.sincronizar();

			TimeUnit.SECONDS.sleep(5);
		}
		
		//motoristaDAO.getAll().forEach(m -> System.out.println(m));
		
		/*Permissionario m = new Permissionario();
		m.setNome("MAFALDA CORREA MARÇ");
		m.setId(new Long("980333"));

		permissionarioService.send(m);*/
	}

}

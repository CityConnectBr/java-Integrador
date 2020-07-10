package br.com.cityconnect.integrador_sa_transportes.controller;

import java.sql.SQLException;

import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.service.PermissionarioService;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;

public class PermissionarioController {
	
	public void sincronizar() throws SQLException {
		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();
		PermissionarioService permissionarioService = new PermissionarioService();

		int contErros = 0;
		
		for(Permissionario motorista : permissionarioDAO.getAll()){
			
			try {

				permissionarioService.send(motorista);
				
				contErros = 0;
			}catch (Exception e) {
			    System.err.println(e);
			    Logger.sendLog(PermissionarioController.class, Logger.ERROR, e);
			    
				contErros++;
				if(contErros>3) {
					throw e;
				}
			}

		}


	}

}

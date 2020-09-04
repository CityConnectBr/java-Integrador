package br.com.cityconnect.integrador_sa_transportes.testes;

import javax.validation.Validator;

import com.google.gson.Gson;

import br.com.cityconnect.integrador_sa_transportes.controller.CorVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.MarcaModeloCarroceriaController;
import br.com.cityconnect.integrador_sa_transportes.controller.MarcaModeloChassiController;
import br.com.cityconnect.integrador_sa_transportes.controller.MarcaModeloVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.OnibusController;
import br.com.cityconnect.integrador_sa_transportes.controller.PermissionarioController;
import br.com.cityconnect.integrador_sa_transportes.controller.TipoCombustivelController;
import br.com.cityconnect.integrador_sa_transportes.controller.TipoVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.VeiculoController;
import br.com.cityconnect.integrador_sa_transportes.dao.OnibusDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.VeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloChassi;

public class Teste5 {
	private static Validator validator;

	public static void main(String[] args) throws Exception {
				
		sinc();
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		VeiculoController c = new VeiculoController();
		
		//veiculoDAO.findAll();
		
		c.sinc();
		// c.sinc();

	}
	
	public static void sinc() throws Exception {
		MarcaModeloCarroceriaController marcaModeloCarroceriaController = new MarcaModeloCarroceriaController();
		MarcaModeloChassiController marcaModeloChassiController = new MarcaModeloChassiController();
		TipoCombustivelController tipoCombustivelController = new TipoCombustivelController();
		CorVeiculoController corVeiculoController = new CorVeiculoController();
		TipoVeiculoController tipoVeiculoController = new TipoVeiculoController();
		MarcaModeloVeiculoController marcaModeloVeiculoController = new MarcaModeloVeiculoController();
		PermissionarioController permissionarioController = new PermissionarioController();

		//marcaModeloCarroceriaController.sinc();
		//marcaModeloChassiController.sinc();
		//tipoCombustivelController.sinc();
		//corVeiculoController.sinc();
		//tipoVeiculoController.sinc();
		//marcaModeloVeiculoController.sinc();
		//permissionarioController.sinc();
		
	}

}

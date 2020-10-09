package br.com.cityconnect.integrador_sa_transportes.testes;

import br.com.cityconnect.integrador_sa_transportes.controller.CondutorAuxuliarController;
import br.com.cityconnect.integrador_sa_transportes.controller.CorVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.MainController;
import br.com.cityconnect.integrador_sa_transportes.controller.MarcaModeloCarroceriaController;
import br.com.cityconnect.integrador_sa_transportes.controller.MarcaModeloChassiController;
import br.com.cityconnect.integrador_sa_transportes.controller.MarcaModeloVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.OnibusController;
import br.com.cityconnect.integrador_sa_transportes.controller.PermissionarioController;
import br.com.cityconnect.integrador_sa_transportes.controller.TipoCombustivelController;
import br.com.cityconnect.integrador_sa_transportes.controller.TipoVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.VeiculoController;

public class Teste3 {

	public static void main(String[] args) throws Exception {
		
		MainController controller = new CorVeiculoController();
		//controller.sinc();

		controller = new MarcaModeloCarroceriaController();
		//controller.sinc();

		controller = new MarcaModeloChassiController();
		//controller.sinc();

		controller = new TipoCombustivelController();
		//controller.sinc();

		controller = new TipoVeiculoController();
		//controller.sinc();

		controller = new MarcaModeloVeiculoController();
		//controller.sinc();

		controller = new PermissionarioController();
		//controller.sinc();

		controller = new CondutorAuxuliarController();
		controller.sinc();

		controller = new OnibusController();
		//controller.sinc();

		controller = new VeiculoController();
		//controller.sinc();
	}

}

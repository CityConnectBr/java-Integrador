package br.com.cityconnect.integrador_sa_transportes.testes;

import br.com.cityconnect.integrador_sa_transportes.controller.CorVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.MainController;

public class Teste3 {

	public static void main(String[] args) throws Exception {
		
		MainController controller = new CorVeiculoController();
		controller.startMainThreadSinc();
		
//		controller.startMainThreadSinc();
	}

}

package br.com.cityconnect.integrador_sa_transportes.testes;

import br.com.cityconnect.integrador_sa_transportes.controller.CorVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.MainController;
import br.com.cityconnect.integrador_sa_transportes.view.ControleJFrame;

public class Teste3 {

	public static void main(String[] args) throws Exception {
		
		ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(true);

		MainController controller = new CorVeiculoController();
		controller.sincAllMainThread(false);//.startMainThreadSinc();
		
//		controller.startMainThreadSinc();
	}

}

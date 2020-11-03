package br.com.cityconnect.integrador_sa_transportes.testes;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import br.com.cityconnect.integrador_sa_transportes.util.SincProcessObservableUtil;
import br.com.cityconnect.integrador_sa_transportes.view.ControleJFrame;

public class Teste5 {

	public static void main(String[] args) throws Exception {

		ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(true);
		
	}

}

class ObserverTeste implements Observer {
	
	public ObserverTeste(Observable observable) {
		observable.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object arg1) {
		
		SincProcessObservableUtil sincProcessObservableUtil = (SincProcessObservableUtil) observable;
		System.out.println("\n-----");
		System.out.println("Process: "+sincProcessObservableUtil.getPosOfProcess()+"/"+sincProcessObservableUtil.getTotalOfProcess());
		System.out.println("SubProcess: "+sincProcessObservableUtil.getActionOfSubProcess()+" - "+sincProcessObservableUtil.getPosOfSubProcess()+"/"+sincProcessObservableUtil.getTotalOfSubProcess());
		
		
	}
}
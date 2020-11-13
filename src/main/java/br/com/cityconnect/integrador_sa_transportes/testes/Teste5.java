package br.com.cityconnect.integrador_sa_transportes.testes;

import java.util.Observable;
import java.util.Observer;

import br.com.cityconnect.integrador_sa_transportes.dao.CondutoreAuxiliareDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.util.SincProcessObservableUtil;

public class Teste5 {

	public static void main(String[] args) throws Exception {

		//ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(true);
		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();
		for(CondutorAuxiliar v : new CondutoreAuxiliareDAO().findAll()) {
			if(permissionarioDAO.findById(new Long(v.getPermissionarioId()))==null) {
				System.out.println("SEM PER: "+v.toString());
			}else {
				System.out.println(v);
			}
		}
		
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
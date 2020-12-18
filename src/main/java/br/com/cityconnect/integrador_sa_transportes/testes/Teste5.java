package br.com.cityconnect.integrador_sa_transportes.testes;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Observer;

import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.service.PermissionarioService;
import br.com.cityconnect.integrador_sa_transportes.util.SincProcessObservableUtil;

public class Teste5 {

	public static void main(String[] args) throws Exception {
		

		//ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(true);
//		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();
		PermissionarioService permissionarioService = new PermissionarioService();
		
//		Permissionario p = permissionarioDAO.findById(new Long(2));
//		
//		//p.setFoto(new File("/Users/elongomesvieira/Aux/3x4-foto.jpg"));
//		
		File file = new File("/Users/elongomesvieira/Aux/3x4-foto.jpg");
		

		
		permissionarioService.sendUpdatePhoto(file, "445");
		
		//System.out.println(p);
		
		
//		Testar sinc do integrador para api
//		fazer a rota da api para monitor e condutor
		
		
		
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
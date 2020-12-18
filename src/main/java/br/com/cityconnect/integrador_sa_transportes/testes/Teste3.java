package br.com.cityconnect.integrador_sa_transportes.testes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import br.com.cityconnect.integrador_sa_transportes.controller.CorVeiculoController;
import br.com.cityconnect.integrador_sa_transportes.controller.MainController;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.view.ControleJFrame;

public class Teste3 {

	public static void main(String[] args) throws Exception {

		// ControleJFrame controleJFrame = (ControleJFrame)
		// ControleJFrame.newControleJFrame(true);

		 MainController controller = new CorVeiculoController();
		 controller.sincAllMainThread(false);//.startMainThreadSinc();
		 controller.startMainThreadSinc();

//		controller.startMainThreadSinc();

//		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();
//
//		Permissionario p = permissionarioDAO.findById(new Long(2));
//
//		System.out.println(p);
//
//		FileOutputStream output = new FileOutputStream(new File("/Users/elongomesvieira/Aux/cc/teste123.jpg"));
//
//		InputStream input = p.getFoto().getBinaryStream();
//
//		int r = 0;
//		while ((r = input.read()) != -1) {
//			output.write(r);
//
//		}

	}

}

package br.com.cityconnect.integrador_sa_transportes.testes;

import java.util.Observable;
import java.util.Observer;

import br.com.cityconnect.integrador_sa_transportes.controller.MainController;
import br.com.cityconnect.integrador_sa_transportes.dao.CondutoreAuxiliareDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.service.CondutorAuxiliarService;

public class Teste2 {

	public static void main(String args[]) throws Exception {

		CondutorAuxiliarService s = new CondutorAuxiliarService();

		CondutoreAuxiliareDAO cDAO = new CondutoreAuxiliareDAO();

		CondutorAuxiliar ca = cDAO.findById("29860580278");

		System.out.println(ca.getId());
		
		System.out.println(ca.getClass().getMethod("getId").invoke(ca, null));
//		String id = ca.getClass().getMethod("getId").invoke(ca, null).toString();
//
//		cDAO.getClass().getMethod("setVersao", Object.class, Integer.class).invoke(cDAO, id, ca.getVersao() + 1);

	}

}

package br.com.cityconnect.integrador_sa_transportes.testes;

import javax.validation.Validator;

import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloChassiDAO;

public class Teste5 {
	private static Validator validator;

	public static void main(String[] args) {

		MarcaModeloChassiDAO dao = new MarcaModeloChassiDAO();

		dao.findAll().forEach(obj -> System.out.println(obj));

	}

}

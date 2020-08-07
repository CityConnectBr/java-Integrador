package br.com.cityconnect.integrador_sa_transportes.testes;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class Teste5 {
	private static Validator validator;

	public static void main(String[] args) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();

		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();

		//Permissionario p = new Permissionario();
		
		//p.setCNPJ("");
		
		//Set<ConstraintViolation<Permissionario>> constraintViolations = validator.validate(p);
		
		System.out.println(permissionarioDAO.findById("1"));

	}

}

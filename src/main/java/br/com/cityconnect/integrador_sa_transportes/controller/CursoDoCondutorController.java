package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.CursoDoCondutorDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CursoDoCondutor;
import br.com.cityconnect.integrador_sa_transportes.service.CursoDoCondutorService;

public class CursoDoCondutorController extends MainController<CursoDoCondutor, CursoDoCondutorDAO, CursoDoCondutorService>{

	public CursoDoCondutorController() throws NumberFormatException {
		super(new CursoDoCondutorService(), new CursoDoCondutorDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}

package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.EntidadeCursoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.EntidadeCurso;
import br.com.cityconnect.integrador_sa_transportes.service.EntidadeCursoService;

public class EntidadeCursoController extends MainController<EntidadeCurso, EntidadeCursoDAO, EntidadeCursoService>{

	public EntidadeCursoController() throws NumberFormatException {
		super(new EntidadeCursoService(), new EntidadeCursoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}

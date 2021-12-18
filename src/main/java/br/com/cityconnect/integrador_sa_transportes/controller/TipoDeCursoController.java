package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.TipoDeCursoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.TipoDeCurso;
import br.com.cityconnect.integrador_sa_transportes.service.TipoDeCursoService;

public class TipoDeCursoController extends MainController<TipoDeCurso, TipoDeCursoDAO, TipoDeCursoService>{

	public TipoDeCursoController() throws NumberFormatException {
		super(new TipoDeCursoService(), new TipoDeCursoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}

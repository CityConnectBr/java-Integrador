package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.EntidadeAssociativaDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.EntidadeAssociativa;
import br.com.cityconnect.integrador_sa_transportes.service.EntidadeAssociativaService;

public class EntidadeAssociativaController extends MainController<EntidadeAssociativa, EntidadeAssociativaDAO, EntidadeAssociativaService>{

	public EntidadeAssociativaController() throws NumberFormatException {
		super(new EntidadeAssociativaService(), new EntidadeAssociativaDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}

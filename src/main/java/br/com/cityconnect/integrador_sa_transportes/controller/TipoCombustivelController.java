package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.IOException;

import br.com.cityconnect.integrador_sa_transportes.dao.TipoCombustivelDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.TipoCombustivel;
import br.com.cityconnect.integrador_sa_transportes.service.TipoCombustivelService;

public class TipoCombustivelController
		extends MainController<TipoCombustivel, TipoCombustivelDAO, TipoCombustivelService> {

	public TipoCombustivelController() throws NumberFormatException {
		super(new TipoCombustivelService(), new TipoCombustivelDAO());
	}

	@Override
	public void sinc() throws Exception {
		super.sincOnlyRemote();
	}
}

package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.TipoVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.TipoVeiculo;
import br.com.cityconnect.integrador_sa_transportes.service.TipoVeiculoService;

public class TipoVeiculoController extends MainController<TipoVeiculo, TipoVeiculoDAO, TipoVeiculoService> {

	public TipoVeiculoController() {
		super(new TipoVeiculoService(), new TipoVeiculoDAO());
	}

	@Override
	public void sinc() throws Exception {
		super.sincOnlyRemote();
	}
}

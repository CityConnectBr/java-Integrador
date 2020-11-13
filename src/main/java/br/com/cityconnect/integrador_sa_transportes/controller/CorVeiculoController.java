package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.CorVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CorVeiculo;
import br.com.cityconnect.integrador_sa_transportes.service.CorVeiculoService;

public class CorVeiculoController extends MainController<CorVeiculo, CorVeiculoDAO, CorVeiculoService>{

	public CorVeiculoController() throws NumberFormatException {
		super(new CorVeiculoService(), new CorVeiculoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}

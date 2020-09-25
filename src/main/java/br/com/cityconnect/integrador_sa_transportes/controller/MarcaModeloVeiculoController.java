package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.MarcaModeloVeiculo;
import br.com.cityconnect.integrador_sa_transportes.service.MarcaModeloVeiculoService;

public class MarcaModeloVeiculoController extends MainController<MarcaModeloVeiculo, MarcaModeloVeiculoDAO, MarcaModeloVeiculoService>{

	public MarcaModeloVeiculoController() {
		super(new MarcaModeloVeiculoService(), new MarcaModeloVeiculoDAO());
	}
	
	@Override
	public void sinc() throws Exception {
		super.sincOnlyRemote();
	}

}

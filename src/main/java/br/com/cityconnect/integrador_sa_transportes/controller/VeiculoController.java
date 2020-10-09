package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.IOException;

import br.com.cityconnect.integrador_sa_transportes.dao.VeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Veiculo;
import br.com.cityconnect.integrador_sa_transportes.service.VeiculoService;

public class VeiculoController extends MainController<Veiculo, VeiculoDAO, VeiculoService> {

	public VeiculoController() throws NumberFormatException {
		super(new VeiculoService(), new VeiculoDAO());
	}

	@Override
	public void sinc() throws Exception {
		super.sincOnlyRemote();
	}

}

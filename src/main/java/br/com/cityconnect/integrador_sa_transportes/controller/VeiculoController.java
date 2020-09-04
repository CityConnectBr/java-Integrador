package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.VeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Veiculo;
import br.com.cityconnect.integrador_sa_transportes.service.VeiculoService;

public class VeiculoController extends MainController<Veiculo, VeiculoDAO, VeiculoService> {

	public VeiculoController() {
		super(new VeiculoService(), new VeiculoDAO());
	}

	@Override
	public void sinc() throws Exception {
		super.sincFull();
	}

}

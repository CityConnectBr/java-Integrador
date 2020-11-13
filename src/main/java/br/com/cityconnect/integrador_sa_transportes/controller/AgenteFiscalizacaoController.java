package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.AgenteFiscalizacaoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.AgenteFiscalizacao;
import br.com.cityconnect.integrador_sa_transportes.service.AgenteFiscalizacaoService;

public class AgenteFiscalizacaoController extends MainController<AgenteFiscalizacao, AgenteFiscalizacaoDAO, AgenteFiscalizacaoService> {

	public AgenteFiscalizacaoController() throws NumberFormatException {
		super(new AgenteFiscalizacaoService(), new AgenteFiscalizacaoDAO());
	}

	@Override
	public void sincAll() throws Exception {
		super.sincAllIgnoreChanges();
	}

}

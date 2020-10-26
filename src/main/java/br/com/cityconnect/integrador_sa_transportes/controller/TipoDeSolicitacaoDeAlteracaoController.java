package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.TipoDeSolicitacaoDeAlteracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.TipoDeSolicitacaoDeAlteracao;
import br.com.cityconnect.integrador_sa_transportes.service.TipoDeSolicitacaoDeAlteracapService;

public class TipoDeSolicitacaoDeAlteracaoController extends
		MainController<TipoDeSolicitacaoDeAlteracao, TipoDeSolicitacaoDeAlteracaoDAO, TipoDeSolicitacaoDeAlteracapService> {

	public TipoDeSolicitacaoDeAlteracaoController() throws NumberFormatException {
		super(new TipoDeSolicitacaoDeAlteracapService(), new TipoDeSolicitacaoDeAlteracaoDAO());
	}

}

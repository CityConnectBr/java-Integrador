package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.TipoDeSolicitacaoDeAlteracao;

public class TipoDeSolicitacaoDeAlteracaoDAO extends GenericDao<TipoDeSolicitacaoDeAlteracao, Long> {

	public TipoDeSolicitacaoDeAlteracaoDAO() {
		super();
	}

	public List<TipoDeSolicitacaoDeAlteracao> findAll() {
		return super.findAll();
	}

}

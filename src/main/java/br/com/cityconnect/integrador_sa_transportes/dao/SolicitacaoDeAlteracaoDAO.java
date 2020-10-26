package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.SolicitacaoDeAlteracao;
import br.com.cityconnect.integrador_sa_transportes.util.Util;

public class SolicitacaoDeAlteracaoDAO extends GenericDao<SolicitacaoDeAlteracao, Long> {

	public SolicitacaoDeAlteracaoDAO() {
		super();
	}

	public List<SolicitacaoDeAlteracao> findAll() {
		return super.findAll();
	}

	public boolean update(SolicitacaoDeAlteracao solicitacaoDeAlteracao) {
		return super.update((SolicitacaoDeAlteracao) new Util().copy(solicitacaoDeAlteracao,
				findById(solicitacaoDeAlteracao.getId())));
	}

}

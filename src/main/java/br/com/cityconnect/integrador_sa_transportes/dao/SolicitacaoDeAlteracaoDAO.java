package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.SolicitacaoDeAlteracao;

public class SolicitacaoDeAlteracaoDAO extends GenericDao<SolicitacaoDeAlteracao, Long> {

	public SolicitacaoDeAlteracaoDAO() {
		super();
	}

	public List<SolicitacaoDeAlteracao> findAll() {
		return super.findAll();
	}

	/*public boolean update(SolicitacaoDeAlteracao solicitacaoDeAlteracao) {
		return super.update((SolicitacaoDeAlteracao) new Util().copy(solicitacaoDeAlteracao,
				findById(solicitacaoDeAlteracao.getId())));
	}

	public List<SolicitacaoDeAlteracao> findNotSinc() {
		try {

			List<SolicitacaoDeAlteracao> listResult = (List<SolicitacaoDeAlteracao>) super.executeQuery(
					"from SolicitacaoDeAlteracao where status is not null and sincronizadoComAPI = false order by id");

			if (listResult != null && listResult.size() > 0) {
				return listResult;
			} else {
				return new ArrayList<>();
			}

		} catch (Exception e) {
			Logger.sendLog(this.getClass(), Logger.ERROR, e);
			return new ArrayList<>();
		}
	}

	public Boolean setSincronizado(SolicitacaoDeAlteracao solicitacao) {
		try {
			solicitacao = findById(solicitacao.getId());
			solicitacao.setSincronizadoComAPI(Boolean.TRUE);
			solicitacao.setDataHoraSincronizadoComAPI(new Date());

			return update(solicitacao);

		} catch (Exception e) {
			Logger.sendLog(this.getClass(), Logger.ERROR, e);
			return Boolean.FALSE;
		}
	}*/

}

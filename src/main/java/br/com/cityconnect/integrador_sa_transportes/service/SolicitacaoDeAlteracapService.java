package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.SolicitacaoDeAlteracao;

public class SolicitacaoDeAlteracapService extends MainService<SolicitacaoDeAlteracao> {

	public SolicitacaoDeAlteracapService() {
		super("/integracao/solicitacaoalteracao");
	}

	@Override
	protected SolicitacaoDeAlteracao jsonToObj(String json) {
		return gson.fromJson(json.toString(), SolicitacaoDeAlteracao.class);
	}

	@Override
	protected SolicitacaoDeAlteracao[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), SolicitacaoDeAlteracao[].class);
	}
	
	@Override
	public SolicitacaoDeAlteracao[] getAll() throws Exception {
		return new SolicitacaoDeAlteracao[0];
	}

}

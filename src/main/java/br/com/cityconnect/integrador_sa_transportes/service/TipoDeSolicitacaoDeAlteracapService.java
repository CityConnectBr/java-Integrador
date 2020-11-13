package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.TipoDeSolicitacaoDeAlteracao;

public class TipoDeSolicitacaoDeAlteracapService extends MainService<TipoDeSolicitacaoDeAlteracao> {

	public TipoDeSolicitacaoDeAlteracapService() {
		super("/integracao/tiposdesolicitacao");
	}

	@Override
	protected TipoDeSolicitacaoDeAlteracao jsonToObj(String json) {
		return gson.fromJson(json.toString(), TipoDeSolicitacaoDeAlteracao.class);
	}

	@Override
	protected TipoDeSolicitacaoDeAlteracao[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), TipoDeSolicitacaoDeAlteracao[].class);
	}
	
	

}

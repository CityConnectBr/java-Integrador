package br.com.cityconnect.integrador_sa_transportes.service;

import br.com.cityconnect.integrador_sa_transportes.entity.TalaoDoFiscal;

public class TalaoDoFiscalService extends MainService<TalaoDoFiscal> {

	public TalaoDoFiscalService() {
		super("/integracao/taloesdofiscal");
	}

	@Override
	protected TalaoDoFiscal jsonToObj(String json) {
		System.out.println(json);
		return gson.fromJson(json.toString(), TalaoDoFiscal.class);
	}

	@Override
	protected TalaoDoFiscal[] jsonListToObjList(String json) {
		return gson.fromJson(json.toString(), TalaoDoFiscal[].class);
	}
	
	@Override
	public TalaoDoFiscal[] getAll() throws Exception {
		return new TalaoDoFiscal[0];
	}

}

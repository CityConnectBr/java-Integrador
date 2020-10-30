package br.com.cityconnect.integrador_sa_transportes.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;

import br.com.cityconnect.integrador_sa_transportes.entity.SolicitacaoDeAlteracao;

public class SolicitacaoDeAlteracapService extends MainService<SolicitacaoDeAlteracao> {

	public SolicitacaoDeAlteracapService() {
		super("/integracao/solicitacaodealteracao");
	}

	@Override
	protected SolicitacaoDeAlteracao jsonToObj(String json) {
		JSONObject jsonObject = new JSONObject(json);

		jsonObject.put("sincronizado", jsonObject.get("sincronizado").equals("1"));

		return gson.fromJson(jsonObject.toString(), SolicitacaoDeAlteracao.class);
	}

	@Override
	protected SolicitacaoDeAlteracao[] jsonListToObjList(String json) {
		JSONArray jsonArray = new JSONArray(json);

		SolicitacaoDeAlteracao[] auxiliarList = new SolicitacaoDeAlteracao[jsonArray.length()];

		for (int i = 0; i < jsonArray.length(); i++) {
			if (jsonArray.get(i) != null) {
				auxiliarList[i] = (jsonToObj(jsonArray.get(i).toString()));
			}
		}

		return auxiliarList;
	}

	public void setSinc(String id) {
		System.out.println(url + "/" + id + "/setsinc");
		restTemplate.put(url + "/" + id + "/setsinc", new HttpEntity<String>(headers), String.class);
	}

	public void setStatus(SolicitacaoDeAlteracao solicitacaoDeAlteracao) {

		String param = "{\"motivo_recusado\": \""
				+ (solicitacaoDeAlteracao.getMotivoRecusado() != null ? solicitacaoDeAlteracao.getMotivoRecusado() : "")
				+ "\"}";

		System.out.println(
				url + "/" + solicitacaoDeAlteracao.getId() + "/setstatus/" + solicitacaoDeAlteracao.getStatus());
		restTemplate.put(
				url + "/" + solicitacaoDeAlteracao.getId() + "/setstatus/" + solicitacaoDeAlteracao.getStatus(),
				new HttpEntity<String>(param, headers), String.class);
	}

}

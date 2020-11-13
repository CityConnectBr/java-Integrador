package br.com.cityconnect.integrador_sa_transportes.testes;

import br.com.cityconnect.integrador_sa_transportes.dao.SolicitacaoDeAlteracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.SolicitacaoDeAlteracao;

public class Teste2 {

	public static void main(String args[]) throws Exception {

		SolicitacaoDeAlteracaoDAO solicitacaoDeAlteracaoDAO = new SolicitacaoDeAlteracaoDAO();
		
		solicitacaoDeAlteracaoDAO.save(new SolicitacaoDeAlteracao());
		

	}

}

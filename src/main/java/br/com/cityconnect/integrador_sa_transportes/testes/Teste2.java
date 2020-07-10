package br.com.cityconnect.integrador_sa_transportes.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cityconnect.integrador_sa_transportes.dao.ConnectionFactory;

public class Teste2 {
	
	public static void main(String args[]) throws SQLException {
		Connection conn = ConnectionFactory.createConnection();
        
		String sql = "SELECT nome FROM permissionarios;";
		PreparedStatement ps = conn.prepareStatement(sql);
		 
		//Executa o comando de consulta aonde guarda os dados retornados dentro do ResultSet.
		//Pelo fato de gerar uma lista de valores, é necessário percorrer os dados através do laço while 
		ResultSet rs = ps.executeQuery();
		//Faz a verificação de enquanto conter registros, percorre e resgata os valores
		while(rs.next()){
		    
		    System.out.printf(rs.getString("nome"));
			
			
		}
	}

}

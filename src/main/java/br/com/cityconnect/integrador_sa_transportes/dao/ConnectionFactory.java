package br.com.cityconnect.integrador_sa_transportes.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection createConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/satransportes"; //Nome da base de dados
        String user = "root"; //nome do usuário do MySQL
        String password = "123456"; //senha do MySQL
         
        Connection conexao = null;
        conexao = DriverManager.getConnection(url, user, password);
         
        return conexao;
    }

}

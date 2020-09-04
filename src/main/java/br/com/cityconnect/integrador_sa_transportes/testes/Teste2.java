package br.com.cityconnect.integrador_sa_transportes.testes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Properties;

public class Teste2 {
	
	public static void main(String args[]) throws SQLException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		Properties properties = new Properties();
		try(OutputStream outputStream = new FileOutputStream("teste.properties")){  
		    properties.setProperty("prop1", "Value1");
		    properties.setProperty("prop2", "Value2");
		    properties.store(outputStream, null);
		} catch (IOException e) {
		    e.printStackTrace();
		} 
		
		
	}

}

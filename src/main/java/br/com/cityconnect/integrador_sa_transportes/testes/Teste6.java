package br.com.cityconnect.integrador_sa_transportes.testes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Base64;

public class Teste6 {

	public static void main(String[] args)
	   {
		
		args = new String[] {"/Users/elongomesvieira/Aux/3x4-foto.jpg"};
		
	      if (args.length != 1)
	      {
	         System.err.println("usage: java FileEncDec filename");
	         return;
	      }
	      try (FileInputStream fis = new FileInputStream(args[0]))
	      {
	         Base64.Encoder enc1 = Base64.getEncoder();
	         OutputStream os1 = enc1.wrap(new FileOutputStream(args[0]));
	         int _byte;
	         while ((_byte = fis.read()) != -1)
	         {
	            os1.write(_byte);
	         }
	         os1.close();
	      }
	      catch (IOException ioe)
	      {
	         System.err.printf("I/O error: %s%n", ioe.getMessage());
	      }
	      try (FileOutputStream fos1 = new FileOutputStream("1" + args[0]))
	      {
	         Base64.Decoder dec1 = Base64.getDecoder();
	         InputStream is1 = dec1.wrap(new FileInputStream(args[0]));
	         int _byte;
	         while ((_byte = is1.read()) != -1)
	            fos1.write(_byte);

	         is1.close();
	      }
	      catch (IOException ioe)
	      {
	         System.err.printf("I/O error: %s%n", ioe.getMessage());
	      }
	   }
	
}

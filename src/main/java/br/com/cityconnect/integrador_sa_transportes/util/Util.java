package br.com.cityconnect.integrador_sa_transportes.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

public class Util {

	private static SimpleDateFormat sDtFormatHora = new SimpleDateFormat("HH:mm:ss");
	private static SimpleDateFormat sDtFormatHoraMinuto = new SimpleDateFormat("HH:mm");
	private static SimpleDateFormat sDtFormatData = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sDtFormatDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private final Pattern hasUppercase = Pattern.compile("[A-Z]");
	private final Pattern hasLowercase = Pattern.compile("[a-z]");
	private final Pattern hasNumber = Pattern.compile("\\d");
	private final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");

	public boolean compareObjects(Object obj1, Object obj2) {
		try {
			if (obj1 == null || obj2 == null) {
				throw new Exception("Objetos nulos não podem ser comparados.");
			} else if (!obj1.getClass().equals(obj2.getClass())) {
				throw new Exception("Classes diferentes não podem ser comparadas.");
			}

			for (Field f : obj1.getClass().getDeclaredFields()) {

				if (f.getName().equals("idIntegracao")) {
					continue;
				}

				// pulando campos com anotacao UpdateTimestamp e ScapeComparator
				if (Arrays.asList(f.getDeclaredAnnotations()).stream()
						.filter(a -> a.toString().contains("UpdateTimestamp")).count() > 0
						|| Arrays.asList(f.getDeclaredAnnotations()).stream()
								.filter(a -> a.toString().contains("ScapeComparator")).count() > 0) {

					continue;
				}

				f.setAccessible(true);// setando private como acessivel
				String valor1 = null, valor2 = null;

				if (f.getType().equals(String.class)) {
					valor1 = setNullIfEmpty((String) f.get(obj1));
					valor2 = setNullIfEmpty((String) f.get(obj2));
				} else {
					valor1 = String.valueOf(f.get(obj1));
					valor2 = String.valueOf(f.get(obj2));
				}
				// System.out.println(f.getName()+"--"+valor1 + " - " + valor2+" -
				// "+isEquals(valor1, valor2));

				if (!isEquals(valor1, valor2)) {
					return Boolean.FALSE;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public Object copy(Object obj1, Object obj2) {
		try {
			if (obj1 == null || obj2 == null) {
				throw new Exception("Objetos nulos não podem ser copiados.");
			} else if (!obj1.getClass().equals(obj2.getClass())) {
				throw new Exception("Classes diferentes não podem ser copiados.");
			}

			for (Field f : obj1.getClass().getDeclaredFields()) {

				// pulando campos com UpdateTimestamp ou ScapeComparator
				if (Arrays.asList(f.getDeclaredAnnotations()).stream()
						.filter(a -> a.toString().contains("UpdateTimestamp")).count() > 0
						|| Arrays.asList(f.getDeclaredAnnotations()).stream()
								.filter(a -> a.toString().contains("ScapeComparator")).count() > 0) {
					continue;
				}

				f.setAccessible(true);// setando private como acessivel
				Object valor1 = null, valor2 = null;

				if (f.getType().equals(String.class)) {
					valor1 = setNullIfEmpty((String) f.get(obj1));
					valor2 = setNullIfEmpty((String) f.get(obj2));
				} else {
					valor1 = f.get(obj1);
					valor2 = f.get(obj2);
				}
				// System.out.println(f.getName()+"--"+valor1 + " - " + valor2);

				if (!isEquals(valor1, valor2)) {
					f.set(obj2, valor1);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return obj2;
	}

	public String setNullIfEmpty(String txt) {
		return txt != null ? (txt.replace(" ", "").isEmpty() ? null : txt) : null;
	}

	public boolean isEquals(Object s1, Object s2) {
		try {
			if (s1 == null || s2 == null) {
				return s1 == null && s2 == null ? Boolean.TRUE : Boolean.FALSE;
			} else {
				return s1.equals(s2);
			}
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	public String getNumeroAleatorio(int qtd) {
		Random random = new Random();
		String numero = "";
		for (int cont = 0; cont < qtd; cont++) {
			Integer n = random.nextInt(9);
			numero = numero + String.valueOf(n);
		}
		return numero;
	}

	public String getSenhaAleatorio(int qtd) {
		Random random = new Random();
		String string = "";
		for (int cont = 0; cont < qtd; cont++) {
			switch (random.nextInt(3)) {
			case 0:
				string = string + (char) (random.nextInt(9) + '1');
				break;
			case 1:
				string = string + (char) (random.nextInt(26) + 'A');
				break;
			case 2:
				string = string + (char) (random.nextInt(26) + 'a');
				break;
			}
		}
		return string;
	}

	public Boolean writeFile(InputStream input, File newFile) throws IOException {
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(newFile);

			int r = 0;
			while ((r = input.read()) != -1) {
				output.write(r);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		} finally {
			if (output != null) {
				output.close();
			}
		}

		return newFile.exists();
	}

	public String formatTelephone(String ddd, String numero) {
		try {
			if (numero == null || numero.trim().isEmpty())
				return "";

			String nFormated = "";

			nFormated = ddd != null && !ddd.isEmpty() ? "(" + ddd.trim() + ") " : "(xx) ";
			numero = numero.replace(" ", "");
			if (numero.contains("-")) {
				nFormated += numero;
			} else {
				String part2 = numero.substring(numero.length() - 4, numero.length());
				Integer part1 = new Integer(numero.substring(0, numero.indexOf(part2)));
				nFormated += part1 + "-" + part2;
			}
			return nFormated;
		} catch (Exception e) {
			return "";
		}
	}

	public String clearNumber(String number, int limit) {
		try {
			number = number.replace(".", "").replace("-", "");

			if (number.length() > 9) {
				number = number.substring(0, 8);
			}

			return number;
		} catch (Exception e) {
			return "";
		}

	}

	public Boolean toBoolean(String str) {
		try {
			return str != null ? str.equalsIgnoreCase("S") : null;
		} catch (Exception e) {
			return null;
		}

	}

	public String limit(String number, int limit) {
		try {
			number = number.replace(".", "").replace("-", "");

			if (number.length() > 9) {
				number = number.substring(0, 8);
			}

			return number;
		} catch (Exception e) {
			return "";
		}

	}

}
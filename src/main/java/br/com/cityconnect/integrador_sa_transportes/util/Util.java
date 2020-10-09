package br.com.cityconnect.integrador_sa_transportes.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

				if(f.getName().equals("idIntegracao")) {
					continue;
				}
				
				// pulando campos com anotacao UpdateTimestamp
				if (Arrays.asList(f.getDeclaredAnnotations()).stream()
						.filter(a -> a.toString().contains("UpdateTimestamp")).count() > 0) {
					System.out.println("IF AKI");
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

				// pulando campos com UpdateTimestamp
				if (Arrays.asList(f.getDeclaredAnnotations()).stream()
						.filter(a -> a.toString().contains("UpdateTimestamp")).count() > 0) {
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

}
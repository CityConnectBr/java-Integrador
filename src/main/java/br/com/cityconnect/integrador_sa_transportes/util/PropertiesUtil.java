package br.com.cityconnect.integrador_sa_transportes.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static final String KEY_URL_API = "url_api";
	public static final String KEY_API_TOKEN = "api_token";
	public static final String KEY_DB_HOST = "db_host";
	public static final String KEY_DB_NAME = "db_name";
	public static final String KEY_DB_USER = "db_user";
	public static final String KEY_DB_PASS = "db_pass";
	public static final String KEY_REFRESH_TIME = "refresh_time";
	public static final String KEY_SINC_ALL = "sinc_all";

	private File filePropertie = null;
	private Properties properties;

	public PropertiesUtil() throws IOException {
		filePropertie = new File("cityconnect_integrador_config.properties");
		if (!filePropertie.exists()) {
			filePropertie.createNewFile();
		}

		properties = new Properties();
		properties.load(new FileReader(filePropertie));
	}

	public String getValue(String key) {
		Object obj = properties.get(key);
		return obj != null ? obj.toString() : null;
	}

	public void setValue(String key, String value) {
		try (OutputStream outputStream = new FileOutputStream(filePropertie)) {
			properties.setProperty(key, value);
			properties.store(outputStream, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

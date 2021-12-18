package br.com.cityconnect.integrador_sa_transportes;


import javax.swing.JOptionPane;

import br.com.cityconnect.integrador_sa_transportes.controller.MainController;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;
import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;

public class Main {

	public static void main(String[] args) {

		try {
			PropertiesUtil pu = new PropertiesUtil();

			if (pu.getValue(PropertiesUtil.KEY_URL_API) == null || pu.getValue(PropertiesUtil.KEY_API_TOKEN) == null
					|| pu.getValue(PropertiesUtil.KEY_DB_HOST) == null
					|| pu.getValue(PropertiesUtil.KEY_DB_NAME) == null
					|| pu.getValue(PropertiesUtil.KEY_DB_PASS) == null
					|| pu.getValue(PropertiesUtil.KEY_REFRESH_TIME) == null) {
				JOptionPane.showMessageDialog(null,
						"Não foi possível iniciar. Verifique os dados para conexão com a API e com o Banco de Dados",
						"Erro", JOptionPane.WARNING_MESSAGE);
			} else {
				MainController.sincAllMainThread();
			}

		} catch (Exception e) {
			Logger.sendLog(Main.class, Logger.ERROR, e);
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as propriedades", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}

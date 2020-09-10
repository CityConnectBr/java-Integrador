package br.com.cityconnect.integrador_sa_transportes;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.com.cityconnect.integrador_sa_transportes.controller.MainController;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;
import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;
import br.com.cityconnect.integrador_sa_transportes.view.ControleJFrame;
import br.com.cityconnect.integrador_sa_transportes.view.PropertiesJFrame;

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
				new PropertiesJFrame(Boolean.TRUE);
			} else {
				MainController.sincAll();
			}

		} catch (Exception e) {
			Logger.sendLog(Main.class, Logger.ERROR, e);
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao carregar as propriedades", "Erro",
					JOptionPane.ERROR_MESSAGE);
		}

		// checking for support
		if (!SystemTray.isSupported()) {
			JOptionPane.showMessageDialog(null, "Não existem suporte ao Sys Treay", "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		// get the systemTray of the system
		SystemTray systemTray = SystemTray.getSystemTray();

		Image image = Toolkit.getDefaultToolkit().getImage("images/icon.png");

		// popupmenu
		PopupMenu trayPopupMenu = new PopupMenu();

		MenuItem action = new MenuItem("Controle");
		action.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ControleJFrame.newControleJFrame(true);
			}
		});
		trayPopupMenu.add(action);

		// 2nd menuitem of popupmenu
		MenuItem properties = new MenuItem("Propriedades");
		properties.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PropertiesJFrame(Boolean.FALSE);
			}
		});
		trayPopupMenu.add(properties);

		// 3nd menuitem of popupmenu
		MenuItem close = new MenuItem("Fechar");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		trayPopupMenu.add(close);

		// setting tray icon
		TrayIcon trayIcon = new TrayIcon(image, "Integrador City Connect", trayPopupMenu);
		// adjust to default size as per system recommendation
		trayIcon.setImageAutoSize(true);

		try {
			systemTray.add(trayIcon);
		} catch (AWTException awtException) {
			awtException.printStackTrace();
		}

	}
}

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

public class Main {

	public static void main(String[] args) {
		// checking for support
		if (!SystemTray.isSupported()) {
			JOptionPane.showMessageDialog(null, "Não existem suporte ao Sys Treay", "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		// get the systemTray of the system
		SystemTray systemTray = SystemTray.getSystemTray();

		Image image = Toolkit.getDefaultToolkit().getImage("src/icon.png");

		// popupmenu
		PopupMenu trayPopupMenu = new PopupMenu();

		/*// 1t menuitem for popupmenu
		MenuItem action = new MenuItem("Action");
		action.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Action Clicked");
			}
		});
		trayPopupMenu.add(action);*/

		// 2nd menuitem of popupmenu
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

	}// end of main
}

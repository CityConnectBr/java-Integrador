package br.com.cityconnect.integrador_sa_transportes.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.cityconnect.integrador_sa_transportes.controller.MainController;
import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;

public class PropertiesJFrame {

	private JFrame frame;
	private JTextField textFieldURLAPI;
	private JTextField textFieldAPIToken;
	private JTextField textFieldDBHost;
	private JTextField textFieldDBName;
	private JTextField textFieldDBUser;
	private JTextField textFieldDBPass;
	private JTextField textFieldRefreshTime;

	private PropertiesUtil pu;

	private String textURLAPI;
	private String textURLToken;
	private String textDBHost;
	private String textDBName;
	private String textDBUser;
	private String textDBPass;
	private String textRefreshTime;

	private boolean firstConfig = Boolean.FALSE;

	/**
	 * Create the application.
	 */
	public PropertiesJFrame(boolean firstOpen) {
		try {
			pu = new PropertiesUtil();

			textURLAPI = pu.getValue(PropertiesUtil.KEY_URL_API);
			textURLToken = pu.getValue(PropertiesUtil.KEY_API_TOKEN);
			textDBHost = pu.getValue(PropertiesUtil.KEY_DB_HOST);
			textDBName = pu.getValue(PropertiesUtil.KEY_DB_NAME);
			textDBUser = pu.getValue(PropertiesUtil.KEY_DB_USER);
			textDBPass = pu.getValue(PropertiesUtil.KEY_DB_PASS);
			textRefreshTime = pu.getValue(PropertiesUtil.KEY_REFRESH_TIME);

			this.firstConfig = firstOpen;
		} catch (Exception e) {
			e.printStackTrace();
		}

		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 339);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl = new JLabel("Configurações");
		lbl.setBounds(17, 6, 204, 14);
		frame.getContentPane().add(lbl);

		JLabel lblUrlApi = new JLabel("URL API:");
		lblUrlApi.setBounds(17, 32, 83, 14);
		frame.getContentPane().add(lblUrlApi);

		textFieldURLAPI = new JTextField(textURLAPI);
		textFieldURLAPI.setBounds(101, 29, 444, 20);
		frame.getContentPane().add(textFieldURLAPI);
		textFieldURLAPI.setColumns(10);

		JLabel lblAPIToken = new JLabel("API Token");
		lblAPIToken.setBounds(17, 67, 83, 14);
		frame.getContentPane().add(lblAPIToken);

		textFieldAPIToken = new JTextField(textURLToken);
		textFieldAPIToken.setBounds(101, 64, 444, 20);
		frame.getContentPane().add(textFieldAPIToken);
		textFieldAPIToken.setColumns(10);

		JLabel lblDBHost = new JLabel("DB Host:");
		lblDBHost.setBounds(17, 102, 83, 14);
		frame.getContentPane().add(lblDBHost);

		textFieldDBHost = new JTextField(textDBHost);
		textFieldDBHost.setColumns(10);
		textFieldDBHost.setBounds(101, 99, 444, 20);
		frame.getContentPane().add(textFieldDBHost);

		JLabel lblDBName = new JLabel("DB Name:");
		lblDBName.setBounds(17, 137, 83, 14);
		frame.getContentPane().add(lblDBName);

		textFieldDBName = new JTextField(textDBName);
		textFieldDBName.setColumns(10);
		textFieldDBName.setBounds(101, 134, 444, 20);
		frame.getContentPane().add(textFieldDBName);

		JLabel lblDbUser = new JLabel("DB User:");
		lblDbUser.setBounds(17, 172, 83, 14);
		frame.getContentPane().add(lblDbUser);

		textFieldDBUser = new JTextField(textDBUser);
		textFieldDBUser.setColumns(10);
		textFieldDBUser.setBounds(101, 169, 444, 20);
		frame.getContentPane().add(textFieldDBUser);

		JLabel lblDBPass = new JLabel("DB Pass:");
		lblDBPass.setBounds(17, 207, 83, 14);
		frame.getContentPane().add(lblDBPass);

		textFieldDBPass = new JTextField(textDBPass);
		textFieldDBPass.setColumns(10);
		textFieldDBPass.setBounds(101, 204, 444, 20);
		frame.getContentPane().add(textFieldDBPass);

		JLabel lblRefreshTime = new JLabel("Refresh(sec):");
		lblRefreshTime.setBounds(17, 242, 83, 14);
		frame.getContentPane().add(lblRefreshTime);

		textFieldRefreshTime = new JTextField(textRefreshTime);
		textFieldRefreshTime.setColumns(10);
		textFieldRefreshTime.setBounds(101, 239, 444, 20);
		frame.getContentPane().add(textFieldRefreshTime);

		JButton btnSubmit = new JButton("Salvar");

		btnSubmit.setForeground(Color.DARK_GRAY);
		btnSubmit.setBounds(459, 276, 89, 23);
		frame.getContentPane().add(btnSubmit);

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textFieldURLAPI.getText().isEmpty() || textFieldAPIToken.getText().isEmpty()
						|| textFieldDBHost.getText().isEmpty() || textFieldDBName.getText().isEmpty()
						|| textFieldDBUser.getText().isEmpty() || textFieldDBPass.getText().isEmpty()
						|| textFieldRefreshTime.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				else {
					try {

						pu.setValue(PropertiesUtil.KEY_URL_API, textFieldURLAPI.getText());
						pu.setValue(PropertiesUtil.KEY_API_TOKEN, textFieldAPIToken.getText());
						pu.setValue(PropertiesUtil.KEY_DB_HOST, textFieldDBHost.getText());
						pu.setValue(PropertiesUtil.KEY_DB_NAME, textFieldDBName.getText());
						pu.setValue(PropertiesUtil.KEY_DB_USER, textFieldDBUser.getText());
						pu.setValue(PropertiesUtil.KEY_DB_PASS, textFieldDBPass.getText());
						pu.setValue(PropertiesUtil.KEY_REFRESH_TIME, textFieldRefreshTime.getText());
						pu.setValue(PropertiesUtil.KEY_SINC_ALL, "false");

						if (firstConfig) {
							MainController.sincAll(Boolean.TRUE);
						}

						frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Ocorreu um erro ao salvar as propriedades", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

	}
}

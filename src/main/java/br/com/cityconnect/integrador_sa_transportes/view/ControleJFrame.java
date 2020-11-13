package br.com.cityconnect.integrador_sa_transportes.view;

import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.cityconnect.integrador_sa_transportes.util.SincProcessObservableUtil;

public class ControleJFrame implements Observer {

	private static ControleJFrame controleJFrame = null;

	private JFrame frame;
	private JProgressBar progressBarGeral;
	private JProgressBar progressBarParcial;
	private JLabel labelAcao;
	private JLabel labelObjeto;
	private JLabel labelDescAndamento;
	private JTextArea textArea;
	private JScrollPane jscrollPane;
	private String lastSbTxtArea = "";

	private StringBuilder sbTxArea = new StringBuilder();

	/**
	 * Create the application.
	 */
	private ControleJFrame() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

		initialize();
		frame.setVisible(true);
	}

	public static Object newControleJFrame(boolean show) {
		if (controleJFrame == null) {
			controleJFrame = new ControleJFrame();

			if (show) {
				controleJFrame.show();
			} else {
				controleJFrame.hide();
			}

		}

		return controleJFrame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 568, 476);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl = new JLabel("Controle de Execução");
		lbl.setBounds(17, 6, 204, 14);
		frame.getContentPane().add(lbl);

		labelAcao = new JLabel("");
		labelAcao.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		labelAcao.setBounds(17, 64, 531, 14);
		frame.getContentPane().add(labelAcao);

		labelObjeto = new JLabel("");
		labelObjeto.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		labelObjeto.setBounds(17, 85, 531, 37);
		frame.getContentPane().add(labelObjeto);

		progressBarGeral = new JProgressBar(0, 100);
		progressBarGeral.setBounds(17, 32, 531, 20);
		frame.getContentPane().add(progressBarGeral);

		progressBarParcial = new JProgressBar(0, 100);
		progressBarParcial.setBounds(17, 134, 531, 20);
		frame.getContentPane().add(progressBarParcial);

		labelDescAndamento = new JLabel("");
		labelDescAndamento.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		labelDescAndamento.setBounds(17, 155, 150, 14);
		frame.getContentPane().add(labelDescAndamento);

		textArea = new JTextArea();
		textArea.setBounds(17, 181, 531, 254);

		jscrollPane = new JScrollPane(textArea);
		jscrollPane.setBounds(17, 181, 531, 254);
		jscrollPane.setAutoscrolls(Boolean.TRUE);
		jscrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				e.getAdjustable().setValue(e.getAdjustable().getMaximum());
			}
		});

		frame.getContentPane().add(jscrollPane);

	}

	@Override
	public void update(Observable o, Object arg) {
		SincProcessObservableUtil sincObservable = (SincProcessObservableUtil) o;

		if (sincObservable.getStatus().equals(SincProcessObservableUtil.STATUS_EM_PROCESSO)) {

			Float fPercentTotal = (new Float(sincObservable.getPosOfProcess())
					/ new Float(sincObservable.getTotalOfProcess())) * 100F;
			Float fPercent = (new Float(sincObservable.getPosOfSubProcess())
					/ new Float(sincObservable.getTotalOfSubProcess())) * 100F;

			if (sincObservable.getActionOfSubProcess() != null) {

				this.progressBarGeral.setValue(fPercentTotal.intValue());
				this.progressBarParcial.setValue(fPercent.intValue());
				this.labelDescAndamento
						.setText(sincObservable.getPosOfSubProcess() + "/" + sincObservable.getTotalOfSubProcess());
				this.labelAcao.setText(sincObservable.getActionOfSubProcess());
				// this.labelObjeto.setText(flogObservable.getObjStrAtual());

				if (!lastSbTxtArea.equals(sincObservable.getActionOfSubProcess())) {
					lastSbTxtArea = sincObservable.getActionOfSubProcess();
					this.sbTxArea.append(sincObservable.getActionOfSubProcess() + "\n");
					// this.sbTxArea.append(flogObservable.getObjStrAtual() + "\n");
				}

				if (this.sbTxArea.length() > 100000) {
					this.sbTxArea = new StringBuilder();
				}

				this.textArea.setText(this.sbTxArea.toString());
			}
		} else {
			this.labelAcao.setText(sincObservable.getStatus());
			this.labelDescAndamento.setText("");
			this.progressBarGeral.setValue(0);
		}

	}

	public void hide() {
		this.frame.setVisible(false);
	}

	public void show() {
		this.frame.setVisible(true);
	}
}

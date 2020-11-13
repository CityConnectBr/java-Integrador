package br.com.cityconnect.integrador_sa_transportes.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPopupMenu.Separator;

import lombok.Getter;

public class SincProcessObservableUtil extends Observable {

	public static String STATUS_INICIADO = "iniciado";
	public static String STATUS_PROCURANDO_ATUALIZACOES = "procurando atualizações";
	public static String STATUS_EM_PROCESSO = "em processo";
	public static String STATUS_FINALIZADO = "finalizado";

	public static String SEPARATOR_20TRACES = "\n--------------------\n";
	public static String SEPARATOR_3TRACES = "\n---\n";
	public static String SEPARATOR_BREAK_LINE = "\n";
	public static String SEPARATOR_ARROW = "-->";
	public static String SEPARATOR_20DOTS = "\n....................\n";

	public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm:ss 'horas'");

	@Getter
	private String status = null;
	@Getter
	private Integer totalOfProcess = 0;
	@Getter
	private Integer posOfProcess = null;
	@Getter
	private Integer totalOfSubProcess = 0;
	@Getter
	private Integer posOfSubProcess = 0;
	@Getter
	private String actionOfSubProcess;
	@Getter
	private String separator = null;

	@Getter
	private static SincProcessObservableUtil sincProcessObservableUtil = null;

	private SincProcessObservableUtil(Integer totalOfProcess, Observer observer) {
		this.totalOfProcess = totalOfProcess;
		this.addObserver(observer);
		this.status = STATUS_INICIADO;
	}

	public static SincProcessObservableUtil newProcess(Integer totalOfSubProcess, Observer observer) {

		SincProcessObservableUtil.sincProcessObservableUtil = new SincProcessObservableUtil(totalOfSubProcess,
				observer);

		return SincProcessObservableUtil.sincProcessObservableUtil;
	}

	public void endProcess() {
		SincProcessObservableUtil.sincProcessObservableUtil.status = "Finalizado...";
		this.actionOfSubProcess = "";

		this.posOfProcess = this.totalOfProcess;

		this.status = STATUS_FINALIZADO;

		setChanged();
		notifyObservers();
	}

	public void startProcess(Integer listSize, String action) {
		this.status = STATUS_EM_PROCESSO;

		if (this.posOfProcess == null) {
			this.posOfProcess = 0;
		} else {
			this.posOfProcess++;
		}

		this.posOfSubProcess = 0;
		this.totalOfSubProcess = listSize;
		this.actionOfSubProcess = (action == null ? " >> " : action + ": ") + simpleDateFormat.format(new Date()) + ", com "
				+ listSize + " novos itens encontrados.";
		setChanged();
		notifyObservers();
	}

	public void nextOfSubProcess(String actionOfSubProcess) {
		++this.posOfSubProcess;

		this.actionOfSubProcess = actionOfSubProcess;
		setChanged();
		notifyObservers();
	}

	public void setStringInfo(String actionOfSubProcess) {
		this.actionOfSubProcess = actionOfSubProcess;
		setChanged();
		notifyObservers();
	}

	public void setStatus(String status) {
		this.status = status;
		setChanged();
		notifyObservers();
	}

	public void addSeparator(String separator) {
		this.separator = separator;
		setChanged();
		notifyObservers();
		this.separator = null;
	}

}

package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import br.com.cityconnect.integrador_sa_transportes.dao.AgenteFiscalizacaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.CondutoreAuxiliareDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.CorVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.GenericDao;
import br.com.cityconnect.integrador_sa_transportes.dao.HistoricoDeSincronizacaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloCarroceriaDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloChassiDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.OnibusDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.SolicitacaoDeAlteracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TipoCombustivelDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TipoDeSolicitacaoDeAlteracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TipoVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.VeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.HistoricoDeSincronizacao;
import br.com.cityconnect.integrador_sa_transportes.entity.SolicitacaoDeAlteracao;
import br.com.cityconnect.integrador_sa_transportes.entity.TipoDeSolicitacaoDeAlteracao;
import br.com.cityconnect.integrador_sa_transportes.service.SolicitacaoDeAlteracapService;
import br.com.cityconnect.integrador_sa_transportes.service.TipoDeSolicitacaoDeAlteracapService;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;
import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;
import br.com.cityconnect.integrador_sa_transportes.util.Util;
import br.com.cityconnect.integrador_sa_transportes.view.ControleJFrame;
import lombok.Getter;

public abstract class MainController<T extends Serializable, T_DAO, T_SERVICE> extends Observable {

	private Util util = new Util();

	private T_DAO dao;
	private T_SERVICE service;

	private static Thread mainThread = null;

	@Getter
	private String status = "Iniciando...";
	@Getter
	private String acaoAtual;
	@Getter
	private String objStrAtual;
	@Getter
	private Integer posAtual;
	@Getter
	private Integer total;
	@Getter
	private Integer posAtualGeral = 0;
	@Getter
	private static Integer totalGeral = 11;

	private static Integer refreshTime = 3600;// uma hora

	public MainController(T_SERVICE service, T_DAO dao) throws NumberFormatException {
		this.service = service;
		this.dao = dao;
		try {
			this.refreshTime = new Integer(new PropertiesUtil().getValue(PropertiesUtil.KEY_REFRESH_TIME));
		} catch (Exception e) {
			this.refreshTime = 3600;
		}
	}

	private MainController() {
	}

	private static Map<String, GenericDao> daoMap = new HashMap<String, GenericDao>() {
		{
			put(HistoricoDeSincronizacaoDAO.AGENTES_FISCALIZACAO_TABLE, new AgenteFiscalizacaoDAO());
			put(HistoricoDeSincronizacaoDAO.CONDUTOR_TABLE, new CondutoreAuxiliareDAO());
			put(HistoricoDeSincronizacaoDAO.CORES_VEICULOS_TABLE, new CorVeiculoDAO());
			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_CARROCERIAS_TABLE, new MarcaModeloCarroceriaDAO());
			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_CHASSIS_TABLE, new MarcaModeloChassiDAO());
			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_VEICULOS_TABLE, new MarcaModeloVeiculoDAO());
			// put(HistoricoDeSincronizacaoDAO.MONITORES_TABLE, new Moni);
			put(HistoricoDeSincronizacaoDAO.ONIBUS_TABLE, new OnibusDAO());
			put(HistoricoDeSincronizacaoDAO.PERMISSIONARIOS_TABLE, new PermissionarioDAO());
			put(HistoricoDeSincronizacaoDAO.TIPOSCOMBUSTIVEIS_TABLE, new TipoCombustivelDAO());
			put(HistoricoDeSincronizacaoDAO.TIPOSVEICULOS_TABLE, new TipoVeiculoDAO());
			put(HistoricoDeSincronizacaoDAO.VEICULOS_TABLE, new VeiculoDAO());
		}
	};

	private static Map<String, MainController> controllerMap = new HashMap<String, MainController>() {
		{
			// put(HistoricoDeSincronizacaoDAO.AGENTES_FISCALIZACAO_TABLE, new Agente));
			put(HistoricoDeSincronizacaoDAO.CONDUTOR_TABLE, new CondutorAuxiliarController());
			put(HistoricoDeSincronizacaoDAO.CORES_VEICULOS_TABLE, new CorVeiculoController());
			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_CARROCERIAS_TABLE, new MarcaModeloCarroceriaController());
			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_CHASSIS_TABLE, new MarcaModeloChassiController());
			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_VEICULOS_TABLE, new MarcaModeloVeiculoController());
			// put(HistoricoDeSincronizacaoDAO.MONITORES_TABLE, new Moni);
			put(HistoricoDeSincronizacaoDAO.ONIBUS_TABLE, new OnibusController());
			put(HistoricoDeSincronizacaoDAO.PERMISSIONARIOS_TABLE, new PermissionarioController());
			put(HistoricoDeSincronizacaoDAO.TIPOSCOMBUSTIVEIS_TABLE, new TipoCombustivelController());
			put(HistoricoDeSincronizacaoDAO.TIPOSVEICULOS_TABLE, new TipoVeiculoController());
			put(HistoricoDeSincronizacaoDAO.VEICULOS_TABLE, new VeiculoController());
		}
	};

	private void sendToAPI(T obj) throws Exception {

		//
		// CADASTRO E ATUALIZACAO
		//

		this.setAtualProgress("Verificando", obj.toString());

		String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();

		T objByService = (T) service.getClass().getMethod("get", String.class).invoke(service, id.replace("/", "-"));

		if (objByService != null) {

			System.out.println("CADASTRO REMOTO ENCONTRADO");

			System.out.println(obj);
			System.out.println(objByService);

			if (!util.compareObjects(obj, objByService)) {
				// atualizando service com dados do banco local
				this.setAtualProgress("Atualizando na API", obj.toString());
				System.out.println("ATUALIZANDO API REMOTA");
				service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
						id.replace("/", "-"));
			}

		} else {
			String idIntegracao = (String) service.getClass().getMethod("send", Object.class).invoke(service, obj);
			if (idIntegracao != null && !idIntegracao.isEmpty()) {
				this.setAtualProgress("Cadastro inicial na API", obj.toString());
				System.out.println("CADASTRO REMOTO INICIAL");
			} else {
				this.setAtualProgress("Cadastro inicial na API não realizado", obj.toString());
				System.out.println("CADASTRO REMOTO NÃO REALIZADO");
			}
			System.out.println(obj);
		}

	}

	// sincroniza croniza de acordo com o historico
	private void sincByChanges(List<T> objectList) throws Exception {

		int contErros = 0;
		this.posAtual = 0;

		//
		// CADASTRO E ATUALIZACAO
		//

		this.setInitalProgress(objectList.size());
		for (T obj : objectList) {
			this.posAtual++;
			try {
				sendToAPI(obj);
				contErros = 0;
			} catch (Exception e) {
				System.err.println(obj);

				Logger.sendLog(MainController.class, Logger.ERROR, e);

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}
			System.out.println("\n");
		}

		posAtualGeral++;
		this.setAtualProgress("Verificação Terminada: " + (this.getClass().getSimpleName()), null);
	}

	private void sincAllIgnoreChanges() throws Exception {

		int contErros = 0;
		this.posAtual = 0;

		//
		// CADASTRO E ATUALIZACAO
		//

		List<T> objectList = (List<T>) dao.getClass().getMethod("findAll").invoke(dao, null);
		this.setInitalProgress(objectList.size());
		for (T obj : objectList) {
			this.posAtual++;
			try {
				sendToAPI(obj);

				contErros = 0;
			} catch (Exception e) {
				System.err.println(obj);

				Logger.sendLog(MainController.class, Logger.ERROR, e);

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}
			System.out.println("\n");
		}

		posAtualGeral++;
		this.setAtualProgress("Verificação Terminada: " + (this.getClass().getSimpleName()), null);
	}

	public void sincAllIfNoEqual() throws Exception {

		int contErros = 0;
		this.posAtual = 0;

		//
		// CADASTRO E ATUALIZACAO
		//

		System.out.println("\nSINCRONIZANDO TIPOS DE SOLICITACAO");

		T[] objectList = (T[]) service.getClass().getMethod("getAll").invoke(service, null);

		this.setInitalProgress(objectList.length);
		for (T obj : objectList) {
			this.posAtual++;
			try {
				T fromBanco = (T) dao.getClass().getMethod("findById", Object.class).invoke(dao,
						obj.getClass().getMethod("getId").invoke(obj, null));

				System.out.println("\n" + fromBanco != null ? "TIPO ENCONTRADO" : "TIPO NAO ENCONTRADO");
				System.out.println(obj);
				System.out.println(fromBanco);

				if (fromBanco == null) {
					// cadastro
					System.out.println("CADASTRANDO TIPOS DE SOLICITACAO");
					dao.getClass().getMethod("save", Object.class).invoke(dao, obj);
				} else if (!(new Util().compareObjects(obj, fromBanco))) {
					// alteracao
					System.out.println("ATUALIZANDO TIPOS DE SOLICITACAO");
					dao.getClass().getMethod("update", Object.class).invoke(dao, fromBanco);
				}

				sendToAPI(obj);

				contErros = 0;
			} catch (Exception e) {
				System.err.println(obj);

				Logger.sendLog(MainController.class, Logger.ERROR, e);

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}
			System.out.println("\n");
		}

		posAtualGeral++;
		this.setAtualProgress("Verificação Terminada: " + (this.getClass().getSimpleName()), null);
	}

	private void setInitalProgress(Integer listSize) {
		this.posAtual = 0;
		this.total = listSize;
		setChanged();
		notifyObservers();
	}

	private void setAtualProgress(String acaoAtual, String objAtual) {
		this.acaoAtual = acaoAtual;
		this.objStrAtual = objAtual != null ? objAtual : "";
		setChanged();
		notifyObservers();
	}

	// public abstract void sinc() throws Exception;

	public static void startMainThreadSinc() {

		if (mainThread != null) {
			System.err.println("Thread ja em execução");
		} else {
			ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(false);

			totalGeral = 3;

			mainThread = new Thread() {

				SolicitacaoDeAlteracapService solicitacaoDeAlteracapService = new SolicitacaoDeAlteracapService();
				SolicitacaoDeAlteracaoDAO solicitacaoDeAlteracaoDAO = new SolicitacaoDeAlteracaoDAO();

				HistoricoDeSincronizacaoDAO historicoDeSincronizacaoDAO = new HistoricoDeSincronizacaoDAO();

				@Override
				public void run() {

					while (true) {
						try {
							System.out.println("\n---------------------------");
							System.out.println("\n------- INI SINC FROM API\n");

							///////////////////////////////////////
							/////////////////////////////////////// SINC SOLICITACOES
							///////////////////////////////////////

							SolicitacaoDeAlteracao[] solicitacaoDeAlteracaoAuxArray = solicitacaoDeAlteracapService
									.getAll();
							System.out
									.println(solicitacaoDeAlteracaoAuxArray.length + " novas solicitações encontradas");
							
							
							// sincronizando do remoto para local
							for (SolicitacaoDeAlteracao solicitacaoDeAlteracao : solicitacaoDeAlteracaoAuxArray) {
								// salvando localmente
								solicitacaoDeAlteracaoDAO.save(solicitacaoDeAlteracao);
								// setando como remotamente como sincronizado
								solicitacaoDeAlteracapService.setSinc(solicitacaoDeAlteracao.getId().toString());
							}

							List<SolicitacaoDeAlteracao> solicitacaoDeAlteracaoAuxList = solicitacaoDeAlteracaoDAO
									.findNotSinc();
							System.out.println(
									solicitacaoDeAlteracaoAuxArray.length + " alterações encontradas em solicitações");

							for (SolicitacaoDeAlteracao solicitacaoDeAlteracao : solicitacaoDeAlteracaoAuxList) {
								// sincronizando com API
								solicitacaoDeAlteracapService.setStatus(solicitacaoDeAlteracao);
								// setando como sincronizado
								solicitacaoDeAlteracaoDAO.setSincronizado(solicitacaoDeAlteracao);

							}

							///////////////////////////////////////
							/////////////////////////////////////// SINC POR HISTORICO
							///////////////////////////////////////

							System.out.println("\n------- INI SINC TO API\n");

							List<HistoricoDeSincronizacao> historicoDeSincronizacaoList = historicoDeSincronizacaoDAO
									.finlAllNoSinc();

							System.out.println(historicoDeSincronizacaoList.size() + " novos históricos encontrados");

							for (HistoricoDeSincronizacao historicoDeSincronizacao : historicoDeSincronizacaoList) {

								Object tabela = historicoDeSincronizacao.getTabela();

								System.out.println(tabela);

								if (daoMap.containsKey(tabela.toString())
										&& controllerMap.containsKey(tabela.toString())) {
									System.out.println("IF!");

									MainController controller = controllerMap.get(tabela.toString());
									controller.posAtualGeral++;

									List<Object> ids = Arrays.asList(historicoDeSincronizacaoList.stream()
											.filter(o -> o.getTabela().equals(tabela.toString()))
											.map(o -> o.getId_relacionado()).toArray());

									controller.addObserver(controleJFrame);

									controller.sincByChanges(daoMap.get(tabela.toString()).findByIdString(ids, null));

									// marcando como sincronizadas
									historicoDeSincronizacaoDAO.setSincronizado(historicoDeSincronizacao);

								}

							}

							// break;
							TimeUnit.SECONDS.sleep(5/* refreshTime */);

						} catch (Exception e) {
							e.printStackTrace();
							try {
								TimeUnit.SECONDS.sleep(60 * 5);// 5 minutos para tentar novamente
							} catch (InterruptedException interruptedException) {
								interruptedException.printStackTrace();
							}
						}
					}

				}

			};
			mainThread.start();
		}
	}

	// feita no inicio de tudo, quando a api nao apresenta dados
	public static void sincAll(boolean startMainThreadOnFinish) {

		ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(false);

		totalGeral = 11;

		new Thread() {

			@Override
			public void run() {
				try {

					MainController controller = new CorVeiculoController();
					controller.posAtualGeral = 0;
					controller.addObserver(controleJFrame);
					// controller.sincAllIgnoreChanges();

					controller = new MarcaModeloCarroceriaController();
					controller.posAtualGeral = 1;
					controller.addObserver(controleJFrame);
					// controller.sincAllIgnoreChanges();

					controller = new MarcaModeloChassiController();
					controller.posAtualGeral = 2;
					controller.addObserver(controleJFrame);
					// controller.sincAllIgnoreChanges();

					controller = new TipoCombustivelController();
					controller.posAtualGeral = 3;
					controller.addObserver(controleJFrame);
					// controller.sincAllIgnoreChanges();

					controller = new TipoVeiculoController();
					controller.posAtualGeral = 4;
					controller.addObserver(controleJFrame);
					// controller.sincAllIgnoreChanges();

					controller = new PermissionarioController();
					controller.posAtualGeral = 5;
					controller.addObserver(controleJFrame);
					controller.sincAllIgnoreChanges();

					controller = new CondutorAuxiliarController();
					controller.posAtualGeral = 6;
					controller.addObserver(controleJFrame);
					controller.sincAllIgnoreChanges();

					controller = new MarcaModeloVeiculoController();
					controller.posAtualGeral = 7;
					controller.addObserver(controleJFrame);
					// controller.sincAllIgnoreChanges();

					controller = new OnibusController();
					controller.posAtualGeral = 8;
					controller.addObserver(controleJFrame);
					// controller.sincAllIgnoreChanges();

					controller = new VeiculoController();
					controller.posAtualGeral = 9;
					controller.addObserver(controleJFrame);
					// controller.sincAllIgnoreChanges();

					controller = new TipoDeSolicitacaoDeAlteracaoController();
					controller.posAtualGeral = 10;
					controller.addObserver(controleJFrame);
					controller.sincAllIfNoEqual();

					if (startMainThreadOnFinish) {
						MainController.startMainThreadSinc();
					}

				} catch (Exception e) {
					System.out.println(e);
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}

			}
		}.start();

	}

}

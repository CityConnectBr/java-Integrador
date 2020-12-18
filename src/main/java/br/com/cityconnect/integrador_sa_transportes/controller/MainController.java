package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import br.com.cityconnect.integrador_sa_transportes.dao.MonitorDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.OnibusDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.SolicitacaoDeAlteracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TipoCombustivelDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TipoVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.VeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.entity.HistoricoDeSincronizacao;
import br.com.cityconnect.integrador_sa_transportes.entity.Monitor;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.entity.SolicitacaoDeAlteracao;
import br.com.cityconnect.integrador_sa_transportes.service.SolicitacaoDeAlteracapService;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;
import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;
import br.com.cityconnect.integrador_sa_transportes.util.SincProcessObservableUtil;
import br.com.cityconnect.integrador_sa_transportes.util.Util;
import br.com.cityconnect.integrador_sa_transportes.view.ControleJFrame;

public abstract class MainController<T extends Serializable, T_DAO, T_SERVICE> {

	private Util util = new Util();

	private T_DAO dao;
	private T_SERVICE service;

	private static Thread mainThread = null;

	private static Integer refreshTime = 60;// 3600;// uma hora

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

	private static Map<String, GenericDao> daoMap = new LinkedHashMap<String, GenericDao>() {
		{
//			put(HistoricoDeSincronizacaoDAO.AGENTES_FISCALIZACAO_TABLE, new AgenteFiscalizacaoDAO());
//			put(HistoricoDeSincronizacaoDAO.CORES_VEICULOS_TABLE, new CorVeiculoDAO());
//			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_CARROCERIAS_TABLE, new MarcaModeloCarroceriaDAO());
//			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_CHASSIS_TABLE, new MarcaModeloChassiDAO());
//			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_VEICULOS_TABLE, new MarcaModeloVeiculoDAO());
//			put(HistoricoDeSincronizacaoDAO.TIPOSVEICULOS_TABLE, new TipoVeiculoDAO());
//			put(HistoricoDeSincronizacaoDAO.TIPOSCOMBUSTIVEIS_TABLE, new TipoCombustivelDAO());
//			put(HistoricoDeSincronizacaoDAO.ONIBUS_TABLE, new OnibusDAO());
//			put(HistoricoDeSincronizacaoDAO.PERMISSIONARIOS_TABLE, new PermissionarioDAO());
			put(HistoricoDeSincronizacaoDAO.MONITORES_TABLE, new MonitorDAO());
//			put(HistoricoDeSincronizacaoDAO.CONDUTOR_TABLE, new CondutoreAuxiliareDAO());
//			put(HistoricoDeSincronizacaoDAO.VEICULOS_TABLE, new VeiculoDAO());
		}
	};

	private static Map<String, MainController> controllerMap = new LinkedHashMap<String, MainController>() {
		{
//			put(HistoricoDeSincronizacaoDAO.AGENTES_FISCALIZACAO_TABLE, new AgenteFiscalizacaoController());
//			put(HistoricoDeSincronizacaoDAO.CORES_VEICULOS_TABLE, new CorVeiculoController());
//			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_CARROCERIAS_TABLE, new MarcaModeloCarroceriaController());
//			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_CHASSIS_TABLE, new MarcaModeloChassiController());
//			put(HistoricoDeSincronizacaoDAO.MARCAS_MODELOS_VEICULOS_TABLE, new MarcaModeloVeiculoController());
//			put(HistoricoDeSincronizacaoDAO.TIPOSVEICULOS_TABLE, new TipoVeiculoController());
//			put(HistoricoDeSincronizacaoDAO.TIPOSCOMBUSTIVEIS_TABLE, new TipoCombustivelController());
//			put(HistoricoDeSincronizacaoDAO.ONIBUS_TABLE, new OnibusController());
//			put(HistoricoDeSincronizacaoDAO.PERMISSIONARIOS_TABLE, new PermissionarioController());
			put(HistoricoDeSincronizacaoDAO.MONITORES_TABLE, new MonitorController());
//			put(HistoricoDeSincronizacaoDAO.CONDUTOR_TABLE, new CondutorAuxiliarController());
//			put(HistoricoDeSincronizacaoDAO.VEICULOS_TABLE, new VeiculoController());
		}
	};

	public abstract void sincAll() throws Exception;

	///////////////////////////
	/////////////////////////// METODOS PRINCIPAIS
	///////////////////////////

	protected void sincAllIgnoreChanges() throws Exception {

		int contErros = 0;

		//
		// CADASTRO E ATUALIZACAO
		//
		System.out.println("\nSINCRONIZANDO: sincAllIgnoreChanges");

		List<T> objectList = (List<T>) dao.getClass().getMethod("findAll").invoke(dao, null);
		SincProcessObservableUtil.getSincProcessObservableUtil().startProcess(objectList.size(), null);
		for (T obj : objectList) {
			SincProcessObservableUtil.getSincProcessObservableUtil()
					.nextOfSubProcess("Sinc para API -> " + this.getClass().getSimpleName() + ": " + obj.toString());
			try {
				sendToAPI(obj);

				contErros = 0;
			} catch (Exception e) {
				SincProcessObservableUtil.getSincProcessObservableUtil().setStringInfo(e.toString());

				System.err.println(obj);

				Logger.sendLog(MainController.class, Logger.ERROR, e);

				SincProcessObservableUtil.getSincProcessObservableUtil().setStringInfo(e.getMessage());

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}
			System.out.println("\n");
		}

	}

	public void sincAllIfNoEqual() throws Exception {

		int contErros = 0;

		//
		// CADASTRO E ATUALIZACAO
		//

		System.out.println("\nSINCRONIZANDO: sincAllIfNoEqual");

		T[] objectList = (T[]) service.getClass().getMethod("getAll").invoke(service, null);

		SincProcessObservableUtil.getSincProcessObservableUtil().startProcess(objectList.length, null);
		for (T obj : objectList) {
			SincProcessObservableUtil.getSincProcessObservableUtil()
					.nextOfSubProcess(this.getClass().getSimpleName() + ": " + obj.toString());
			try {
				T fromBanco = (T) dao.getClass().getMethod("findById", Object.class).invoke(dao,
						obj.getClass().getMethod("getId").invoke(obj, null));

				System.out.println("\n" + fromBanco != null ? "ENCONTRADO" : "NAO ENCONTRADO");
				System.out.println(obj);
				System.out.println(fromBanco);

				if (fromBanco == null) {
					// cadastro
					SincProcessObservableUtil.getSincProcessObservableUtil().setStringInfo("CADASTRANDO...");
					System.out.println("CADASTRANDO");
					dao.getClass().getMethod("save", Object.class).invoke(dao, obj);
				} else if (!(new Util().compareObjects(obj, fromBanco))) {
					// alteracao
					SincProcessObservableUtil.getSincProcessObservableUtil().setStringInfo("CADASTRANDO...");
					System.out.println("ATUALIZANDO");
					dao.getClass().getMethod("update", Object.class).invoke(dao, fromBanco);
				}

				sendToAPI(obj);

				contErros = 0;
			} catch (Exception e) {

				SincProcessObservableUtil.getSincProcessObservableUtil().setStringInfo(e.toString());

				System.err.println(obj);

				Logger.sendLog(MainController.class, Logger.ERROR, e);

				SincProcessObservableUtil.getSincProcessObservableUtil().setStringInfo(e.getMessage());

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}

			System.out.println("\n");
		}

		// this.setAtualProgress("Verificação Terminada: " +
		// (this.getClass().getSimpleName()), null);
	}

	// public abstract void sinc() throws Exception;

	public static void startMainThreadSinc() {

		if (mainThread != null) {
			System.err.println("Thread ja em execução");
		} else {
			ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(true);

			mainThread = new Thread() {

				SolicitacaoDeAlteracapService solicitacaoDeAlteracapService = new SolicitacaoDeAlteracapService();
				SolicitacaoDeAlteracaoDAO solicitacaoDeAlteracaoDAO = new SolicitacaoDeAlteracaoDAO();

				HistoricoDeSincronizacaoDAO historicoDeSincronizacaoDAO = new HistoricoDeSincronizacaoDAO();

				@Override
				public void run() {

					while (true) {
						try {
							SincProcessObservableUtil sincProcessObservableUtil = SincProcessObservableUtil
									.newProcess(3, controleJFrame);

							sincProcessObservableUtil.addSeparator(SincProcessObservableUtil.SEPARATOR_20TRACES);
							System.out.println("\n---------------------------");
							System.out.println("\n------- INI SINC FROM API\n");

							///////////////////////////////////////
							/////////////////////////////////////// SINC SOLICITACOES
							///////////////////////////////////////

							// NOVOS REGISTROS DE SOLICITACOES DE ALTERACAO
							SolicitacaoDeAlteracao[] solicitacaoDeAlteracaoAuxArray = solicitacaoDeAlteracapService
									.getAll();
							System.out
									.println(solicitacaoDeAlteracaoAuxArray.length + " novas solicitações encontradas");
							sincProcessObservableUtil.startProcess(solicitacaoDeAlteracaoAuxArray.length,
									"Solicitações de Alteração(da API)");

							// sincronizando do remoto para local
							for (SolicitacaoDeAlteracao solicitacaoDeAlteracao : solicitacaoDeAlteracaoAuxArray) {
								sincProcessObservableUtil.addSeparator(SincProcessObservableUtil.SEPARATOR_ARROW);

								sincProcessObservableUtil.nextOfSubProcess(
										"Solicitação de Alteração (da API): " + solicitacaoDeAlteracao);

								// salvando localmente
								solicitacaoDeAlteracaoDAO.save(solicitacaoDeAlteracao);
								// setando como remotamente como sincronizado
								solicitacaoDeAlteracapService.setSinc(solicitacaoDeAlteracao.getId().toString());
							}

							// ALTERANAO NO REGISTRO DE SOLICACOES
							List<SolicitacaoDeAlteracao> solicitacaoDeAlteracaoAuxList = solicitacaoDeAlteracaoDAO
									.findNotSinc();
							System.out.println(
									solicitacaoDeAlteracaoAuxArray.length + " alterações encontradas em solicitações");
							sincProcessObservableUtil.startProcess(solicitacaoDeAlteracaoAuxList.size(),
									"Solicitações de Alteração(para API)");

							for (SolicitacaoDeAlteracao solicitacaoDeAlteracao : solicitacaoDeAlteracaoAuxList) {
								sincProcessObservableUtil.addSeparator(SincProcessObservableUtil.SEPARATOR_ARROW);

								sincProcessObservableUtil.nextOfSubProcess(
										"Solicitação de Alteração (para API): " + solicitacaoDeAlteracao);

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
							sincProcessObservableUtil.startProcess(historicoDeSincronizacaoList.size(),
									"Histórico de Alteração");

							for (HistoricoDeSincronizacao historicoDeSincronizacao : historicoDeSincronizacaoList) {
								sincProcessObservableUtil.addSeparator(SincProcessObservableUtil.SEPARATOR_ARROW);

								sincProcessObservableUtil.nextOfSubProcess(
										"Histórico de Sincronização / " + historicoDeSincronizacao.getTabela());

								Object tabela = historicoDeSincronizacao.getTabela();

								System.out.println(tabela);

								if (daoMap.containsKey(tabela.toString())
										&& controllerMap.containsKey(tabela.toString())) {
									System.out.println("IF!");

									MainController controller = controllerMap.get(tabela.toString());

									List<Object> ids = Arrays.asList(historicoDeSincronizacaoList.stream()
											.filter(o -> o.getTabela().equals(tabela.toString()))
											.map(o -> o.getId_relacionado()).toArray());

									controller.sincByChanges(daoMap.get(tabela.toString()).findByIdString(ids, null));

									// marcando como sincronizadas
									historicoDeSincronizacaoDAO.setSincronizado(historicoDeSincronizacao);

								}

							}

							sincProcessObservableUtil.endProcess();

							// break;
							TimeUnit.SECONDS.sleep(refreshTime);

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
	public static void sincAllMainThread(boolean startMainThreadOnFinish) {

		ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(true);

		SincProcessObservableUtil sincProcessObservableUtil = SincProcessObservableUtil.newProcess(controllerMap.size(),
				controleJFrame);

		new Thread() {

			@Override
			public void run() {
				try {

					for (MainController controller : controllerMap.values()) {
						controller.sincAll();
					}

					sincProcessObservableUtil.endProcess();

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

	///////////////////////////
	/////////////////////////// METODOS AUXILIARES
	///////////////////////////

	private void sendToAPI(T obj) throws Exception {

		//
		// CADASTRO E ATUALIZACAO
		//

		String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();

		T objByService = (T) service.getClass().getMethod("get", String.class).invoke(service, id.replace("/", "-"));

		if (objByService != null) {

			System.out.println("CADASTRO REMOTO ENCONTRADO");

			System.out.println(obj);
			System.out.println(objByService);

			if (!util.compareObjects(obj, objByService)) {
				// atualizando service com dados do banco local
				System.out.println("ATUALIZANDO API REMOTA");
				service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
						id.replace("/", "-"));

				// atualizando foto com a API
				this.sendPhoto(obj);
			}

		} else {
			String idIntegracao = (String) service.getClass().getMethod("send", Object.class).invoke(service, obj);
			if (idIntegracao != null && !idIntegracao.isEmpty()) {
				// atualizando foto com a API
				this.sendPhoto(obj);

				System.out.println("CADASTRO REMOTO INICIAL");
			} else {
				System.out.println("CADASTRO REMOTO NÃO REALIZADO");
			}
			System.out.println(obj);
		}

	}

	// sincroniza croniza de acordo com o historico
	private void sincByChanges(List<T> objectList) throws Exception {

		int contErros = 0;

		//
		// CADASTRO E ATUALIZACAO
		//

		for (T obj : objectList) {
			try {
				sendToAPI(obj);
				// atualizando foto com a API
				this.sendPhoto(obj);

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

	}

	private void sendPhoto(T obj) throws Exception {

		String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();

		// atualizando foto
		if (obj instanceof Permissionario || obj instanceof Monitor || obj instanceof CondutorAuxiliar) {
			Blob fotoBlob = (Blob) obj.getClass().getMethod("getFoto").invoke(obj, null);
			if (fotoBlob != null && fotoBlob.length() > 0) {
				System.out.println("ATUALIZANDO FOTO");

				service.getClass().getMethod("sendUpdatePhoto", InputStream.class, String.class).invoke(service,
						fotoBlob.getBinaryStream(), id.replace("/", "-"));
			}
		}
	}

}

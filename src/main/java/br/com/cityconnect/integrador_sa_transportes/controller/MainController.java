package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
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
	private static final Integer totalGeral = 10;

	private static Integer refreshTime = 3600;// uma hora

	MainController(T_SERVICE service, T_DAO dao) {
		this.service = service;
		this.dao = dao;
	}

	// sincroniza croniza sem vercionamento, sobreescreve o conteudo remoto
	protected void sincOnlyRemote() throws Exception {

		int contErros = 0;

		//
		// CADASTRO E ATUALIZACAO
		//
		List<T> objectList = (List<T>) dao.getClass().getMethod("findAll").invoke(dao, null);
		this.setInit(objectList.size());
		for (T obj : objectList) {
			this.posAtual++;
			try {
				this.setAtual("Verificando", obj.toString());

				String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();
				T objByService = (T) service.getClass().getMethod("get", String.class).invoke(service,
						id.replace("/", "-"));
				if (objByService != null) {

					System.out.println("CADASTRO REMOTO ENCONTRADO");

					System.out.println(obj);
					System.out.println(objByService);
					if (!util.compareObjects(obj, objByService)) {
						this.setAtual("Atualizando na API", obj.toString());

						// atualizando service com dados do banco local
						System.out.println("ATUALIZANDO API REMOTA");
						service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
								id.replace("/", "-"));
					}
				} else {
					this.setAtual("Cadastrando na API", obj.toString());

					String idIntegracao = (String) service.getClass().getMethod("send", Object.class).invoke(service,
							obj);
					if (idIntegracao != null && !idIntegracao.isEmpty()) {
						System.out.println("CADASTRO REMOTO INICIAL");
					} else {
						System.out.println("CADASTRO REMOTO NÃO REALIZADO");
					}
					System.out.println(obj);
				}

				contErros = 0;
			} catch (Exception e) {
				Logger.sendLog(MainController.class, Logger.ERROR, e);

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}
			System.out.println("\n");
		}

		//
		// DELECAO
		//

		for (T obj : (T[]) service.getClass().getMethod("getAll").invoke(service, null)) {
			try {
				String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();
				T objByDAO = (T) dao.getClass().getMethod("findById", String.class).invoke(dao, id);
				if (objByDAO == null) {
					this.setAtual("Deletando na API", obj.toString());
					System.out.println("DELETANDO CADASTRO REMOTO");
					System.out.println(obj);
					service.getClass().getMethod("sendDelete", String.class).invoke(service, id.replace("/", "-"));
					System.out.println("\n");
				}

				contErros = 0;
			} catch (Exception e) {
				Logger.sendLog(MainController.class, Logger.ERROR, e);

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}

		}

		posAtualGeral++;
		this.setAtual("Verificação Terminada: " + (this.getClass().getSimpleName()), null);
	}

	// sincroniza croniza o remoto e o local levando em consideracao a versao e
	// conteudo
	protected void sincFull() throws Exception {

		int contErros = 0;
		this.posAtual = 0;

		//
		// Cadastro Inicial(Objeto sem objetos adicionais(endereco e etc...)) Local
		//

		for (T obj : (T[]) service.getClass().getMethod("getAll").invoke(service, null)) {
			try {
				if (obj != null && obj.getClass().getMethod("getId").invoke(obj, null) == null) {
					this.setAtual("Cadastrando Local", obj.toString());
					System.out.println("CADASTRANDO LOCAL");
					System.out.println(obj);

					if (obj instanceof CondutorAuxiliar) {
						obj.getClass().getMethod("setId", String.class).invoke(obj,
								obj.getClass().getMethod("getCPF").invoke(obj, null));
					}
					System.out.println(obj);
					T newObj = (T) dao.getClass().getMethod("saveReturningEntity", obj.getClass()).invoke(dao, obj);
					service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
							newObj.getClass().getMethod("getId").invoke(newObj, null).toString().replace("/", "-"));
					System.out.println("\n");
				}

				contErros = 0;
			} catch (Exception e) {
				Logger.sendLog(MainController.class, Logger.ERROR, e);

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}

		}

		//
		// CADASTRO E ATUALIZACAO
		//

		List<T> objectList = (List<T>) dao.getClass().getMethod("findAll").invoke(dao, null);
		this.setInit(objectList.size());
		for (T obj : objectList) {
			this.posAtual++;
			try {
				this.setAtual("Verificando", obj.toString());

				String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();
				if (!id.equals("08643560804")) {// 08024153858
					// continue;
				}

				T objByService = (T) service.getClass().getMethod("get", String.class).invoke(service,
						id.replace("/", "-"));

				if (objByService != null) {

					System.out.println("CADASTRO REMOTO ENCONTRADO");

					System.out.println(obj);
					System.out.println(objByService);

					if (!util.compareObjects(obj, objByService)) {

						Integer versaoObj = Integer
								.valueOf(obj.getClass().getMethod("getVersao").invoke(obj, null).toString());
						Integer versaoObjByService = Integer.valueOf(
								objByService.getClass().getMethod("getVersao").invoke(objByService, null).toString());

						if (!versaoObj.equals(versaoObjByService)) {
							// atualizar banco local com dados do service
							this.setAtual("Atualizando no Banco Local", objByService.toString());
							System.out.println("ATUALIZANDO BANCO LOCAL");
							dao.getClass().getMethod("update", Object.class).invoke(dao, objByService);
						} else {
							// atualizando service com dados do banco local
							this.setAtual("Atualizando na API", obj.toString());
							System.out.println("ATUALIZANDO API REMOTA");
							service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
									id.replace("/", "-"));

							dao.getClass().getMethod("setVersao", Object.class, Integer.class).invoke(dao, id,
									versaoObj + 1);

						}
					}

//					if (!util.compareObjects(obj, objByService)) {
//						// atualizando service com dados do banco local
//						this.setAtual("Atualizando na API", obj.toString());
//						System.out.println("ATUALIZANDO API REMOTA");
//						service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
//								id.replace("/", "-"));
//					}
				} else {
					String idIntegracao = (String) service.getClass().getMethod("send", Object.class).invoke(service,
							obj);
					if (idIntegracao != null && !idIntegracao.isEmpty()) {
						this.setAtual("Cadastro inicial na API", obj.toString());
						System.out.println("CADASTRO REMOTO INICIAL");
					} else {
						this.setAtual("Cadastro inicial na API não realizado", obj.toString());
						System.out.println("CADASTRO REMOTO NÃO REALIZADO");
					}
					System.out.println(obj);
				}

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
		this.setAtual("Verificação Terminada: " + (this.getClass().getSimpleName()), null);
	}

	private void setInit(Integer listSize) {
		this.posAtual = 0;
		this.total = listSize;
		setChanged();
		notifyObservers();
	}

	private void setAtual(String acaoAtual, String objAtual) {
		this.acaoAtual = acaoAtual;
		this.objStrAtual = objAtual != null ? objAtual : "";
		setChanged();
		notifyObservers();
	}

	public abstract void sinc() throws Exception;

	public static void sincAll() {
		if (mainThread != null) {
			System.err.println("Thread ja em execução");
		} else {
			ControleJFrame controleJFrame = (ControleJFrame) ControleJFrame.newControleJFrame(false);

			mainThread = new Thread() {

				@Override
				public void run() {
					while (true) {
						try {
							while (true) {
								try {
									new PropertiesUtil().getValue(PropertiesUtil.KEY_REFRESH_TIME);
								} catch (IOException e) {
									refreshTime = 3600;// uma hora
									e.printStackTrace();
								}

								MainController controller = new CorVeiculoController();
								controller.posAtualGeral = 0;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new MarcaModeloCarroceriaController();
								controller.posAtualGeral = 1;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new MarcaModeloChassiController();
								controller.posAtualGeral = 2;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new TipoCombustivelController();
								controller.posAtualGeral = 3;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new TipoVeiculoController();
								controller.posAtualGeral = 4;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new PermissionarioController();
								controller.posAtualGeral = 5;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new CondutorAuxuliarController();
								controller.posAtualGeral = 6;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new MarcaModeloVeiculoController();
								controller.posAtualGeral = 7;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new OnibusController();
								controller.posAtualGeral = 8;
								controller.addObserver(controleJFrame);
								controller.sinc();

								controller = new VeiculoController();
								controller.posAtualGeral = 9;
								controller.addObserver(controleJFrame);
								controller.sinc();

								// break;
								TimeUnit.SECONDS.sleep(refreshTime);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						try {
							TimeUnit.SECONDS.sleep(60 * 5);// 5 minutos para tentar novamente
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
			};
			mainThread.start();
		}
	}

	public static void stopMainThread() {
		mainThread.interrupt();
		mainThread = null;
	}

	public static void restartMainThread() {
		stopMainThread();
		sincAll();
	}

}

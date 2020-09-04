package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.Serializable;
import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.util.Logger;
import br.com.cityconnect.integrador_sa_transportes.util.Util;

public abstract class MainController<T extends Serializable, T_DAO, T_SERVICE> {

	private Util util = new Util();

	private T_DAO dao;
	private T_SERVICE service;

	MainController(T_SERVICE service, T_DAO dao) {
		this.service = service;
		this.dao = dao;
	}

	protected void sincHalf() throws Exception {

		int contErros = 0;

		//
		// CADASTRO E ATUALIZACAO
		//
		for (T obj : (List<T>) dao.getClass().getMethod("findAll").invoke(dao, null)) {

			try {
				String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();
				T objByService = (T) service.getClass().getMethod("get", String.class).invoke(service,
						id.replace("/", "-"));
				if (objByService != null) {

					System.out.println("CADASTRO REMOTO ENCONTRADO");

					System.out.println(obj);
					System.out.println(objByService);
					if (!util.compareObjects(obj, objByService)) {
						// atualizando service com dados do banco local
						System.out.println("ATUALIZANDO API REMOTA");
						service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
								id.replace("/", "-"));
					}
				} else {
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

	}

	protected void sincFull() throws Exception {

		int contErros = 0;

		//
		// CADASTRO E ATUALIZACAO
		//
		for (T obj : (List<T>) dao.getClass().getMethod("findAll").invoke(dao, null)) {
			try {
				String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();
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
							System.out.println("ATUALIZANDO BANCO LOCAL");
							dao.getClass().getMethod("update", Object.class).invoke(dao, objByService);
						} else {
							// atualizando service com dados do banco local
							System.out.println("ATUALIZANDO API REMOTA");
							service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
									id.replace("/", "-"));

							dao.getClass().getMethod("setVersao", Long.class, Integer.class).invoke(dao, new Long(id),
									versaoObj + 1);

						}
					}

					if (!util.compareObjects(obj, objByService)) {
						// atualizando service com dados do banco local
						System.out.println("ATUALIZANDO API REMOTA");
						service.getClass().getMethod("sendUpdate", Object.class, String.class).invoke(service, obj,
								id.replace("/", "-"));
					}
				} else {
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

	}

	public abstract void sinc() throws Exception;

}

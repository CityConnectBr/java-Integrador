package br.com.cityconnect.integrador_sa_transportes.controller;

import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.service.PermissionarioService;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;
import br.com.cityconnect.integrador_sa_transportes.util.Util;

public class PermissionarioController {

	private Util util = new Util();

	public void sincronizar() throws Exception {
		PermissionarioDAO permissionarioDAO = new PermissionarioDAO();
		PermissionarioService permissionarioService = new PermissionarioService();

		int contErros = 0;

		for (Permissionario permissionario : permissionarioDAO.findAll()) {

			try {
				if (permissionario.getIdIntegracao() != null) {
					Permissionario permissionarioByService = permissionarioService
							.get(Integer.valueOf(permissionario.getIdIntegracao().toString()));

					if (permissionarioByService == null) {
						throw new Exception("Permissionário cadastrado não encontrado!");
					}

					System.out.println("CADASTRO REMOTO ENCONTRADO");

					System.out.println(permissionario);
					System.out.println(permissionarioByService);

					if (!util.compareObjects(permissionario, permissionarioByService)) {
						//erro aqui
						if (!permissionario.getVersao().equals(permissionarioByService.getVersao())) {
							// atualizar banco local com dados do service
							System.out.println("ATUALIZANDO BANCO LOCAL");
							permissionarioDAO.update(permissionarioByService);
						} else {
							// atualizando service com dados do banco local
							System.out.println("ATUALIZANDO API REMOTA");
							permissionarioService.sendUpdate(permissionario);
							permissionarioDAO.setVersao(permissionario.getId(),
									permissionarioByService.getVersao() + 1);
						}
					}
				} else {
					String idIntegracao = permissionarioService.send(permissionario);
					if (idIntegracao != null && !idIntegracao.isEmpty()) {
						System.out.println("CADASTRO REMOTO INICIAL");
						permissionarioDAO.setIdIntegracao(permissionario.getId(), new Long(idIntegracao));
					} else {
						System.out.println("CADASTRO REMOTO NÃO REALIZADO");
					}
					System.out.println(permissionario);
				}

				contErros = 0;
			} catch (Exception e) {
				System.err.println(e);
				Logger.sendLog(PermissionarioController.class, Logger.ERROR, e);

				contErros++;
				if (contErros > 3) {
					throw e;
				}
			}
			System.out.println("\n");
			break;
		}

	}

}

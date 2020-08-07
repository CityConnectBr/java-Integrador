package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.util.Util;

public class PermissionarioDAO extends GenericDao<Permissionario, Long> {

	public PermissionarioDAO() {
		super();
	}

	public List<Permissionario> findAll() {
		return super.findAll();
	}

	public boolean update(Permissionario permissionario) {
		return super.update((Permissionario) new Util().copy(permissionario, findById(permissionario.getId())));
	}

	public boolean setVersao(Long id, Integer versao) {
		Permissionario permissionario = findById(id);

		permissionario.setVersao(versao);

		return super.update(permissionario);
	}

	public boolean setIdIntegracao(Long id, Long idIntegracao) {
		Permissionario permissionario = findById(id);

		permissionario.setIdIntegracao(idIntegracao);

		return super.update(permissionario);
	}

}

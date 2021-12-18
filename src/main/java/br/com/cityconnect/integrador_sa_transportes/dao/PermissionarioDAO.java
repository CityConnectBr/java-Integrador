package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class PermissionarioDAO extends GenericDao<Permissionario, Long> {

	public PermissionarioDAO() {
		super();
	}

	public List<Permissionario> findAll() {
		return super.findAll();
	}

	/*public boolean update(Permissionario permissionario) {
		return super.update((Permissionario) new Util().copy(permissionario, findById(permissionario.getId())));
	}*/

}

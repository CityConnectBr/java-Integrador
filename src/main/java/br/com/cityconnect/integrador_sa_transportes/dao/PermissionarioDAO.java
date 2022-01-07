package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class PermissionarioDAO extends GenericDao<Permissionario, Long> {

	public PermissionarioDAO() {
		super();
	}

	public List<Permissionario> findAll() {
		return super.findAll();

/*		List<Permissionario> lista = new ArrayList<Permissionario>();
		lista.add(super.findById(new Long("")));
		return lista;*/
	}

	/*public boolean update(Permissionario permissionario) {
		return super.update((Permissionario) new Util().copy(permissionario, findById(permissionario.getId())));
	}*/

}

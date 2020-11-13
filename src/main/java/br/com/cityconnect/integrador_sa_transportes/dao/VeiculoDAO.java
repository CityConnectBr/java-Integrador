package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Veiculo;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;

public class VeiculoDAO extends GenericDao<Veiculo, Long> {

	public VeiculoDAO() {
		super();
	}

	public Veiculo saveReturningEntity(Veiculo entity) {
		return super.saveReturningEntity(entity);
	}

	@Override
	public List<Veiculo> findAll() {
		try {

			List<Veiculo> listResult = (List<Veiculo>) super.executeQuery(
					"from Veiculo v where (select count(*) from Permissionario p where p.id = v.permissionarioId) > 0");

			if (listResult != null && listResult.size() > 0) {
				return listResult;
			} else {
				return new ArrayList<>();
			}

		} catch (Exception e) {
			Logger.sendLog(VeiculoDAO.class, Logger.ERROR, e);
			return new ArrayList<>();
		}
	}

}

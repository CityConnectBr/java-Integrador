package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;

public class CondutoreAuxiliareDAO extends GenericDao<CondutorAuxiliar, Long> {

	public CondutoreAuxiliareDAO() {
		super();
	}
	
	@Override
	public List<CondutorAuxiliar> findAll() {
		try {

			List<CondutorAuxiliar> listResult = (List<CondutorAuxiliar>) super.executeQuery(
					"from CondutorAuxiliar v where (select count(*) from Permissionario p where p.id = v.permissionarioId) > 0");

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
	
	public CondutorAuxiliar saveReturningEntity(CondutorAuxiliar entity)  {
    	return super.saveReturningEntity(entity);
    }

}

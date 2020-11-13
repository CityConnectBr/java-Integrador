package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Onibus;

public class OnibusDAO extends GenericDao<Onibus, Long> {

	public OnibusDAO() {
		super();
	}

	@Override
	public List<Onibus> findAll() {
		return super.findAll();
	}
	
//	@Override
//	public List<Onibus> findAll() {
//		try {
//
//			List<Onibus> listResult = (List<Onibus>) super.executeQuery(
//					"from Onibus v where (select count(*) from Permissionario p where p.id = v.permissionarioId) > 0");
//
//			if (listResult != null && listResult.size() > 0) {
//				return listResult;
//			} else {
//				return new ArrayList<>();
//			}
//
//		} catch (Exception e) {
//			Logger.sendLog(VeiculoDAO.class, Logger.ERROR, e);
//			return new ArrayList<>();
//		}
//	}

	public Onibus saveReturningEntity(Onibus entity) {
		return super.saveReturningEntity(entity);
	}

}

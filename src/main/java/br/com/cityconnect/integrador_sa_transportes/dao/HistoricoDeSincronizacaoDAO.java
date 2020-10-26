package br.com.cityconnect.integrador_sa_transportes.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.HistoricoDeSincronizacao;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;

public class HistoricoDeSincronizacaoDAO extends GenericDao<HistoricoDeSincronizacao, Long> {

	public static final String CONDUTOR_TABLE = "condutoresauxiliares";
	public static final String AGENTES_FISCALIZACAO_TABLE = "agentesfiscalizacao";
	public static final String CORES_VEICULOS_TABLE = "coresveiculos";
	public static final String MARCAS_MODELOS_CARROCERIAS_TABLE = "marcasmodeloscarrocerias";
	public static final String MARCAS_MODELOS_CHASSIS_TABLE = "marcasmodeloschassis";
	public static final String MARCAS_MODELOS_VEICULOS_TABLE = "marcasmodelosveiculos";
	public static final String MONITORES_TABLE = "monitores";
	public static final String PERMISSIONARIOS_TABLE = "permissionarios";
	public static final String TIPOSCOMBUSTIVEIS_TABLE = "tiposcombustiveis";
	public static final String TIPOSVEICULOS_TABLE = "tiposveiculos";
	public static final String ONIBUS_TABLE = "onibus";
	public static final String VEICULOS_TABLE = "veiculos";

	public HistoricoDeSincronizacaoDAO() {
		super();
	}

	public List<HistoricoDeSincronizacao> finlAllNoSinc() {
		try {

			List<HistoricoDeSincronizacao> listResult = (List<HistoricoDeSincronizacao>) super.executeQuery(
					"from HistoricoDeSincronizacao where sincronizado = false order by dataHoraCreatedAt ");

			return listResult;

		} catch (Exception e) {
			Logger.sendLog(this.getClass(), Logger.ERROR, e);
			return new ArrayList();
		}
	}

}

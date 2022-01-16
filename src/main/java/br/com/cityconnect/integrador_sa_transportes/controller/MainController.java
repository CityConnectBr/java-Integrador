package br.com.cityconnect.integrador_sa_transportes.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import br.com.cityconnect.integrador_sa_transportes.dao.AgenteFiscalizacaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.CertidaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.CondutoreAuxiliareDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.CoordenadorDePontoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.CorVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.CursoDoCondutorDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.CursoDoPermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.EmpresaDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.EmpresaVistoriadoraDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.EntidadeAssociativaDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.EntidadeCursoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.FMPDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.GenericDao;
import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloCarroceriaDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloChassiDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.MarcaModeloVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.MonitorDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.MunicipioDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.ObservacaoPermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.OnibusDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.PermissionarioDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.PontoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.QuadrodeInfracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TalaoDoFiscalDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TipoCombustivelDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TipoDeCursoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.TipoVeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.ValoresDaInfracaoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.VeiculoDAO;
import br.com.cityconnect.integrador_sa_transportes.dao.VistoriadorDAO;
import br.com.cityconnect.integrador_sa_transportes.entity.CondutorAuxiliar;
import br.com.cityconnect.integrador_sa_transportes.entity.Monitor;
import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;
import br.com.cityconnect.integrador_sa_transportes.util.Logger;
import br.com.cityconnect.integrador_sa_transportes.util.PropertiesUtil;
import br.com.cityconnect.integrador_sa_transportes.util.Util;

public abstract class MainController<T extends Serializable, T_DAO, T_SERVICE> {

	static int threadsRunning = 0;

	private Util util = new Util();

	private T_DAO dao;
	private T_SERVICE service;

	private static List<String> errors = new ArrayList<String>();

	private static Thread mainThread = null;

	private static Integer refreshTime = 60;// 3600;// uma hora

	public MainController(T_SERVICE service, T_DAO dao) throws NumberFormatException {
		this.service = service;
		this.dao = dao;
		try {
			this.refreshTime = new Integer(new PropertiesUtil().getValue(PropertiesUtil.KEY_REFRESH_TIME));
		} catch (Exception e) {
			this.refreshTime = 3600;
		}
	}

	private MainController() {
	}

	private static Map<String, GenericDao> daoMap = new LinkedHashMap<String, GenericDao>() {
		{
			/*put(CorVeiculoDAO.class.toString(), new CorVeiculoDAO());
			put(EmpresaDAO.class.toString(), new EmpresaDAO());
			put(MarcaModeloCarroceriaDAO.class.toString(), new MarcaModeloCarroceriaDAO());
			put(MarcaModeloChassiDAO.class.toString(), new MarcaModeloChassiDAO());
			put(MarcaModeloVeiculoDAO.class.toString(), new MarcaModeloVeiculoDAO());
			put(MunicipioDAO.class.toString(), new MunicipioDAO());
			put(PontoDAO.class.toString(), new PontoDAO());
			put(QuadrodeInfracaoDAO.class.toString(), new QuadrodeInfracaoDAO());
			put(TipoCombustivelDAO.class.toString(), new TipoCombustivelDAO());
			put(TipoDeCursoDAO.class.toString(), new TipoDeCursoDAO());
			put(TipoVeiculoDAO.class.toString(), new TipoVeiculoDAO());
			put(ValoresDaInfracaoDAO.class.toString(), new ValoresDaInfracaoDAO());
			put(EmpresaVistoriadoraDAO.class.toString(), new EmpresaVistoriadoraDAO());
			put(EntidadeCursoDAO.class.toString(), new EntidadeCursoDAO());
			put(FMPDAO.class.toString(), new FMPDAO());
			put(VistoriadorDAO.class.toString(), new VistoriadorDAO());
			put(AgenteFiscalizacaoDAO.class.toString(), new AgenteFiscalizacaoDAO());
			put(TalaoDoFiscalDAO.class.toString(), new TalaoDoFiscalDAO());
			put(PermissionarioDAO.class.toString(), new PermissionarioDAO());
			put(ObservacaoPermissionarioDAO.class.toString(), new ObservacaoPermissionarioDAO());
			put(CursoDoPermissionarioDAO.class.toString(), new CursoDoPermissionarioDAO());
			put(CondutoreAuxiliareDAO.class.toString(), new CondutoreAuxiliareDAO());
			put(CursoDoCondutorDAO.class.toString(), new CursoDoCondutorDAO());
			put(MonitorDAO.class.toString(), new MonitorDAO());*/
			put(VeiculoDAO.class.toString(), new VeiculoDAO());
			/*put(CertidaoDAO.class.toString(), new CertidaoDAO());
			put(CoordenadorDePontoDAO.class.toString(), new CoordenadorDePontoDAO());
			put(OnibusDAO.class.toString(), new OnibusDAO());*/
		}
	};

	private static Map<String, MainController> controllerMap = new LinkedHashMap<String, MainController>() {
		{
			/*put(CorVeiculoController.class.toString(), new CorVeiculoController());
			put(EmpresaController.class.toString(), new EmpresaController());
			put(MarcaModeloCarroceriaController.class.toString(), new MarcaModeloCarroceriaController());
			put(MarcaModeloChassiController.class.toString(), new MarcaModeloChassiController());
			put(MarcaModeloVeiculoController.class.toString(), new MarcaModeloVeiculoController());
			put(MunicipioController.class.toString(), new MunicipioController());
			put(PontoController.class.toString(), new PontoController());
			put(QuadroDeInfracaoController.class.toString(), new QuadroDeInfracaoController());
			put(TipoCombustivelController.class.toString(), new TipoCombustivelController());
			put(TipoDeCursoController.class.toString(), new TipoDeCursoController());
			put(TipoVeiculoController.class.toString(), new TipoVeiculoController());
			put(ValoresDainfracaoController.class.toString(), new ValoresDainfracaoController());
			put(EmpresaVistoriadoraController.class.toString(), new EmpresaVistoriadoraController());
			put(EntidadeCursoController.class.toString(), new EntidadeCursoController());
			put(FMPController.class.toString(), new FMPController());
			put(VistoriadorController.class.toString(), new VistoriadorController());
			put(AgenteFiscalizacaoController.class.toString(), new AgenteFiscalizacaoController());
			put(TalaoDoFiscalController.class.toString(), new TalaoDoFiscalController());
			put(PermissionarioController.class.toString(), new PermissionarioController());
			put(ObservacaoPermissionarioController.class.toString(), new ObservacaoPermissionarioController());
			put(CursoDoPermissionarioController.class.toString(), new CursoDoPermissionarioController());
			put(CondutorAuxiliarController.class.toString(), new CondutorAuxiliarController());
			put(CursoDoCondutorController.class.toString(), new CursoDoCondutorController());
			put(MonitorController.class.toString(), new MonitorController());*/
			put(VeiculoController.class.toString(), new VeiculoController());
			/*put(CertidaoController.class.toString(), new CertidaoController());
			put(CoordenadorDePontoController.class.toString(), new CoordenadorDePontoController());
			put(OnibusController.class.toString(), new OnibusController());*/
		}
	};

	public abstract void sincAll() throws Exception;

	///////////////////////////
	/////////////////////////// METODOS PRINCIPAIS
	///////////////////////////

	public void sincAllIgnoreChanges() throws Exception {

		int contErros = 0;
		final int maxThreads = 1;
		int totalProcessed = 0;

		//
		// CADASTRO E ATUALIZACAO
		//
		System.out.println("\nSINCRONIZANDO: sincAllIgnoreChanges");

		List<T> objectList = (List<T>) dao.getClass().getMethod("findAll").invoke(dao, null);
		for (T obj : objectList) {
			System.out.println("Processed: "+totalProcessed+"/"+objectList.size());
			System.out.println(">>>"+threadsRunning+"/"+maxThreads);
			boolean processed = false;
			while (!processed) {
				//System.out.println(">>>"+threadsRunning+"/"+maxThreads);
				if (threadsRunning < maxThreads) {
					threadsRunning++;
					new Thread(new Runnable() {
						@Override
						public void run() {
							try {

								// chamando metodo de preparo quando existir
								try {
									obj.getClass().getMethod("prepare").invoke(obj);
								} catch (Exception e) {
								}

								sendToAPI(obj);
							} catch (Exception e) {
								errors.add(obj.toString() + ">>>>>" + e.getCause());
								System.err.println(obj);

								Logger.sendLog(MainController.class, Logger.ERROR, e);
							}finally {
								threadsRunning--;
							}
						}
					}).start();
					processed = true;
				}
				Thread.sleep(50);
			}
			totalProcessed++;
			System.out.println("\n");
		}
		
		//aguardando todos os processos terminarem
		while (threadsRunning!=0) {
			System.out.println("awating >>>"+threadsRunning+"/"+maxThreads);
			Thread.sleep(50);
		}

	}

	public static void sincAllMainThread() {

		try {
			//
			for (MainController controller : controllerMap.values()) {
				controller.sincAllIgnoreChanges();
			}
			
			// imprimindo erros
			if(errors.size()>0) {
				File f  = new File("/Users/elongomesvieira/Aux/City Connect/SA_TRANS/logerrors.txt");
				
				if(f.exists()) {
					f.deleteOnExit();
				}
				
				f.createNewFile();
			    FileWriter fw = new FileWriter(f);
			    PrintWriter pw = new PrintWriter(fw);

				for (String error : errors) {
					pw.printf(error+"\n");

					System.out.println(">>>" + error);
				}
				pw.close();
			}

		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

	}

	///////////////////////////
	/////////////////////////// METODOS AUXILIARES
	///////////////////////////

	private void sendToAPI(T obj) throws Exception {

		String idIntegracao = (String) service.getClass().getMethod("send", Object.class).invoke(service, obj);
		if (idIntegracao != null && !idIntegracao.isEmpty()) {
			// atualizando foto com a API
			this.sendPhoto(obj);

			System.out.println("CADASTRO REMOTO INICIAL");
		} else {
			System.out.println("CADASTRO REMOTO NÃO REALIZADO");
		}
		System.out.println(obj);

	}

	private void sendPhoto(T obj) throws Exception {

		// atualizando foto
		if (obj instanceof Permissionario || obj instanceof Monitor || obj instanceof CondutorAuxiliar) {
			String id = obj.getClass().getMethod("getId").invoke(obj, null).toString();

			Blob fotoBlob = (Blob) obj.getClass().getMethod("getFoto").invoke(obj, null);
			if (fotoBlob != null && fotoBlob.length() > 0) {
				System.out.println("ATUALIZANDO FOTO");

				service.getClass().getMethod("sendUpdatePhoto", InputStream.class, String.class).invoke(service,
						fotoBlob.getBinaryStream(), id.replace("/", "-"));
			}
		}
	}

}

package br.com.cityconnect.integrador_sa_transportes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class PermissionarioDAO {
	
	public List<Permissionario> getAll() throws SQLException {
		List<Permissionario> motoristaList = new ArrayList<>();
		
		Connection conn = ConnectionFactory.createConnection();
        
		String sql = "SELECT * FROM permissionarios;";
		PreparedStatement ps = conn.prepareStatement(sql);
		 
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			Permissionario m = new Permissionario();
			m.setId(new Long(rs.getString("NumeroCadastro")));
			m.setNome(rs.getString("nome"));
			m.setTipo(rs.getString("Pessoa"));
			m.setCNPJ(rs.getString("CNPJ"));
			m.setRG(rs.getString("RG"));
			m.setInscricaoMunicipal(rs.getString("InscricaoMunicipal"));
			m.setCEP(rs.getString("CEP"));
			m.setEndereco(rs.getString("Endereco"));
			m.setNumero(rs.getString("Numero"));
			m.setComplemento(rs.getString("Complemento"));
			m.setBairro(rs.getString("Bairro"));
			m.setMunicipio(rs.getString("Municipio"));
			m.setUF(rs.getString("UF"));
			m.setDDD(rs.getString("DDD"));
			m.setTelefone(rs.getString("Telefone"));
			m.setCelular(rs.getString("Celular"));
			m.setTelefone2(rs.getString("Recados"));
			m.setEmail(rs.getString("Email"));
			m.setModalidadeTransporte(rs.getString("ModalidadeTransporte"));
			m.setDataNascimento(rs.getString("DataNascimento"));
			m.setNaturalidade(rs.getString("Naturalidade"));
			m.setNacionalidade(rs.getString("Nacionalidade"));
			m.setCNH(rs.getString("CNH"));
			m.setCategoriaCNH(rs.getString("CategoriaCNH"));
			m.setVencimentoCNH(rs.getString("VencimentoCNH"));
			
			motoristaList.add(m);
		}
		
		return motoristaList;
	}

}

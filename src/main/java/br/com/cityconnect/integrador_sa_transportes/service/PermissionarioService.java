package br.com.cityconnect.integrador_sa_transportes.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.cityconnect.integrador_sa_transportes.entity.Permissionario;

public class PermissionarioService extends ServiceMain {

	private final String url = super.urlBase + "/integracao/permissionarios";

	private RestTemplate restTemplate = new RestTemplate();

	public String send(Permissionario permicionario) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		StringBuilder permissionarioJson = new StringBuilder();
		permissionarioJson.append("{");
		permissionarioJson.append(toJsonField("id_permissionario_integracao", permicionario.getId()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("nome", permicionario.getNome()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("tipo", permicionario.getTipo()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("CNPJ", permicionario.getCNPJ()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("RG", permicionario.getRG()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("inscricao_municipal", permicionario.getInscricaoMunicipal()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("CEP", permicionario.getCEP()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("endereco", permicionario.getEndereco()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("numero", permicionario.getNumero()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("complemento", permicionario.getComplemento()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("bairro", permicionario.getBairro()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("municipio", permicionario.getMunicipio()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("UF", permicionario.getUF()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("DDD", permicionario.getDDD()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("telefone", permicionario.getTelefone()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("celular", permicionario.getCelular()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("telefone2", permicionario.getTelefone2()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("email", permicionario.getEmail()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("modalidade_transporte", permicionario.getModalidadeTransporte()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("data_nascimento", permicionario.getDataNascimento()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("naturalidade", permicionario.getNaturalidade()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("nacionalidade", permicionario.getNaturalidade()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("CNH", permicionario.getCNH()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("categoria_CNH", permicionario.getCategoriaCNH()));
		permissionarioJson.append(",");
		permissionarioJson.append(toJsonField("vencimento_CNH", permicionario.getVencimentoCNH()));
		permissionarioJson.append("}");	
		
		System.out.println(permissionarioJson);
		
		HttpEntity<String> entity = new HttpEntity<String>(permissionarioJson.toString(), headers);

		return restTemplate.postForObject(url, entity, String.class);
	}

}

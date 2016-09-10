package br.com.loja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="clienteID")
@Table(name="db_pessoaJuridica")
public class PessoaJuridica extends Cliente {
	
	@Column(length = 50, nullable = false, unique = true)
	private String nomeFantasia;
	
	@Column(length = 18, nullable = false, unique = true)
	private String cnpj;

	   
	//GET E SET
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}

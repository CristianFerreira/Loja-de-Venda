package br.com.loja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="clienteID")
@Table(name="db_pessoaJuridica")
@NamedQueries({ @NamedQuery(name = "PessoaJuridica.listar", query = "SELECT pessoaJuridica FROM PessoaJuridica pessoaJuridica"),
@NamedQuery(name="PessoaJuridica.buscarPorCNPJ", query = "SELECT pessoaJuridica FROM PessoaJuridica pessoaJuridica"
		+ " WHERE pessoaJuridica.cnpj = :cnpj")
		})

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

	@Override
	public String toString() {
		return "PessoaJuridica [nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", getCodigo()=" + getCodigo()
				+ ", getNome()=" + getNome() + ", getTelefone()=" + getTelefone() + ", getRua()=" + getRua()
				+ ", getNumero()=" + getNumero() + ", getBairro()=" + getBairro() + ", getCep()=" + getCep()
				+ ", getEstado()=" + getEstado() + ", getDescricao()=" + getDescricao() + ", getTipo()=" + getTipo()
				+  "]";
	}
	

	
}

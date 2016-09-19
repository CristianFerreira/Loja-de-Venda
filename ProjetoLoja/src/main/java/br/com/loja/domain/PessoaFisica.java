package br.com.loja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@PrimaryKeyJoinColumn(name="clienteID")
@Table(name="db_pessoaFisica")
@NamedQueries({ @NamedQuery(name = "PessoaFisica.listar", query = "SELECT pessoaFisica FROM PessoaFisica pessoaFisica"),
@NamedQuery(name="PessoaFisica.buscarPorCPF", query = "SELECT pessoaFisica FROM PessoaFisica pessoaFisica"
		+ " WHERE pessoaFisica.cpf = :cpf")
		})
public class PessoaFisica extends Cliente {
	
	@CPF(message = "CPF informado é inválido")
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "PessoaFisica [cpf=" + cpf + ", getCodigo()=" + getCodigo() + ", getNome()=" + getNome()
				+ ", getTelefone()=" + getTelefone() + ", getRua()=" + getRua() + ", getNumero()=" + getNumero()
				+ ", getBairro()=" + getBairro() + ", getCep()=" + getCep() + ", getEstado()=" + getEstado()
				+ ", getDescricao()=" + getDescricao() + ", getTipo()=" + getTipo() + "]";
	}

	
	
	
}

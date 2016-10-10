package br.com.loja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@PrimaryKeyJoinColumn(name="clienteID")
@Table(name="db_pessoaFisica")
@NamedQueries({ @NamedQuery(name = "PessoaFisica.listar", query = "SELECT pessoaFisica FROM PessoaFisica pessoaFisica"),
@NamedQuery(name="PessoaFisica.buscarPorCPF", query = "SELECT pessoaFisica FROM PessoaFisica pessoaFisica"
		+ " WHERE pessoaFisica.cpf = :cpf"),
@NamedQuery(name = "PessoaFisica.buscarPorCodigo", query = "SELECT pessoaFisica FROM PessoaFisica pessoaFisica"
		+ " WHERE pessoaFisica.codigo = :codigo")
		})
public class PessoaFisica extends Cliente {
	
	@NotEmpty(message = "O campo CPF é obrigatório")
	@CPF(message = "CPF informado é inválido")
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

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

package br.com.loja.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "db_funcionario")
@NamedQueries({ 
	@NamedQuery(name = "Funcionario.listar", query = "SELECT funcionario FROM Funcionario funcionario"),
	@NamedQuery(name="Funcionario.buscarPorCodigo", query = "SELECT funcionario FROM Funcionario funcionario"
		+ " WHERE funcionario.codigo = :codigo") })
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // AutoIncremento
	@Column(name = "funcionarioID")
	private Long codigo;

	@NotEmpty(message = "O campo nome é obrigatório")
	@Size(min = 3, max = 50, message = "O campo nome deve obter entre 3 a 50 caracteres")
	@Column(length = 50, nullable = false)
	private String nome;

	@CPF(message = "CPF informado é inválido")
	@Column(length = 14, nullable = false, unique = true)
	private String cpf;

	@Size(min = 5, max = 50, message = "O campo senha deve obter entre 6 a 8 caracteres")
	@Column(length = 32, nullable = false)
	private String senha;

	@Column(length = 14)
	private String telefone;
	
	@NotEmpty(message = "O campo função é obrigatório")
	@Column(length = 50, nullable = false)
	private String tipo;

	
	//GET E SET
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", telefone="
				+ telefone + ", tipo=" + tipo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
}

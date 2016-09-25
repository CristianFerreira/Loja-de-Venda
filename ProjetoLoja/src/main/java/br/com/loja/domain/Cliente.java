package br.com.loja.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "db_cliente")
@NamedQueries({ @NamedQuery(name = "Cliente.listar", query = "SELECT cliente FROM Cliente cliente"),
		@NamedQuery(name = "Cliente.buscarPorCodigo", query = "SELECT cliente FROM Cliente cliente"
				+ " WHERE cliente.codigo = :codigo")})

public class Cliente implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "clienteID")
	private Long codigo;

	@NotEmpty(message = "O campo nome é obrigatório")
	@Size(min = 3, max = 50, message = "O campo nome deve obter entre 3 a 50 caracteres")
	@Column(length = 45, nullable = false)
	private String nome;

	@Column(length = 14, nullable = false)
	private String telefone;

	@NotEmpty(message = "O campo rua é obrigatório")
	@Size(max = 50, message = "O campo rua deve obter no máximo 50 caracteres")
	@Column(length = 50, nullable = false)
	private String rua;

	@NotEmpty(message = "O numero é obrigatório")
	@Size(max = 10, message = "O campo numero deve obter no máximo 10 caracteres")
	@Column(length = 10, nullable = false)
	private String numero;

	@NotEmpty(message = "O campo bairro é obrigatório")
	@Size(max = 50, message = "O campo bairro deve obter no máximo 50 caracteres")
	@Column(length = 50, nullable = false)
	private String bairro;

	@NotEmpty(message = "O campo CEP é obrigatório")
	@Size(min = 9, max = 9, message = "CEP inválido")
	@Column(length = 20, nullable = false)
	private String cep;

	@NotEmpty(message = "O campo estado é obrigatório")
	@Size(max = 50, message = "O campo estado deve obter no máximo 50 caracteres")
	@Column(length = 50, nullable = false)
	private String estado;

	@Size(max = 50, message = "O campo observação deve obter no máximo 50 caracteres")
	@Column(length = 50)
	private String descricao;

	@Column(length = 50, nullable = false)
	private String tipo;

	// GET E SET
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", rua=" + rua + ", numero="
				+ numero + ", bairro=" + bairro + ", cep=" + cep + ", estado=" + estado + ", descricao=" + descricao
				+ ", tipo=" + tipo + "]";
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

package br.com.loja.domain;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="db_venda")

@NamedQueries({ 
	@NamedQuery(name = "Venda.listar", query = "SELECT venda FROM Venda venda"),
	@NamedQuery(name="Venda.buscarPorCodigo", query = "SELECT venda FROM Venda venda"
		+ " WHERE venda.codigo = :codigo") })
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="vendaID")
	private Long codigo;
	
	@Column(nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date data;
	
	@Column(name="valor_total",precision = 7, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "db_funcionario_funcionarioID", referencedColumnName = "funcionarioID", nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "db_cliente_clienteID", referencedColumnName = "clienteID", nullable = false)
	private Cliente cliente;
	
	//GET E SET

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Venda [codigo=" + codigo + ", data=" + data + ", valor=" + valor + ", funcionario=" + funcionario
				+ ", cliente=" + cliente + "]";
	}
	
	
	
}

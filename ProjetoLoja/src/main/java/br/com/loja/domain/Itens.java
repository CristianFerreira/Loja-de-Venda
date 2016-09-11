package br.com.loja.domain;

import java.math.BigDecimal;

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

@Entity
@Table(name="db_itens")
@NamedQueries({ 
	@NamedQuery(name = "Itens.listar", query = "SELECT itens FROM Itens itens"),
	@NamedQuery(name="Itens.buscarPorCodigo", query = "SELECT itens FROM Itens itens"
		+ " WHERE itens.codigo = :codigo") })
public class Itens {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="itemID")
	private Long codigo;
	
	@Column(name="valor_parcial", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="db_venda_vendaID", referencedColumnName="vendaID", nullable = false)
	private Venda venda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="db_produto_produtoID", referencedColumnName="produtoID", nullable = false)
	private Produto produto;

	
	//GET E SET
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Itens [codigo=" + codigo + ", valor=" + valor + ", quantidade=" + quantidade + ", venda=" + venda
				+ ", produto=" + produto + "]";
	}
	
	
}

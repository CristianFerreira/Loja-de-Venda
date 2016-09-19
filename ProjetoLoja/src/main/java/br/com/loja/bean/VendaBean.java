package br.com.loja.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Itens;
import br.com.loja.domain.PessoaFisica;
import br.com.loja.domain.Produto;
import br.com.loja.domain.Venda;
import br.com.loja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {
	private Venda venda;
	
	private List<Produto> listaDeProdutos;
	private List<Produto> listaFiltrarProdutos;

	private List<Itens> listaDeItens;

	
	
	public Venda getVenda() {
		if(venda == null){
			venda = new Venda();
			venda.setValor(new BigDecimal("0.00"));
		}
		
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public List<Produto> getListaFiltrarProdutos() {
		return listaFiltrarProdutos;
	}

	public void setListaFiltrarProdutos(List<Produto> listaFiltrarProdutos) {
		this.listaFiltrarProdutos = listaFiltrarProdutos;
	}

	public List<Itens> getListaDeItens() {
		if (listaDeItens == null) {
			listaDeItens = new ArrayList<>();
		}
		return listaDeItens;
	}

	public void setListaDeItens(List<Itens> listaDeItens) {
		this.listaDeItens = listaDeItens;
	}

	// Metodos
	public void listarProduto() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			listaDeProdutos = pdao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os produtos:" + ex.getMessage());
		}
	}

	public void adicionarItens(Produto produto) {
		int posicaoEncontrada = -1;

		for (int posicao = 0; posicao < listaDeItens.size() && posicaoEncontrada < 0; posicao++) {
			Itens comparandoItens = listaDeItens.get(posicao);

			if (comparandoItens.getProduto().equals(produto)) {
				posicaoEncontrada = posicao;
			}
		}

		Itens item = new Itens();
		item.setProduto(produto);

		if (posicaoEncontrada < 0) {
			item.setQuantidade(1);
			item.setValor(produto.getPreco());
			listaDeItens.add(item);
		} else {
			Itens itemEncontrado = listaDeItens.get(posicaoEncontrada);
			item.setQuantidade(itemEncontrado.getQuantidade() + 1);
			item.setValor(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
			listaDeItens.set(posicaoEncontrada, item);
		}
		
		venda.setValor(venda.getValor().add(produto.getPreco()));
	}

	public void removerItens(Itens itens) {

		int posicaoEncontrada = -1;

		for (int posicao = 0; posicao < listaDeItens.size() && posicaoEncontrada < 0; posicao++) {
			Itens comparandoItens = listaDeItens.get(posicao);

			if (comparandoItens.getProduto().equals(itens.getProduto())) {
				posicaoEncontrada = posicao;
			}
		}

		if (posicaoEncontrada > -1) {
			listaDeItens.remove(posicaoEncontrada);
			
			venda.setValor(venda.getValor().subtract(itens.getValor()));
		}
		
		

	}
	
	public void prepararNovaVenda(){
		venda.setData(new Date());
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);
		venda.setFuncionario(funcionario);
	}
	
	

}

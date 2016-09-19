package br.com.loja.bean;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Produto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.loja.util.FacesUtil;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private Produto produto;
	private List<Produto> listaDeProdutos;
	private List<Produto> listaFiltrarProdutos;

	private List<Fabricante> listaDeFabricantes;
	private Long codigo;

	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public Produto getProduto() {
		if (produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
	
	
	public List<Fabricante> getListaDeFabricantes() {
		return listaDeFabricantes;
	}

	public void setListaDeFabricantes(List<Fabricante> listaDeFabricantes) {
		this.listaDeFabricantes = listaDeFabricantes;
	}

	// Metodos

	public void prepararNovoProduto() {
		
		System.out.println("produto desc anteS: " +produto.getDescricao());
		System.out.println("produto qnt anteS: " +produto.getQuantidade());
		FabricanteDAO fdao = new FabricanteDAO();
		listaDeFabricantes = fdao.listar();
		produto = new Produto();
		
		System.out.println("produto desc depois: " +produto.getDescricao());
		System.out.println("produto qnt depois: " +produto.getQuantidade());
	}

	public void salvar() {

		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.salvar(produto);

			FacesUtil.adicionarMsgSucesso("Produto salvo com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar o produto: " + ex.getMessage());
		}
	}

	public void listarProduto() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			listaDeProdutos = pdao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os produtos:" + ex.getMessage());
		}
	}

	public void editarProduto() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.editar(produto);

			produto = new Produto();
			FacesUtil.adicionarMsgSucesso("Produto editado com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar o produto:" + ex.getMessage());
		}
	}

	public void excluirProduto() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			pdao.excluir(produto);

			produto = new Produto();
			FacesUtil.adicionarMsgSucesso("Produto excluido com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar excluir o produto:" + ex.getMessage());
		}
	}

}

package br.com.loja.test;



import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		FabricanteDAO fdao = new FabricanteDAO();
		Fabricante fabricante = fdao.buscarPorCodigo(1L);
		
		Produto produto = new Produto();
		produto.setDescricao("CAMISETA Y");
		produto.setPreco(new BigDecimal(10.00D));
		produto.setQuantidade(10);
		produto.setFabricante(fabricante);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(produto);
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ProdutoDAO pdao = new ProdutoDAO();
		Produto produto = pdao.buscarPorCodigo(2L);
		System.out.println(produto);
	}
	
	@Test
	@Ignore
	public void listar(){
		ProdutoDAO pdao = new ProdutoDAO();
		List<Produto> produto = pdao.listar();
		
		for (Produto produtos : produto) {
			System.out.println(produtos);
		}
	
				
	}
	
	@Test
	@Ignore
	public void excluir(){
		ProdutoDAO pdao = new ProdutoDAO();
		
		Produto produto = pdao.buscarPorCodigo(3L);
		pdao.excluir(produto);
	}
	
	@Test
	
	public void editar(){
		ProdutoDAO pdao = new ProdutoDAO();
		
		Produto produto = pdao.buscarPorCodigo(2L);
		
		produto.setDescricao("MEIA");
		produto.setPreco(new BigDecimal(6.40D));
		produto.setQuantidade(15);
		
		FabricanteDAO fdao = new FabricanteDAO();
		Fabricante fabricante = fdao.buscarPorCodigo(1L);
		produto.setFabricante(fabricante);
		
		pdao.editar(produto);
		
	}
}

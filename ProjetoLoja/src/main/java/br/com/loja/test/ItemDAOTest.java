package br.com.loja.test;

import java.math.BigDecimal;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.ItemDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.dao.VendaDAO;

import br.com.loja.domain.Itens;
import br.com.loja.domain.Produto;
import br.com.loja.domain.Venda;

public class ItemDAOTest {
	
	@Test

	public void salvar(){
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(1L);
		
		ProdutoDAO pdao = new ProdutoDAO();
		Produto produto = pdao.buscarPorCodigo(1L);
				
		Itens item = new Itens();
		item.setProduto(produto);
		item.setQuantidade(5);
		item.setValor(new BigDecimal(10.00D));
		item.setVenda(venda);

		ItemDAO idao = new ItemDAO();
		idao.salvar(item);
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ItemDAO idao = new ItemDAO();
		Itens item = idao.buscarPorCodigo(2L);
		System.out.println(item);
	}
	
	@Test
	@Ignore
	public void listar(){
		ItemDAO idao = new ItemDAO();
		List<Itens> item = idao.listar();
		
		for (Itens itens : item) {
			System.out.println(itens);
		}
	
				
	}
	
	@Test
	@Ignore
	public void excluir(){
		ItemDAO idao = new ItemDAO();
		
		Itens itens = idao.buscarPorCodigo(2L);
		idao.excluir(itens);
	}
	
	@Test
	@Ignore
	public void editar(){
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(1L);
		
		ProdutoDAO pdao = new ProdutoDAO();
		Produto produto = pdao.buscarPorCodigo(1L);
				
		Itens item = new Itens();
		item.setProduto(produto);
		item.setQuantidade(10);
		item.setValor(new BigDecimal(10.00D));
		item.setVenda(venda);

		ItemDAO idao = new ItemDAO();
		idao.editar(item);
		
	}

}

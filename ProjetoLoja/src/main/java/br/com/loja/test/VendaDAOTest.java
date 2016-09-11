package br.com.loja.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.dao.FabricanteDAO;
import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.dao.VendaDAO;
import br.com.loja.domain.Cliente;
import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Produto;
import br.com.loja.domain.Venda;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar(){
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(4L);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente cliente = cdao.buscarPorCodigo(7L);
		
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setData(new Date());
		venda.setValor(new BigDecimal(500.00D));
		
		VendaDAO vdao = new VendaDAO();
		vdao.salvar(venda);
		
		
		
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		VendaDAO vdao = new VendaDAO();
		Venda venda = vdao.buscarPorCodigo(2L);
		System.out.println(venda);
	}
	
	@Test
	@Ignore
	public void listar(){
		VendaDAO vdao = new VendaDAO();
		List<Venda> venda = vdao.listar();
		
		for (Venda vendas : venda) {
			System.out.println(vendas);
		}
	
				
	}
	
	@Test
	@Ignore
	public void excluir(){
		VendaDAO vdao = new VendaDAO();
		
		Venda venda = vdao.buscarPorCodigo(2L);
		vdao.excluir(venda);
	}
	
	@Test
	@Ignore
	public void editar(){
		FuncionarioDAO fdao = new FuncionarioDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(4L);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente cliente = cdao.buscarPorCodigo(7L);
		VendaDAO vdao = new VendaDAO();	
		Venda venda = vdao.buscarPorCodigo(2L);
			
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setData(new Date());
		venda.setValor(new BigDecimal(500.00D));
		
	
		vdao.editar(venda);
		
	}
}

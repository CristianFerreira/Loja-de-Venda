package br.com.loja.test;


import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.domain.Cliente;



public class ClienteDAOTest {

	@Test
	@Ignore
	public void buscarPorCodigo(){
		ClienteDAO dao = new ClienteDAO();
		Cliente f1 = dao.buscarPorCodigo(1L);
			System.out.println(f1);		
	}
	
	@Test
	@Ignore
	public void excluirPorCodigo(){
		ClienteDAO dao = new ClienteDAO();
		
		dao.excluir(5L);	
	}
	
}

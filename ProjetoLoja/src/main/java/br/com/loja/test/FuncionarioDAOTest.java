package br.com.loja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.domain.Funcionario;




public class FuncionarioDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Funcionario f1 = new Funcionario();
		f1.setNome("Cristian");
		f1.setCpf("111.822.200-03");
		f1.setTipo("Vendedor");
		f1.setSenha("12345623");
			
		
		FuncionarioDAO dao = new FuncionarioDAO();
		dao.salvar(f1);

	
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		for(Funcionario funcionario : funcionarios){
			System.out.println(funcionario);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = dao.buscarPorCodigo(1L);
		Funcionario f2 = dao.buscarPorCodigo(3L);
		
		
			System.out.println(f1);
			System.out.println(f2);
		
	}
	
//	@Test
//	@Ignore
//	public void excluir(){
//		FabricanteDAO dao =  new FabricanteDAO();
//		
//		Fabricante fabricante = dao.buscarPorCodigo(2L);
//		if(fabricante !=null){
//			dao.excluir(fabricante);
//		}
//		
//	}
	
	//@Test
	//@Ignore
	//public void excluirPorCodigo(){
		//FuncionarioDAO dao =  new FuncionarioDAO();
		
		//dao.excluir(3L);	
	//}
	

	@Test
	public void editar(){
		FuncionarioDAO dao =  new FuncionarioDAO();
		Funcionario f1 = new Funcionario();
		f1.setCodigo(4L);
		f1.setNome("Cristian Ferreira");
		f1.setCpf("111.822.200-03");
		f1.setTipo("Vendedor");
		f1.setSenha("12345623");
		f1.setTelefone("(51)8022-2209");
		
		
		dao.editar(f1);
		
	}
}

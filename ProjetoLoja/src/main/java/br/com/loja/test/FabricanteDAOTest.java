package br.com.loja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	
	public void salvar(){
		Fabricante f1 = new Fabricante();
		f1.setNome("Robust LTDA");
		f1.setDescricao("Gedore");
		
		Fabricante f2 = new Fabricante();
		f2.setNome("GEDORE LTDA");
		f2.setDescricao("Robust");
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		
		for(Fabricante fabricante : fabricantes){
			System.out.println(fabricante);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorCodigo(1L);
		Fabricante f2 = dao.buscarPorCodigo(5L);
		
		
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
	
	@Test
	@Ignore
	public void excluirPorCodigo(){
		FabricanteDAO dao =  new FabricanteDAO();
		
		dao.excluir(2L);	
	}
	
	@Test
	@Ignore
	public void editar(){
		FabricanteDAO dao =  new FabricanteDAO();
		Fabricante f1 = new Fabricante();
		f1.setCodigo(1L);
		f1.setNome("RENNER");
		
		dao.editar(f1);
		
	}
	
	
}

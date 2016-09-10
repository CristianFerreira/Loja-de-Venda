package br.com.loja.test;

import org.junit.Test;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	public void salvar(){
		Fabricante f1 = new Fabricante();
		f1.setDescricao("Gedore");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("Robust");
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);
	}
}

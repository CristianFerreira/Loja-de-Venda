package br.com.loja.test;



import org.junit.Test;

import br.com.loja.util.HibernateUtil;

public class GerarTabelasTest {
	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}

package br.com.loja.main;

import br.com.loja.util.HibernateUtil;



public class GeraTabela {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	
		
	}

}

package br.com.loja.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.Fabricante;
import br.com.loja.util.HibernateUtil;

public class FabricanteDAO {
	public void salvar(Fabricante fabricante){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
			transacao.commit();
		} catch (RuntimeException ex) {
			if(transacao != null){
				transacao.rollback();
			}
			throw ex;
			
		}finally{
			sessao.close();
		}
		
	
	}
	
	
	

}

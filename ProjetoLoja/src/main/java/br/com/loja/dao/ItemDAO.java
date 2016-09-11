package br.com.loja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.Itens;
import br.com.loja.util.HibernateUtil;

public class ItemDAO {

	public void salvar(Itens itens) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(itens);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;

		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Itens> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<Itens> itens = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Itens.listar");
			itens = consulta.list();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return itens;
	}
	
	public Itens buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Itens itens = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Itens.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			itens = (Itens) consulta.uniqueResult();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return itens;
	}
	
	
	public void excluir(Itens itens) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(itens);
			transacao.commit();
		}catch(RuntimeException ex){
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		}finally{
			sessao.close();
		}
	}
	
	public void editar(Itens itens) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(itens);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;

		} finally {
			sessao.close();
		}

	}
	
}

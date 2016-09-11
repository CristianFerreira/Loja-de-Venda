package br.com.loja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.Fabricante;
import br.com.loja.util.HibernateUtil;

public class FabricanteDAO {
	public void salvar(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(fabricante);
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
	public List<Fabricante> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<Fabricante> fabricante = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Fabricante.listar");
			fabricante = consulta.list();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return fabricante;
	}
	
	public Fabricante buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Fabricante fabricante = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Fabricante.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fabricante = (Fabricante) consulta.uniqueResult();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return fabricante;
	}
	
//	public void excluir(Fabricante fabricante) {
//		Session sessao = HibernateUtil.getSessionFactory().openSession();
//		Transaction transacao = null;
//
//		try {
//			transacao = sessao.beginTransaction();
//			sessao.delete(fabricante);
//			transacao.commit();
//		} catch (RuntimeException ex) {
//			if (transacao != null) {
//				transacao.rollback();
//			}
//			throw ex;
//
//		} finally {
//			sessao.close();
//		}
//
//	}
	
	public void excluir(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			Fabricante fabricante = buscarPorCodigo(codigo);
			sessao.delete(fabricante);
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
	
	public void editar(Fabricante fabricante) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
//			Fabricante fabricanteEditar = buscarPorCodigo(fabricante.getCodigo());
//			fabricanteEditar.setNome(fabricante.getNome());
//			fabricanteEditar.setDescricao(fabricante.getDescricao());
//			
//			sessao.update(fabricanteEditar);
			
			sessao.update(fabricante);
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

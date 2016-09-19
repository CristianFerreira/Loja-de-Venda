package br.com.loja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.PessoaFisica;
import br.com.loja.util.FacesUtil;
import br.com.loja.util.HibernateUtil;

public class PessoaFisicaDAO {
	
	public void salvar(PessoaFisica pf) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(pf);
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
	public List<PessoaFisica> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<PessoaFisica> pf = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PessoaFisica.listar");
			pf = consulta.list();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return pf;
	}
	
	public PessoaFisica buscarPorCPF(String cpf) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		PessoaFisica pf = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PessoaFisica.buscarPorCPF");
			consulta.setString("cpf", cpf);
			pf = (PessoaFisica) consulta.uniqueResult();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return pf;
	}
	
	
	public void editar(PessoaFisica pf) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();			
			sessao.update(pf);
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

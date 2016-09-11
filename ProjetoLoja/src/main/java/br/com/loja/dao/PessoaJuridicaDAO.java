package br.com.loja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.PessoaFisica;
import br.com.loja.domain.PessoaJuridica;
import br.com.loja.util.HibernateUtil;

public class PessoaJuridicaDAO {

	public void salvar(PessoaJuridica pj) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(pj);
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
	public List<PessoaJuridica> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		List<PessoaJuridica> pj = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PessoaJuridica.listar");
			pj = consulta.list();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return pj;
	}
	
	public PessoaJuridica buscarPorCNPJ(String cnpj) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		PessoaJuridica pj = null;
		
		try{
			Query consulta = sessao.getNamedQuery("PessoaJuridica.buscarPorCNPJ");
			consulta.setString("cnpj", cnpj);
			pj = (PessoaJuridica) consulta.uniqueResult();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return pj;
	}
	
	public void editar(PessoaJuridica pj) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();			
			sessao.update(pj);
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

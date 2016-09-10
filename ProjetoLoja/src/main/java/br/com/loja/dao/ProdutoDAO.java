package br.com.loja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.Produto;
import br.com.loja.util.HibernateUtil;

public class ProdutoDAO {
	
	public void salvar(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.save(produto);
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
	
	
	@SuppressWarnings("unchecked")
	public List<Produto> listar(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Produto>produtos = null;		
		try{
			Query consulta = sessao.getNamedQuery("Produto.listar");
			produtos = consulta.list();
		}catch(RuntimeException ex){			
			throw ex;
		}finally{
			sessao.close();
		}
		return produtos;
	}
	
	
	public Produto buscarPorCodigo(Long codigo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Produto produto = null;
		try{
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			
			produto = (Produto) consulta.uniqueResult();
		}catch(RuntimeException ex){			
			throw ex;
		}finally{
			sessao.close();
		}
		return produto;
	}
	
	public void excluir(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
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
	
	public void editar(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.update(produto);
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

}

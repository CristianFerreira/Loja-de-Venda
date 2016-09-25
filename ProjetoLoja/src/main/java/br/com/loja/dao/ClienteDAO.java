package br.com.loja.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.Cliente;
import br.com.loja.domain.Funcionario;
import br.com.loja.util.HibernateUtil;

public class ClienteDAO {

	public Cliente buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Cliente cliente = null;
		
		try{
			Query consulta = sessao.getNamedQuery("Cliente.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			cliente = (Cliente) consulta.uniqueResult();
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return cliente;
	}
	
	
	public String buscarPorTipo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Cliente cliente = null;
		String tipoCliente = "";
		
		try{
			Query consulta = sessao.getNamedQuery("Cliente.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			cliente = (Cliente) consulta.uniqueResult();
			tipoCliente = cliente.getTipo();
			
		} catch(RuntimeException ex){
			throw ex;
		}finally {
			sessao.close();
		}
		return tipoCliente;
	}
	
	
	public void excluir(Cliente cliente) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try{
			transacao = sessao.beginTransaction();
			sessao.delete(cliente);
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
   
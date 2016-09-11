package br.com.loja.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.loja.domain.Cliente;
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
	
}
   
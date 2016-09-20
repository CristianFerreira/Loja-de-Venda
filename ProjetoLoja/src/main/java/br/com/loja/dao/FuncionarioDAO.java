package br.com.loja.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Funcionario;
import br.com.loja.util.HibernateUtil;

public class FuncionarioDAO {

	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(funcionario);
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
	public List<Funcionario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Funcionario> funcionario = null;

		try {
			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionario = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return funcionario;
	}

	public Funcionario buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {
			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return funcionario;
	}

	// public void excluir(Fabricante fabricante) {
	// Session sessao = HibernateUtil.getSessionFactory().openSession();
	// Transaction transacao = null;
	//
	// try {
	// transacao = sessao.beginTransaction();
	// sessao.delete(fabricante);
	// transacao.commit();
	// } catch (RuntimeException ex) {
	// if (transacao != null) {
	// transacao.rollback();
	// }
	// throw ex;
	//
	// } finally {
	// sessao.close();
	// }
	//
	// }

	public void excluir(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(funcionario);
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

	public void editar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			// Fabricante fabricanteEditar =
			// buscarPorCodigo(fabricante.getCodigo());
			// fabricanteEditar.setNome(fabricante.getNome());
			// fabricanteEditar.setDescricao(fabricante.getDescricao());
			//
			// sessao.update(fabricanteEditar);

			sessao.update(funcionario);
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

	public Funcionario login(String cpf, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;

		try {
			Query consulta = sessao.getNamedQuery("Funcionario.logar");
			consulta.setString("cpf", cpf);
			consulta.setString("senha", senha);
			funcionario = (Funcionario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}

		return funcionario;
	}

}

package br.com.loja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.dao.PessoaFisicaDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.PessoaFisica;

public class PessoaFisicaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		PessoaFisica f1 = new PessoaFisica();
		f1.setNome("Thais trindade");
		f1.setCpf("111.822.200-00");
		f1.setTipo("F");
		f1.setEstado("RS");
		f1.setNumero("123");
		f1.setRua("souza mello");
		f1.setTelefone("3131231313");
		f1.setCep("9131312312");
		f1.setBairro("sarandi");

		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		dao.salvar(f1);
	}

	@Test
	@Ignore
	public void listar() {
		PessoaFisicaDAO fdao = new PessoaFisicaDAO();
		List<PessoaFisica> pf = fdao.listar();

		for (PessoaFisica PF : pf) {
			System.out.println(PF);
		}
	}

	@Test
	
	public void buscarPorCPF() {
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica f1 = dao.buscarPorCPF("031.831.200-02");

		System.out.println(f1);

	}
	
	
	@Test
	@Ignore
	public void editar(){
		PessoaFisicaDAO dao = new PessoaFisicaDAO();
		PessoaFisica f1 = new PessoaFisica();
		f1.setCodigo(1L);
		f1.setNome("Moises");
		f1.setCpf("111.822.200-12");
		f1.setTipo("F");
		f1.setEstado("RS");
		f1.setNumero("123");
		f1.setRua("souza mello");
		f1.setTelefone("3131231313");
		f1.setCep("9131312312");
		f1.setBairro("sarandi");

		dao.editar(f1);	
	}
	
	
	
}

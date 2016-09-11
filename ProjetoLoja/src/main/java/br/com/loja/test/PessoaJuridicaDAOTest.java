package br.com.loja.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.loja.dao.PessoaFisicaDAO;
import br.com.loja.dao.PessoaJuridicaDAO;
import br.com.loja.domain.PessoaFisica;
import br.com.loja.domain.PessoaJuridica;

public class PessoaJuridicaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		PessoaJuridica f1 = new PessoaJuridica();
		f1.setNome("Thais trindade");
		f1.setCnpj("111.822.200/0001");
		f1.setNomeFantasia("EMPRESA X");
		f1.setTipo("J");
		f1.setEstado("RS");
		f1.setNumero("123");
		f1.setRua("souza mello");
		f1.setTelefone("3131231313");
		f1.setCep("9131312312");
		f1.setBairro("sarandi");

		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		pjdao.salvar(f1);
	}

	@Test
	@Ignore
	public void listar() {
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		List<PessoaJuridica> pj = pjdao.listar();

		for (PessoaJuridica PJ : pj) {
			System.out.println(PJ);
		}
	}

	@Test
	@Ignore
	public void buscarPorCNPJ() {
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		PessoaJuridica f1 = pjdao.buscarPorCNPJ("111.111.111/0001");

		System.out.println(f1);

	}
	
	
	@Test
	@Ignore
	public void editar(){
		PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
		PessoaJuridica f1 = new PessoaJuridica();
		f1.setCodigo(2L);
		f1.setNome("TESTE");
		f1.setCnpj("000000000/00001");
		f1.setNomeFantasia("TESTE1");
		f1.setTipo("J");
		f1.setEstado("RS");
		f1.setNumero("123");
		f1.setRua("souza mello");
		f1.setTelefone("3131231313");
		f1.setCep("9131312312");
		f1.setBairro("sarandi");

		pjdao.editar(f1);	
	}
	
}

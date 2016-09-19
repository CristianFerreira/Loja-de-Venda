package br.com.loja.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.dao.PessoaFisicaDAO;
import br.com.loja.domain.PessoaFisica;
import br.com.loja.util.FacesUtil;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaFisicaBean {

	private PessoaFisica pessoaFisica;

	private List<PessoaFisica> listaPessoaFisica;
	private List<PessoaFisica> listaFiltrarPessoaFisica;
	private String[] arrayEstados = { "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
			"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará",
			"Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
			"Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" };

	public String[] getArrayEstados() {
		return arrayEstados;
	}

	public void setArrayEstados(String[] arrayEstados) {
		this.arrayEstados = arrayEstados;
	}

	// GET E SET
	public PessoaFisica getPessoaFisica() {
		if (pessoaFisica == null) {
			pessoaFisica = new PessoaFisica();
		}
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public List<PessoaFisica> getListaPessoaFisica() {
		return listaPessoaFisica;
	}

	public void setListaPessoaFisica(List<PessoaFisica> listaPessoaFisica) {
		this.listaPessoaFisica = listaPessoaFisica;
	}

	public List<PessoaFisica> getListaFiltrarPessoaFisica() {
		return listaFiltrarPessoaFisica;
	}

	public void setListaFiltrarPessoaFisica(List<PessoaFisica> listaFiltrarPessoaFisica) {
		this.listaFiltrarPessoaFisica = listaFiltrarPessoaFisica;
	}

	// Metodos

	public void prepararNovaPessoaFisica() {
		pessoaFisica = new PessoaFisica();
	}

	public void salvarPessoaFisica() {

		try {
			pessoaFisica.setTipo("PF");

			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			pfdao.salvar(pessoaFisica);

			FacesUtil.adicionarMsgSucesso("Cliente salvo com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar o cliente: " + ex.getMessage());
		}
	}

	public void listarPessoaFisica() {
		try {
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			listaPessoaFisica = pfdao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os clientes:" + ex.getMessage());
		}
	}

	public void editarPessoaFisica() {
		try {
			PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
			pfdao.editar(pessoaFisica);

			pessoaFisica = new PessoaFisica();
			FacesUtil.adicionarMsgSucesso("Cliente editado com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar o cliente:" + ex.getMessage());
		}
	}

	public void excluirPessoaFisica() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(pessoaFisica);

			pessoaFisica = new PessoaFisica();
			FacesUtil.adicionarMsgSucesso("Cliente excluido com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar excluir o Cliente:" + ex.getMessage());
		}
	}

}

package br.com.loja.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.dao.PessoaJuridicaDAO;
import br.com.loja.domain.PessoaJuridica;
import br.com.loja.util.FacesUtil;

import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaJuridicaBean {

	private PessoaJuridica pessoaJuridica;

	private List<PessoaJuridica> listaPessoaJuridica;
	private List<PessoaJuridica> listaFiltrarPessoaJuridica;
	private String[] arrayEstados = { "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
			"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará",
			"Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
			"Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" };

	// Metodos

	public PessoaJuridica getPessoaJuridica() {

		if (pessoaJuridica == null) {
			pessoaJuridica = new PessoaJuridica();
		}

		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public List<PessoaJuridica> getListaPessoaJuridica() {
		return listaPessoaJuridica;
	}

	public void setListaPessoaJuridica(List<PessoaJuridica> listaPessoaJuridica) {
		this.listaPessoaJuridica = listaPessoaJuridica;
	}

	public List<PessoaJuridica> getListaFiltrarPessoaJuridica() {
		return listaFiltrarPessoaJuridica;
	}

	public void setListaFiltrarPessoaJuridica(List<PessoaJuridica> listaFiltrarPessoaJuridica) {
		this.listaFiltrarPessoaJuridica = listaFiltrarPessoaJuridica;
	}

	public String[] getArrayEstados() {
		return arrayEstados;
	}

	public void setArrayEstados(String[] arrayEstados) {
		this.arrayEstados = arrayEstados;
	}

	public void prepararNovaPessoaJuridica() {
		pessoaJuridica = new PessoaJuridica();
	}

	public void salvarPessoaJuridica() {

		try {
			pessoaJuridica.setTipo("PJ");

			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			pjdao.salvar(pessoaJuridica);

			FacesUtil.adicionarMsgSucesso("Cliente salvo com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar o cliente: " + ex.getMessage());
		}
	}

	public void listarPessoaJuridica() {
		try {
			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			listaPessoaJuridica = pjdao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os clientes:" + ex.getMessage());
		}
	}

	public void editarPessoaJuridica() {
		try {
			PessoaJuridicaDAO pjdao = new PessoaJuridicaDAO();
			pjdao.editar(pessoaJuridica);

			pessoaJuridica = new PessoaJuridica();
			FacesUtil.adicionarMsgSucesso("Cliente editado com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar o cliente:" + ex.getMessage());
		}
	}

	public void excluirPessoaJuridica() {
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(pessoaJuridica);

			pessoaJuridica = new PessoaJuridica();
			FacesUtil.adicionarMsgSucesso("Cliente excluido com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar excluir o Cliente:" + ex.getMessage());
		}
	}

}

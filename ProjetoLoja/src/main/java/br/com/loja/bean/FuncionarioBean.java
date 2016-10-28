package br.com.loja.bean;

import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.loja.util.FacesUtil;
import java.util.List;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

	private Funcionario funcionario;
	private String senhaAtual;
	private Funcionario funcionarioLogado;
	private List<Funcionario> listaFuncionario;
	private List<Funcionario> listaFiltrarFuncionario;

	public Funcionario getFuncionario() {
		if (funcionario == null) {
			funcionario = new Funcionario();
		}
		return funcionario;
	}
	
	

	public Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}



	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}



	public String getSenhaAtual() {
		return senhaAtual;
	}



	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}



	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public List<Funcionario> getListaFiltrarFuncionario() {
		return listaFiltrarFuncionario;
	}

	public void setListaFiltrarFuncionario(List<Funcionario> listaFiltrarFuncionario) {
		this.listaFiltrarFuncionario = listaFiltrarFuncionario;
	}

	public void prepararNovoFuncionario() {
		funcionario = new Funcionario();
	}

	public void salvar() {

		// FacesUtil.adicionarMsgSucesso(fabricante.toString());
		try {
			System.out.println("Funcionario >>> "+funcionario.getNome()+","+funcionario.getCpf()+","+funcionario.getTelefone()+","+funcionario.getTipo()+","+funcionario.getCodigo()+","+funcionario.getSenha());
			FuncionarioDAO fdao = new FuncionarioDAO();
			funcionario.setSenha(DigestUtils.md5Hex(funcionario.getSenha()));
			System.out.println("Funcionario >>> "+funcionario.getNome()+","+funcionario.getCpf()+","+funcionario.getTelefone()+","+funcionario.getTipo()+","+funcionario.getCodigo()+","+funcionario.getSenha());
			fdao.salvar(funcionario);

			FacesUtil.adicionarMsgSucesso("Funcionario salvo com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro111 ao tentar salvar o funcionario: " + ex.getMessage());
		}
	}

	public void listarFuncionario() {
		try {
			FuncionarioDAO fdao = new FuncionarioDAO();
			listaFuncionario = fdao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os fabricantes:" + ex.getMessage());
		}
	}

	public void editarFuncionario() {
		try {
			
			System.out.println("SENHA: "+funcionario.getSenha());
			FuncionarioDAO fdao = new FuncionarioDAO();
//			funcionario.setSenha(DigestUtils.md5Hex(funcionario.getSenha()));
			fdao.editar(funcionario);

			funcionario = new Funcionario();
			FacesUtil.adicionarMsgSucesso("Funcionario editado com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar editar o funcionario:" + ex.getMessage());
		}
	}

	public void excluirFuncionario() {
		try {
			FuncionarioDAO fdao = new FuncionarioDAO();
			fdao.excluir(funcionario);

			funcionario = new Funcionario();
			FacesUtil.adicionarMsgSucesso("Funcionario excluido com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar excluir o funcionario:" + ex.getMessage());
		}
	}
	
	
	

}

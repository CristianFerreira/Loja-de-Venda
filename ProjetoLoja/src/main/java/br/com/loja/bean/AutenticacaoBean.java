package br.com.loja.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.codec.digest.DigestUtils;

import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.domain.Funcionario;
import br.com.loja.util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Funcionario funcionarioLogado;
	private String senhaAtual;
	private boolean validaSenhaAtual;

	public Funcionario getFuncionarioLogado() {
		if (funcionarioLogado == null) {
			funcionarioLogado = new Funcionario();
		}
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	public Boolean getValidaSenhaAtual() {
		return validaSenhaAtual;
	}

	public void setValidaSenhaAtual(Boolean validaSenhaAtual) {
		this.validaSenhaAtual = validaSenhaAtual;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String autenticarFuncionario() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioLogado = funcionarioDAO.login(funcionarioLogado.getCpf(),
					DigestUtils.md5Hex(funcionarioLogado.getSenha()));
			FuncionarioBean funcionarioBean = new FuncionarioBean();
			System.out.println(funcionarioLogado);
			funcionarioBean.setFuncionarioLogado(funcionarioLogado);

			if (funcionarioLogado == null) {
				FacesUtil.adicionarMsgErro("CPF e/ou senha inválidos");

				return null;
			} else {
				FacesUtil.adicionarMsgSucesso("Bem vindo ao sistema");
				return "/pages/principal.xhtml?faces-redirect=true";
			}
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar entrar no sistema: " + ex.getMessage());
			return null;
		}
	}

	public String sairDoSistema() {
		funcionarioLogado = null;
		return "/pages/home.xhtml?faces-redirect=true";
	}

	public String verificarSenhaAtual() {
		String senha = DigestUtils.md5Hex(senhaAtual);

		System.out.println(funcionarioLogado.getSenha());
		System.out.println(senha);

		if (senha.equals(funcionarioLogado.getSenha())) {
			validaSenhaAtual = true;
			return "/pages/editarSenha.xhtml?faces-redirect=true";
		} else {
			validaSenhaAtual = false;
			FacesUtil.adicionarMsgErro("Senha inválida");
			return null;
		}

	}

	public String editarSenhaFuncionario() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioLogado.setSenha(DigestUtils.md5Hex(funcionarioLogado.getSenha()));
			funcionarioDAO.editar(funcionarioLogado);
			FacesUtil.adicionarMsgSucesso("Senha alterada com sucesso ");
			return "/pages/principal.xhtml?faces-redirect=true";

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar editar senha: " + ex.getMessage());
			return null;
		}
	}

	public String cancelarEditarSenha() {
		try {
			return "/pages/principal.xhtml?faces-redirect=true";
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar redirecionar para pagina principal: " + ex.getMessage());
			return null;
		}
	}

}

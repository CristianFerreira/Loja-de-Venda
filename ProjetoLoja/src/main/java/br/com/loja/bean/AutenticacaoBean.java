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

	public Funcionario getFuncionarioLogado() {
		if (funcionarioLogado == null) {
			funcionarioLogado = new Funcionario();
		}
		return funcionarioLogado;
	}

	public void setFuncionarioLogado(Funcionario funcionarioLogado) {
		this.funcionarioLogado = funcionarioLogado;
	}

	public String autenticarFuncionario() {
		try {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioLogado = funcionarioDAO.login(funcionarioLogado.getCpf(),
					DigestUtils.md5Hex(funcionarioLogado.getSenha()));
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
		return "/pages/login.xhtml?faces-redirect=true";
	}

}

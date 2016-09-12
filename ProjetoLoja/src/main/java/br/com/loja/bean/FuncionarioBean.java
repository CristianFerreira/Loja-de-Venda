package br.com.loja.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.loja.util.FacesUtil;
@ManagedBean
@ViewScoped
public class FuncionarioBean {

		public void salvar(){
			FacesUtil.adicionarMsgSucesso("Funcionario salvo com sucesso");
			//FacesUtil.adicionarMsgErro("Erro ao salvar o fabricante");
		}
		
	}

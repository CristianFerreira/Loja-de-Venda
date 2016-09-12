package br.com.loja.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.loja.domain.Fabricante;
import br.com.loja.util.FacesUtil;


@ManagedBean
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;

	public Fabricante getFabricante() {
		if(fabricante==null){
			fabricante = new Fabricante();
		}
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public void salvar() {
		
		FacesUtil.adicionarMsgSucesso(fabricante.toString());
		FacesUtil.adicionarMsgSucesso("Fabricante salvo com sucesso");
		// FacesUtil.adicionarMsgErro("Erro ao salvar o fabricante");
	}

}

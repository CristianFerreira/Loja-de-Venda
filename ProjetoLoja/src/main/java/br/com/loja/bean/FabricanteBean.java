package br.com.loja.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {

	private Fabricante fabricante;
	private List<Fabricante> listFabricante;
	private List<Fabricante> listFabricanteFiltro;

	public Fabricante getFabricante() {
		if (fabricante == null) {
			fabricante = new Fabricante();
		}
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getListFabricante() {
		return listFabricante;
	}

	public void setListFabricante(List<Fabricante> listFabricante) {
		this.listFabricante = listFabricante;
	}

	public List<Fabricante> getListFabricanteFiltro() {
		return listFabricanteFiltro;
	}

	public void setListFabricanteFiltro(List<Fabricante> listFabricanteFiltro) {
		this.listFabricanteFiltro = listFabricanteFiltro;
	}

	// Metodos

	public void salvar() {

		// FacesUtil.adicionarMsgSucesso(fabricante.toString());
		try {
			FabricanteDAO fdao = new FabricanteDAO();
			fdao.salvar(fabricante);

			fabricante = new Fabricante();
			FacesUtil.adicionarMsgSucesso("Fabricante salvo com sucesso");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar o fabricante:" + ex.getMessage());
		}

	}
	
	public void listarFabricante(){
		try{
			FabricanteDAO fdao = new FabricanteDAO();
			listFabricante = fdao.listar();
		}catch(RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os fabricantes:" + ex.getMessage());
		}
	}

}

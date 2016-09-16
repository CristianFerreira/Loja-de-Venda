package br.com.loja.bean;

import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.domain.Fabricante;
import br.com.loja.domain.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.loja.util.FacesUtil;
import java.util.List;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

    private Funcionario funcionario;
    private List<Funcionario> listaFuncionario;
    private List<Funcionario> listaFiltrarFuncionario;

    public Funcionario getFuncionario() {
    	if (funcionario == null) {
			funcionario = new Funcionario();
		}
		return funcionario;
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

    public void salvar() {

        // FacesUtil.adicionarMsgSucesso(fabricante.toString());
        try {
            FuncionarioDAO fdao = new FuncionarioDAO();
            fdao.salvar(funcionario);

            funcionario = new Funcionario();
            FacesUtil.adicionarMsgSucesso("Funcionario salvo com sucesso");
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            FacesUtil.adicionarMsgErro("Erro ao tentar salvar o funcionario: " + ex.getMessage());
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
            FuncionarioDAO fdao = new FuncionarioDAO();
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


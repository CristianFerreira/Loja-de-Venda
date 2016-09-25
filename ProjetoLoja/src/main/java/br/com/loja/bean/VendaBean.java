
package br.com.loja.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.loja.dao.ClienteDAO;
import br.com.loja.dao.FuncionarioDAO;
import br.com.loja.dao.ItemDAO;
import br.com.loja.dao.PessoaFisicaDAO;
import br.com.loja.dao.PessoaJuridicaDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.dao.VendaDAO;
import br.com.loja.domain.Cliente;
import br.com.loja.domain.Funcionario;
import br.com.loja.domain.Itens;
import br.com.loja.domain.PessoaFisica;
import br.com.loja.domain.PessoaJuridica;
import br.com.loja.domain.Produto;
import br.com.loja.domain.Venda;
import br.com.loja.filter.VendaFilter;
import br.com.loja.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {
	private Venda venda;

	private List<Produto> listaDeProdutos;
	private List<Produto> listaFiltrarProdutos;
	private Cliente clienteFinal;
	private PessoaFisica clientePF;
	private PessoaJuridica clientePJ;

	private String tipoDadoCliente;

	@ManagedProperty(value = "#{autenticacaoBean}")
	private AutenticacaoBean autenticacaoBean;

	private String buscarClientePeloTipoPF;
	private String buscarClientePeloTipoPJ;
	private String tipoCliente;
	private List<Itens> listaDeItens;
	private List<Venda> listaDeVendasFiltradas;

	private VendaFilter filtro;

	public String getTipoDadoCliente() {
		return tipoDadoCliente;
	}

	public void setTipoDadoCliente(String tipoDadoCliente) {
		this.tipoDadoCliente = tipoDadoCliente;
	}

	public Cliente getClienteFinal() {
		return clienteFinal;
	}

	public void setClienteFinal(Cliente clienteFinal) {
		this.clienteFinal = clienteFinal;
	}

	public String getBuscarClientePeloTipoPF() {
		return buscarClientePeloTipoPF;
	}

	public void setBuscarClientePeloTipoPF(String buscarClientePeloTipoPF) {
		this.buscarClientePeloTipoPF = buscarClientePeloTipoPF;
	}

	public String getBuscarClientePeloTipoPJ() {
		return buscarClientePeloTipoPJ;
	}

	public void setBuscarClientePeloTipoPJ(String buscarClientePeloTipoPJ) {
		this.buscarClientePeloTipoPJ = buscarClientePeloTipoPJ;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Venda getVenda() {
		if (venda == null) {

			venda = new Venda();
			venda.setValor(new BigDecimal("0.00"));
			venda.setQuantidadeTotal(0);
		}

		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public PessoaFisica getClientePF() {
		if (clientePF == null) {
			clientePF = new PessoaFisica();
		}

		return clientePF;
	}

	public void setClientePF(PessoaFisica clientePF) {
		this.clientePF = clientePF;
	}

	public PessoaJuridica getClientePJ() {
		if (clientePJ == null) {
			clientePJ = new PessoaJuridica();
		}

		return clientePJ;
	}

	public void setClientePJ(PessoaJuridica clientePJ) {
		this.clientePJ = clientePJ;
	}

	public void setListaDeProdutos(List<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public List<Produto> getListaFiltrarProdutos() {
		return listaFiltrarProdutos;
	}

	public void setListaFiltrarProdutos(List<Produto> listaFiltrarProdutos) {
		this.listaFiltrarProdutos = listaFiltrarProdutos;
	}

	public List<Itens> getListaDeItens() {
		if (listaDeItens == null) {
			listaDeItens = new ArrayList<>();
		}
		return listaDeItens;
	}

	public void setListaDeItens(List<Itens> listaDeItens) {
		this.listaDeItens = listaDeItens;
	}

	public AutenticacaoBean getAutenticacaoBean() {
		return autenticacaoBean;
	}

	public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
		this.autenticacaoBean = autenticacaoBean;
	}

	public List<Venda> getListaDeVendasFiltradas() {
		return listaDeVendasFiltradas;
	}

	public void setListaDeVendasFiltradas(List<Venda> listaDeVendasFiltradas) {
		this.listaDeVendasFiltradas = listaDeVendasFiltradas;
	}

	public VendaFilter getFiltro() {
		if (filtro == null) {
			filtro = new VendaFilter();
		}
		return filtro;
	}

	public void setFiltro(VendaFilter filtro) {
		this.filtro = filtro;
	}

	// Metodos
	public void listarProduto() {
		try {
			ProdutoDAO pdao = new ProdutoDAO();
			listaDeProdutos = pdao.listar();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.adicionarMsgErro("Erro ao tentar listar os produtos:" + ex.getMessage());
		}
	}

	public void adicionarItens(Produto produto) {
		int posicaoEncontrada = -1;

		for (int posicao = 0; posicao < listaDeItens.size() && posicaoEncontrada < 0; posicao++) {
			Itens comparandoItens = listaDeItens.get(posicao);

			if (comparandoItens.getProduto().equals(produto)) {
				posicaoEncontrada = posicao;
			}
		}

		Itens item = new Itens();
		item.setProduto(produto);

		if (posicaoEncontrada < 0) {
			item.setQuantidade(1);
			item.setValor(produto.getPreco());
			listaDeItens.add(item);
		} else {
			Itens itemEncontrado = listaDeItens.get(posicaoEncontrada);
			item.setQuantidade(itemEncontrado.getQuantidade() + 1);
			item.setValor(produto.getPreco().multiply(new BigDecimal(item.getQuantidade())));
			listaDeItens.set(posicaoEncontrada, item);
		}

		venda.setValor(venda.getValor().add(produto.getPreco()));
		venda.setQuantidadeTotal(venda.getQuantidadeTotal() + 1);
	}

	public void removerItens(Itens itens) {

		int posicaoEncontrada = -1;

		for (int posicao = 0; posicao < listaDeItens.size() && posicaoEncontrada < 0; posicao++) {
			Itens comparandoItens = listaDeItens.get(posicao);

			if (comparandoItens.getProduto().equals(itens.getProduto())) {
				posicaoEncontrada = posicao;
			}
		}

		if (posicaoEncontrada > -1) {
			listaDeItens.remove(posicaoEncontrada);

			venda.setValor(venda.getValor().subtract(itens.getValor()));
			venda.setQuantidadeTotal(venda.getQuantidadeTotal() - itens.getQuantidade());
		}

	}

	public void prepararNovaVenda() {

		venda.setData(new Date());

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(autenticacaoBean.getFuncionarioLogado().getCodigo());
		venda.setFuncionario(funcionario);

		if (clientePF.getCpf() != null) {
			venda.setCliente(clientePF);
		}
		if (clientePJ.getCnpj() != null) {
			venda.setCliente(clientePJ);
		}

	}

	public void salvarVenda() {
		try {
			VendaDAO vendaDAO = new VendaDAO();
			Long codigoVenda = vendaDAO.salvar(venda);

			Venda vendaFK = vendaDAO.buscarPorCodigo(codigoVenda);

			for (Itens item : listaDeItens) {
				item.setVenda(vendaFK);

				ItemDAO itemDAO = new ItemDAO();
				itemDAO.salvar(item);
			}

			venda = new Venda();
			venda.setValor(new BigDecimal("0.00"));

			listaDeItens = new ArrayList<Itens>();

			FacesUtil.adicionarMsgSucesso("Venda salva com sucesso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar a venda: " + ex.getMessage());
		}
	}

	public void buscarVenda() {

		try {
			VendaDAO vendaDAO = new VendaDAO();

			if (listaDeVendasFiltradas == null) {
				listaDeVendasFiltradas = vendaDAO.listar();
			} else {
				listaDeVendasFiltradas = vendaDAO.buscarVendas(filtro);
			}

		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar buscar a venda: " + ex.getMessage());
		}
	}

	public void selecionarCliente() {

		try {
			
			if (tipoCliente.equals("cpf")) {
				PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();
				clientePF = pessoaFisicaDAO.buscarPorCPF(buscarClientePeloTipoPF);
				if (clientePF.getCpf() != null) {
					clienteFinal = clientePF;
					tipoDadoCliente = clientePF.getCpf();
					FacesUtil.adicionarMsgSucesso("Cliente adicionado ao registro de venda");
				}
			}
			if (tipoCliente.equals("cnpj")) {
				clientePF = new PessoaFisica();
			}

			if (tipoCliente.equals("cnpj")) {
				PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();
				clientePJ = pessoaJuridicaDAO.buscarPorCNPJ(buscarClientePeloTipoPJ);
				if (clientePJ.getCnpj() != null) {
					clienteFinal = clientePJ;
					tipoDadoCliente = clientePJ.getCnpj();
					FacesUtil.adicionarMsgSucesso("Cliente adicionado ao registro de venda");
				}
			}
			if (tipoCliente.equals("cpf")) {
				clientePJ = new PessoaJuridica();
			}
			
			if(tipoCliente.equals("")){
				FacesUtil.adicionarMsgErro("Informe o CPF ou CNPJ do cliente");
			}
			
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Cliente não foi encontrado");
		}

	}

}

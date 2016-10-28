package br.com.loja.util;

import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.NavigationCase;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.loja.bean.AutenticacaoBean;
import br.com.loja.domain.Funcionario;

@SuppressWarnings("serial")
public class AutenticacaoPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext facesContext = event.getFacesContext();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String pagina = uiViewRoot.getViewId();

		boolean ehPaginaAutenticacao = pagina.contains("login.xhtml");
		boolean ehPaginaHome = pagina.contains("home.xhtml");
		boolean ehPaginaEditarSenha = pagina.contains("editarSenha.xhtml");

		if (!ehPaginaAutenticacao && !ehPaginaHome) {
			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, Object> mapa = externalContext.getSessionMap();
			AutenticacaoBean autenticacaoBean = (AutenticacaoBean) mapa.get("autenticacaoBean");

			Funcionario funcionario = autenticacaoBean.getFuncionarioLogado();

			if (funcionario.getCodigo() == null) {
				FacesUtil.adicionarMsgErro("Acesso restrito! Efetue o login para acessar o sistema");

				Application application = facesContext.getApplication();
				NavigationHandler navigationHandler = application.getNavigationHandler();
				navigationHandler.handleNavigation(facesContext, null, "/pages/login.xhml?faces-redirect=true");

			}

		}

		if (ehPaginaEditarSenha) {
			ExternalContext externalContext = facesContext.getExternalContext();
			Map<String, Object> mapa = externalContext.getSessionMap();
			AutenticacaoBean autenticacaoBean = (AutenticacaoBean) mapa.get("autenticacaoBean");
			boolean validaEditarSenha = autenticacaoBean.getValidaSenhaAtual();
			if (!validaEditarSenha) {
				FacesUtil.adicionarMsgErro("Informe sua Senha Atual");
				Application application = facesContext.getApplication();
				NavigationHandler navigationHandler = application.getNavigationHandler();
				navigationHandler.handleNavigation(facesContext, null, "/pages/manage.xhml?faces-redirect=true");
			}
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;

	}

}

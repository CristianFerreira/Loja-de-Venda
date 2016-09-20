package br.com.loja.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class FacesUtil {
	public static void adicionarMsgSucesso(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();
		
		Flash flash = externalContext.getFlash();
		flash.setKeepMessages(true);
		
		facesContext.addMessage(null, facesMessage);
	}

	public static void adicionarMsgErro(String mensagem) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		ExternalContext externalContext = facesContext.getExternalContext();
		
		Flash flash = externalContext.getFlash();
		flash.setKeepMessages(true);
		
		facesContext.addMessage(null, facesMessage);
	}
}

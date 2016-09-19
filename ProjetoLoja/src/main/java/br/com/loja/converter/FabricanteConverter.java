package br.com.loja.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.loja.dao.FabricanteDAO;
import br.com.loja.domain.Fabricante;

@FacesConverter("fabricanteConverter")
public class FabricanteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facescontext, UIComponent component, String value) {
		try{
			Long codigo = Long.parseLong(value);
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			Fabricante fabricante = fabricanteDAO.buscarPorCodigo(codigo);
			
			return fabricante;
		}catch(RuntimeException ex){
			return null;
		}

	}

	@Override
	public String getAsString(FacesContext facescontext, UIComponent component, Object object) {
		try{
			Fabricante fabricante = (Fabricante) object;
			Long codigo = fabricante.getCodigo();
			
			return codigo.toString();
		}catch(RuntimeException ex){
			return null;
		}
	}
}

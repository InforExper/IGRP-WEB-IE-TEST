package nosi.webapps.gestao_veiculo.pages.solicitar_page;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Solicitar_pageView extends View {

	public Field nome;
	public IGRPForm form_solicitar;


	public Solicitar_pageView(){

		this.setPageTitle("Solicitar - Page");
			
		form_solicitar = new IGRPForm("form_solicitar","Pedido");

		nome = new TextField(model,"nome");
		nome.setLabel(gt("Nome"));
		nome.propertie().add("name","p_nome").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		


		
	}
		
	@Override
	public void render(){
		
		form_solicitar.addField(nome);

		this.addToPage(form_solicitar);
	}
		
	@Override
	public void setModel(Model model) {
		
		nome.setValue(model);	

		}
}

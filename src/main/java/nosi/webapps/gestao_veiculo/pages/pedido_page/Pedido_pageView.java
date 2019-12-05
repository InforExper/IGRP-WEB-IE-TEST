package nosi.webapps.gestao_veiculo.pages.pedido_page;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Pedido_pageView extends View {

	public Field nome;
	public Field obs_pedido;
	public Field email;
	public Field telefone;
	public IGRPForm form_pedido;
	public IGRPForm form_contacto;


	public Pedido_pageView(){

		this.setPageTitle("Pedido");
			
		form_pedido = new IGRPForm("form_pedido","");

		form_contacto = new IGRPForm("form_contacto","");

		nome = new TextField(model,"nome");
		nome.setLabel(gt("Nome"));
		nome.propertie().add("name","p_nome").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		obs_pedido = new TextField(model,"obs_pedido");
		obs_pedido.setLabel(gt("Obs"));
		obs_pedido.propertie().add("name","p_obs_pedido").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		email = new EmailField(model,"email");
		email.setLabel(gt("Email"));
		email.propertie().add("name","p_email").add("type","email").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		telefone = new TextField(model,"telefone");
		telefone.setLabel(gt("Telefone"));
		telefone.propertie().add("name","p_telefone").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		


		
	}
		
	@Override
	public void render(){
		
		form_pedido.addField(nome);
		form_pedido.addField(obs_pedido);

		form_contacto.addField(email);
		form_contacto.addField(telefone);

		this.addToPage(form_pedido);
		this.addToPage(form_contacto);
	}
		
	@Override
	public void setModel(Model model) {
		
		nome.setValue(model);
		obs_pedido.setValue(model);
		email.setValue(model);
		telefone.setValue(model);	

		}
}

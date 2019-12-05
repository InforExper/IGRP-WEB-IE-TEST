package nosi.webapps.store_app.pages.pedido_page;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Pedido_pageView extends View {

	public Field justificacao;
	public Field descricao;
	public Field quantidade;
	public IGRPForm form_pedido;
	public IGRPFormList formlist_compras;


	public Pedido_pageView(){

		this.setPageTitle("Pedido Compra- Page");
			
		form_pedido = new IGRPForm("form_pedido","Pedido Compra");

		formlist_compras = new IGRPFormList("formlist_compras","Compras");

		justificacao = new TextAreaField(model,"justificacao");
		justificacao.setLabel(gt("Justificação"));
		justificacao.propertie().add("name","p_justificacao").add("type","textarea").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		descricao = new TextField(model,"descricao");
		descricao.setLabel(gt("Descrição"));
		descricao.propertie().add("name","p_descricao").add("type","text").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("desc","true");
		
		quantidade = new NumberField(model,"quantidade");
		quantidade.setLabel(gt("Quantidade"));
		quantidade.propertie().add("name","p_quantidade").add("type","number").add("min","").add("max","").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","").add("total_col","false").add("total_row","false").add("totalrow","false").add("desc","true");
		


		
	}
		
	@Override
	public void render(){
		
		form_pedido.addField(justificacao);

		formlist_compras.addField(descricao);
		formlist_compras.addField(quantidade);

		this.addToPage(form_pedido);
		this.addToPage(formlist_compras);
	}
		
	@Override
	public void setModel(Model model) {
		
		justificacao.setValue(model);
		descricao.setValue(model);
		quantidade.setValue(model);	

		formlist_compras.loadModel(((Pedido_page) model).getFormlist_compras());
		}
}

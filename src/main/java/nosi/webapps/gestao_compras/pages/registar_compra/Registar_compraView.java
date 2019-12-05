package nosi.webapps.gestao_compras.pages.registar_compra;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;
import nosi.core.webapp.Core;

public class Registar_compraView extends View {

	public Field header_text;
	public Field id_store;
	public Field date_purchase;
	public Field id_product;
	public Field price;
	public Field quantity;
	public Field total;
	public IGRPSectionHeader header;
	public IGRPForm form_1;
	public IGRPFormList formlist_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_save;

	public Registar_compraView(){

		this.setPageTitle("Registar Compra");
			
		header = new IGRPSectionHeader("header","");

		form_1 = new IGRPForm("form_1","");

		formlist_1 = new IGRPFormList("formlist_1","Lista Produto");

		header_text = new TextField(model,"header_text");
		header_text.setLabel(gt(""));
		header_text.setValue(gt("<p><span style='font-size:20px;'><span style='color:#2980b9;'><strong>New Order</strong></span></span></p>"));
		header_text.propertie().add("type","text").add("name","p_header_text").add("maxlength","4000");
		
		id_store = new ListField(model,"id_store");
		id_store.setLabel(gt("Store"));
		id_store.propertie().add("name","p_id_store").add("type","select").add("multiple","false").add("tags","false").add("domain","").add("maxlength","250").add("required","true").add("disabled","false").add("java-type","int");
		
		date_purchase = new DateField(model,"date_purchase");
		date_purchase.setLabel(gt("Order Date"));
		date_purchase.propertie().add("name","p_date_purchase").add("type","date").add("range","false").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		id_product = new ListField(model,"id_product");
		id_product.setLabel(gt("Product"));
		id_product.propertie().add("name","p_id_product").add("type","select").add("multiple","false").add("tags","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","int").add("delimiter",";").add("desc","true");
		
		price = new NumberField(model,"price");
		price.setLabel(gt("Price"));
		price.propertie().add("name","p_price").add("type","number").add("min","").add("max","").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","double").add("total_col","false").add("total_row","false").add("totalrow","false").add("desc","true");
		
		quantity = new NumberField(model,"quantity");
		quantity.setLabel(gt("Quantity"));
		quantity.propertie().add("remote",Core.getIGRPLink("gestao_compras","Registar_compra","CalTotal")).add("name","p_quantity").add("type","number").add("min","").add("max","").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","double").add("total_col","false").add("total_row","false").add("totalrow","false").add("desc","true");
		
		total = new PlainTextField(model,"total");
		total.setLabel(gt("Total"));
		total.propertie().add("name","p_total").add("type","plaintext").add("disable_output_escaping","false").add("html_class","").add("maxlength","250").add("desc","true");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_save = new IGRPButton("Save","gestao_compras","Registar_compra","save","submit","success|fa-save","","");
		btn_save.propertie.add("type","specific").add("rel","save").add("refresh_components","");

		
	}
		
	@Override
	public void render(){
		
		header.addField(header_text);


		form_1.addField(id_store);
		form_1.addField(date_purchase);

		formlist_1.addField(id_product);
		formlist_1.addField(price);
		formlist_1.addField(quantity);
		formlist_1.addField(total);

		toolsbar_1.addButton(btn_save);
		this.addToPage(header);
		this.addToPage(form_1);
		this.addToPage(formlist_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		id_store.setValue(model);
		date_purchase.setValue(model);
		id_product.setValue(model);
		price.setValue(model);
		quantity.setValue(model);
		total.setValue(model);	

		formlist_1.loadModel(((Registar_compra) model).getFormlist_1());
		}
}

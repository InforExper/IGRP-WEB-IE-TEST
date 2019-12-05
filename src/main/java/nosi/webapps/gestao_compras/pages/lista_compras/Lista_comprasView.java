package nosi.webapps.gestao_compras.pages.lista_compras;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Lista_comprasView extends View {

	public Field sectionheader_1_text;
	public Field quantidade;
	public Field obs;
	public IGRPSectionHeader sectionheader_1;
	public IGRPTable table_1;


	public Lista_comprasView(){

		this.setPageTitle("Lista Compras");
			
		sectionheader_1 = new IGRPSectionHeader("sectionheader_1","");

		table_1 = new IGRPTable("table_1","");

		sectionheader_1_text = new TextField(model,"sectionheader_1_text");
		sectionheader_1_text.setLabel(gt(""));
		sectionheader_1_text.setValue(gt("<p>Listar Compra</p>"));
		sectionheader_1_text.propertie().add("type","text").add("name","p_sectionheader_1_text").add("maxlength","4000");
		
		quantidade = new TextField(model,"quantidade");
		quantidade.setLabel(gt("Quantidade"));
		quantidade.propertie().add("name","p_quantidade").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		obs = new TextField(model,"obs");
		obs.setLabel(gt("Obs"));
		obs.propertie().add("name","p_obs").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		


		
	}
		
	@Override
	public void render(){
		
		sectionheader_1.addField(sectionheader_1_text);

		table_1.addField(quantidade);
		table_1.addField(obs);

		this.addToPage(sectionheader_1);
		this.addToPage(table_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		quantidade.setValue(model);
		obs.setValue(model);	

		table_1.loadModel(((Lista_compras) model).getTable_1());
		}
}

package nosi.webapps.gestao_compras.pages.registar_produto;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Registar_produtoView extends View {

	public Field sectionheader_1_text;
	public Field description;
	public Field reference;
	public IGRPSectionHeader sectionheader_1;
	public IGRPFormList produtos;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_save;

	public Registar_produtoView(){

		this.setPageTitle("Registar Produto");
			
		sectionheader_1 = new IGRPSectionHeader("sectionheader_1","");

		produtos = new IGRPFormList("produtos","");

		sectionheader_1_text = new TextField(model,"sectionheader_1_text");
		sectionheader_1_text.setLabel(gt(""));
		sectionheader_1_text.setValue(gt("<p>Regista Produto</p>"));
		sectionheader_1_text.propertie().add("type","text").add("name","p_sectionheader_1_text").add("maxlength","4000");
		
		description = new TextField(model,"description");
		description.setLabel(gt("Description"));
		description.propertie().add("name","p_description").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("desc","true");
		
		reference = new TextField(model,"reference");
		reference.setLabel(gt("Reference"));
		reference.propertie().add("name","p_reference").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("desc","true");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_save = new IGRPButton("Save","gestao_compras","Registar_produto","save","submit","success|fa-save","","");
		btn_save.propertie.add("type","specific").add("rel","save").add("refresh_components","");

		
		
		
	}
		
	@Override
	public void render(){
		
		sectionheader_1.addField(sectionheader_1_text);


		produtos.addField(description);
		produtos.addField(reference);

		toolsbar_1.addButton(btn_save);
		this.addToPage(sectionheader_1);
		this.addToPage(produtos);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		description.setValue(model);
		reference.setValue(model);	

		produtos.loadModel(((Registar_produto) model).getProdutos());
		}
}

package nosi.webapps.gestao_veiculo.pages.veiculos_lista;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Veiculos_listaView extends View {

	public Field sectionheader_1_text;
	public IGRPSectionHeader sectionheader_1;


	public Veiculos_listaView(){

		this.setPageTitle("Veículos - Lista");
			
		sectionheader_1 = new IGRPSectionHeader("sectionheader_1","");

		sectionheader_1_text = new TextField(model,"sectionheader_1_text");
		sectionheader_1_text.setLabel(gt(""));
		sectionheader_1_text.setValue(gt("Sectionheader"));
		sectionheader_1_text.propertie().add("type","text").add("name","p_sectionheader_1_text").add("maxlength","4000");
		


		
	}
		
	@Override
	public void render(){
		
		sectionheader_1.addField(sectionheader_1_text);

		this.addToPage(sectionheader_1);
	}
		
	@Override
	public void setModel(Model model) {
			

		}
}

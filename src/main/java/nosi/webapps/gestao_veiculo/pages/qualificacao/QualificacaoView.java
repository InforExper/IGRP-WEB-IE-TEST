package nosi.webapps.gestao_veiculo.pages.qualificacao;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class QualificacaoView extends View {

	public Field aprovacao;
	public Field obs;
	public IGRPForm form_qualificacao;


	public QualificacaoView(){

		this.setPageTitle("Qualificação - Page");
			
		form_qualificacao = new IGRPForm("form_qualificacao","");

		aprovacao = new ListField(model,"aprovacao");
		aprovacao.setLabel(gt("Aprovação"));
		aprovacao.propertie().add("name","p_aprovacao").add("type","select").add("multiple","false").add("tags","false").add("domain","VEICULO_SIM_NAO « gestao_veiculo").add("maxlength","250").add("required","true").add("disabled","false").add("java-type","String");
		
		obs = new TextAreaField(model,"obs");
		obs.setLabel(gt("Obs"));
		obs.propertie().add("name","p_obs").add("type","textarea").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		


		
	}
		
	@Override
	public void render(){
		
		form_qualificacao.addField(aprovacao);
		form_qualificacao.addField(obs);

		this.addToPage(form_qualificacao);
	}
		
	@Override
	public void setModel(Model model) {
		
		aprovacao.setValue(model);
		obs.setValue(model);	

		}
}

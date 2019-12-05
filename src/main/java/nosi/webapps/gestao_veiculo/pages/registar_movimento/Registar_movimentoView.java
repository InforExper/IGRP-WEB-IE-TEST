package nosi.webapps.gestao_veiculo.pages.registar_movimento;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Registar_movimentoView extends View {

	public Field header_text;
	public Field condutor;
	public Field veiculo;
	public Field data_saida;
	public Field hora;
	public Field km_saida;
	public Field id_condutor;
	public IGRPSectionHeader header;
	public IGRPForm form_mov;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_save;

	public Registar_movimentoView(){

		this.setPageTitle("Registar Movimento");
			
		header = new IGRPSectionHeader("header","");

		form_mov = new IGRPForm("form_mov","Dados de Movimento");

		header_text = new TextField(model,"header_text");
		header_text.setLabel(gt(""));
		header_text.setValue(gt("<p><strong>Movimento -&nbsp;</strong> Entradas e Saidas</p>"));
		header_text.propertie().add("type","text").add("name","p_header_text").add("maxlength","4000");
		
		condutor = new LookupField(model,"condutor");
		condutor.setLabel(gt("Condutor"));
		condutor.setLookup("gestao_veiculo","Pesquisa_condutor","index");
		condutor.addParam("target","_blank");
		condutor.addLookupParam("p_condutor","nome");
		condutor.addLookupParam("p_id_condutor","id_condutor");
		condutor.propertie().add("name","p_condutor").add("type","lookup").add("lookup_eraser","false").add("lookup_type","LOOKUP").add("maxlength","250").add("required","true").add("readonly","true").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		veiculo = new ListField(model,"veiculo");
		veiculo.setLabel(gt("Veículo"));
		veiculo.propertie().add("name","p_veiculo").add("type","select").add("multiple","false").add("tags","false").add("domain","").add("maxlength","250").add("required","true").add("disabled","false").add("java-type","String");
		
		data_saida = new DateField(model,"data_saida");
		data_saida.setLabel(gt("Data Saída"));
		data_saida.propertie().add("name","p_data_saida").add("type","date").add("range","false").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		hora = new TextField(model,"hora");
		hora.setLabel(gt("Hora"));
		hora.propertie().add("name","p_hora").add("type","time").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		km_saida = new NumberField(model,"km_saida");
		km_saida.setLabel(gt("KM Saída"));
		km_saida.propertie().add("name","p_km_saida").add("type","number").add("min","").add("max","").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","double");
		
		id_condutor = new HiddenField(model,"id_condutor");
		id_condutor.setLabel(gt(""));
		id_condutor.propertie().add("name","p_id_condutor").add("type","hidden").add("maxlength","250").add("java-type","").add("tag","id_condutor");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_save = new IGRPButton("Save","gestao_veiculo","Registar_movimento","save","submit","success|fa-save","","");
		btn_save.propertie.add("type","specific").add("rel","save").add("refresh_components","");

		
	}
		
	@Override
	public void render(){
		
		header.addField(header_text);


		form_mov.addField(condutor);
		form_mov.addField(veiculo);
		form_mov.addField(data_saida);
		form_mov.addField(hora);
		form_mov.addField(km_saida);
		form_mov.addField(id_condutor);

		toolsbar_1.addButton(btn_save);
		this.addToPage(header);
		this.addToPage(form_mov);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		condutor.setValue(model);
		veiculo.setValue(model);
		data_saida.setValue(model);
		hora.setValue(model);
		km_saida.setValue(model);
		id_condutor.setValue(model);	

		}
}

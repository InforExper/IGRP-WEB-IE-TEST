package nosi.webapps.gestao_veiculo.pages.pesquisa_condutor;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Pesquisa_condutorView extends View {

	public Field nome_search;
	public Field carta_conducao_search;
	public Field cni_search;
	public Field nome;
	public Field cni;
	public Field carta_conducao;
	public Field id_condutor;
	public IGRPForm form_1;
	public IGRPTable table_condutor;

	public IGRPButton btn_pesquisar;

	public Pesquisa_condutorView(){

		this.setPageTitle("Pesquisa Condutor");
			
		form_1 = new IGRPForm("form_1","");

		table_condutor = new IGRPTable("table_condutor","Condutores");

		nome_search = new TextField(model,"nome_search");
		nome_search.setLabel(gt("Nome"));
		nome_search.propertie().add("name","p_nome_search").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		carta_conducao_search = new TextField(model,"carta_conducao_search");
		carta_conducao_search.setLabel(gt("Nº Carta Condução"));
		carta_conducao_search.propertie().add("name","p_carta_conducao_search").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("S-002")).add("desclabel","false");
		
		cni_search = new TextField(model,"cni_search");
		cni_search.setLabel(gt("CNI"));
		cni_search.propertie().add("name","p_cni_search").add("type","text").add("maxlength","30").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("28021992-F002")).add("desclabel","false");
		
		nome = new TextField(model,"nome");
		nome.setLabel(gt("Nome"));
		nome.propertie().add("name","p_nome").add("type","text").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		cni = new TextField(model,"cni");
		cni.setLabel(gt("CNI"));
		cni.propertie().add("name","p_cni").add("type","text").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		carta_conducao = new TextField(model,"carta_conducao");
		carta_conducao.setLabel(gt("Carta Condução"));
		carta_conducao.propertie().add("name","p_carta_conducao").add("type","text").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		id_condutor = new HiddenField(model,"id_condutor");
		id_condutor.setLabel(gt(""));
		id_condutor.propertie().add("name","p_id_condutor").add("type","hidden").add("maxlength","30").add("showLabel","true").add("group_in","").add("java-type","int").add("tag","id_condutor");
		


		btn_pesquisar = new IGRPButton("Pesquisar","gestao_veiculo","Pesquisa_condutor","pesquisar","submit_form","info|fa-search","","");
		btn_pesquisar.propertie.add("type","form").add("rel","pesquisar").add("refresh_components","");

		
	}
		
	@Override
	public void render(){
		
		form_1.addField(nome_search);
		form_1.addField(carta_conducao_search);
		form_1.addField(cni_search);

		table_condutor.addField(nome);
		table_condutor.addField(cni);
		table_condutor.addField(carta_conducao);
		table_condutor.addField(id_condutor);

		form_1.addButton(btn_pesquisar);
		this.addToPage(form_1);
		this.addToPage(table_condutor);
	}
		
	@Override
	public void setModel(Model model) {
		
		nome_search.setValue(model);
		carta_conducao_search.setValue(model);
		cni_search.setValue(model);
		nome.setValue(model);
		cni.setValue(model);
		carta_conducao.setValue(model);
		id_condutor.setValue(model);	

		table_condutor.loadModel(((Pesquisa_condutor) model).getTable_condutor());
		}
}

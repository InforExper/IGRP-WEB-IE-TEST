package nosi.webapps.gestao_veiculo.pages.dashboard;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;
import nosi.core.webapp.Core;

public class DashboardView extends View {

	public Field form_1_date_1;
	public Field matricula_filter;
	public Field box_viculo_rua_porcento_title;
	public Field box_viculo_rua_porcento_lbl;
	public Field box_viculo_rua_porcento_val;
	public Field box_viculo_rua_porcento_desc;
	public Field box_viculo_rua_porcento_url;
	public Field box_viculo_rua_porcento_bg;
	public Field box_condutor_rua_title;
	public Field box_condutor_rua_val;
	public Field box_condutor_rua_url;
	public Field box_condutor_rua_bg;
	public Field box_condutor_rua_icn;
	public Field box_total_condutor_title;
	public Field box_total_condutor_val;
	public Field box_total_condutor_url;
	public Field box_total_condutor_lbl;
	public Field box_total_condutor_bg;
	public Field box_total_condutor_icn;
	public Field box_veiculo_km_50_title;
	public Field box_veiculo_km_50_val;
	public Field box_veiculo_km_50_txt;
	public Field box_veiculo_km_50_url;
	public Field box_veiculo_km_50_bg;
	public Field box_veiculo_km_50_icn;
	public IGRPForm form_1;
	public IGRPChart chart_evolucao_movimento;
	public IGRPChart chart_veiculo_saida;
	public IGRPChart chart_condutor_saida;
	public IGRPCircleStatBox box_viculo_rua_porcento;
	public IGRPQuickButtonBox box_condutor_rua;
	public IGRPSmallBox box_total_condutor;
	public IGRPStatBox box_veiculo_km_50;

	public IGRPButton btn_pesquisar;
	public IGRPButton btn_report;

	public DashboardView(){

		this.setPageTitle("Dashboard");
			
		form_1 = new IGRPForm("form_1","");

		chart_evolucao_movimento = new IGRPChart("chart_evolucao_movimento","Evolução de Movimento");

		chart_veiculo_saida = new IGRPChart("chart_veiculo_saida","Saida Por Veículo");

		chart_condutor_saida = new IGRPChart("chart_condutor_saida","Condutor com mais saidas");

		box_viculo_rua_porcento = new IGRPCircleStatBox("box_viculo_rua_porcento","");

		box_condutor_rua = new IGRPQuickButtonBox("box_condutor_rua","");

		box_total_condutor = new IGRPSmallBox("box_total_condutor","");

		box_veiculo_km_50 = new IGRPStatBox("box_veiculo_km_50","");

		form_1_date_1 = new DateField(model,"form_1_date_1");
		form_1_date_1.setLabel(gt("Date"));
		form_1_date_1.propertie().add("name","p_form_1_date_1").add("type","date").add("range","false").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		matricula_filter = new TextField(model,"matricula_filter");
		matricula_filter.setLabel(gt("Matricula"));
		matricula_filter.propertie().add("name","p_matricula_filter").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false");
		
		box_viculo_rua_porcento_title = new TextField(model,"box_viculo_rua_porcento_title");
		box_viculo_rua_porcento_title.setLabel(gt("Circle Box Title"));
		box_viculo_rua_porcento_title.propertie().add("name","p_box_viculo_rua_porcento_title").add("type","text").add("maxlength","4000");
		
		box_viculo_rua_porcento_lbl = new TextField(model,"box_viculo_rua_porcento_lbl");
		box_viculo_rua_porcento_lbl.setLabel(gt("Percent Text"));
		box_viculo_rua_porcento_lbl.propertie().add("name","p_box_viculo_rua_porcento_lbl").add("type","text").add("maxlength","4000");
		
		box_viculo_rua_porcento_val = new TextField(model,"box_viculo_rua_porcento_val");
		box_viculo_rua_porcento_val.setLabel(gt("Percent Value"));
		box_viculo_rua_porcento_val.propertie().add("name","p_box_viculo_rua_porcento_val").add("type","text").add("maxlength","4000");
		
		box_viculo_rua_porcento_desc = new TextField(model,"box_viculo_rua_porcento_desc");
		box_viculo_rua_porcento_desc.setLabel(gt("Description"));
		box_viculo_rua_porcento_desc.propertie().add("name","p_box_viculo_rua_porcento_desc").add("type","text").add("maxlength","4000");
		
		box_viculo_rua_porcento_url = new TextField(model,"box_viculo_rua_porcento_url");
		box_viculo_rua_porcento_url.setLabel(gt("Link"));
		box_viculo_rua_porcento_url.propertie().add("name","p_box_viculo_rua_porcento_url").add("type","text").add("maxlength","4000");
		
		box_viculo_rua_porcento_bg = new TextField(model,"box_viculo_rua_porcento_bg");
		box_viculo_rua_porcento_bg.setLabel(gt("Background"));
		box_viculo_rua_porcento_bg.propertie().add("name","p_box_viculo_rua_porcento_bg").add("type","text").add("maxlength","4000");
		
		box_condutor_rua_title = new TextField(model,"box_condutor_rua_title");
		box_condutor_rua_title.setLabel(gt("Title"));
		box_condutor_rua_title.propertie().add("name","p_box_condutor_rua_title").add("type","text").add("maxlength","4000");
		
		box_condutor_rua_val = new TextField(model,"box_condutor_rua_val");
		box_condutor_rua_val.setLabel(gt("Value"));
		box_condutor_rua_val.propertie().add("name","p_box_condutor_rua_val").add("type","text").add("maxlength","4000");
		
		box_condutor_rua_url = new LinkField(model,"box_condutor_rua_url");
		box_condutor_rua_url.setLabel(gt(""));
		box_condutor_rua_url.setValue(Core.getIGRPLink("gestao_veiculo","Veiculos_lista","index"));
		box_condutor_rua_url.propertie().add("name","p_box_condutor_rua_url").add("type","link").add("maxlength","4000");
		
		box_condutor_rua_bg = new TextField(model,"box_condutor_rua_bg");
		box_condutor_rua_bg.setLabel(gt("Background"));
		box_condutor_rua_bg.propertie().add("name","p_box_condutor_rua_bg").add("type","text").add("maxlength","4000");
		
		box_condutor_rua_icn = new TextField(model,"box_condutor_rua_icn");
		box_condutor_rua_icn.setLabel(gt("Icon"));
		box_condutor_rua_icn.propertie().add("name","p_box_condutor_rua_icn").add("type","text").add("maxlength","4000");
		
		box_total_condutor_title = new TextField(model,"box_total_condutor_title");
		box_total_condutor_title.setLabel(gt("Small Box Title"));
		box_total_condutor_title.propertie().add("name","p_box_total_condutor_title").add("type","text").add("maxlength","4000");
		
		box_total_condutor_val = new TextField(model,"box_total_condutor_val");
		box_total_condutor_val.setLabel(gt("Value"));
		box_total_condutor_val.propertie().add("name","p_box_total_condutor_val").add("type","text").add("maxlength","4000");
		
		box_total_condutor_url = new TextField(model,"box_total_condutor_url");
		box_total_condutor_url.setLabel(gt("Url"));
		box_total_condutor_url.propertie().add("name","p_box_total_condutor_url").add("type","text").add("maxlength","4000");
		
		box_total_condutor_lbl = new TextField(model,"box_total_condutor_lbl");
		box_total_condutor_lbl.setLabel(gt("Url label"));
		box_total_condutor_lbl.propertie().add("name","p_box_total_condutor_lbl").add("type","text").add("maxlength","4000");
		
		box_total_condutor_bg = new TextField(model,"box_total_condutor_bg");
		box_total_condutor_bg.setLabel(gt("Background"));
		box_total_condutor_bg.propertie().add("name","p_box_total_condutor_bg").add("type","text").add("maxlength","4000");
		
		box_total_condutor_icn = new TextField(model,"box_total_condutor_icn");
		box_total_condutor_icn.setLabel(gt("Icon"));
		box_total_condutor_icn.propertie().add("name","p_box_total_condutor_icn").add("type","text").add("maxlength","4000");
		
		box_veiculo_km_50_title = new TextField(model,"box_veiculo_km_50_title");
		box_veiculo_km_50_title.setLabel(gt("Box Title"));
		box_veiculo_km_50_title.propertie().add("name","p_box_veiculo_km_50_title").add("type","text").add("maxlength","4000");
		
		box_veiculo_km_50_val = new TextField(model,"box_veiculo_km_50_val");
		box_veiculo_km_50_val.setLabel(gt("Value"));
		box_veiculo_km_50_val.propertie().add("name","p_box_veiculo_km_50_val").add("type","text").add("maxlength","4000");
		
		box_veiculo_km_50_txt = new TextField(model,"box_veiculo_km_50_txt");
		box_veiculo_km_50_txt.setLabel(gt("Url Text"));
		box_veiculo_km_50_txt.propertie().add("name","p_box_veiculo_km_50_txt").add("type","text").add("maxlength","4000");
		
		box_veiculo_km_50_url = new TextField(model,"box_veiculo_km_50_url");
		box_veiculo_km_50_url.setLabel(gt("Url"));
		box_veiculo_km_50_url.propertie().add("name","p_box_veiculo_km_50_url").add("type","text").add("maxlength","4000");
		
		box_veiculo_km_50_bg = new TextField(model,"box_veiculo_km_50_bg");
		box_veiculo_km_50_bg.setLabel(gt("Background"));
		box_veiculo_km_50_bg.propertie().add("name","p_box_veiculo_km_50_bg").add("type","text").add("maxlength","4000");
		
		box_veiculo_km_50_icn = new TextField(model,"box_veiculo_km_50_icn");
		box_veiculo_km_50_icn.setLabel(gt("Icon"));
		box_veiculo_km_50_icn.setValue(gt("fa-dashboard"));
		box_veiculo_km_50_icn.propertie().add("name","p_box_veiculo_km_50_icn").add("type","text").add("maxlength","4000");
		


		btn_pesquisar = new IGRPButton("Pesquisar","gestao_veiculo","Dashboard","pesquisar","submit_form","primary|fa-search","","");
		btn_pesquisar.propertie.add("type","form").add("rel","pesquisar").add("refresh_components","");

		btn_report = new IGRPButton("Report","gestao_veiculo","Dashboard","report","submit_popup","danger|fa-file-pdf-o","","");
		btn_report.propertie.add("type","form").add("rel","report").add("refresh_components","");

		
		chart_evolucao_movimento.setCaption("");
		chart_evolucao_movimento.setChart_type("line");
		chart_evolucao_movimento.setXaxys("Eixo de X");
		chart_evolucao_movimento.setYaxys("Eixo de Y");
		chart_evolucao_movimento.setUrl("#");
		chart_evolucao_movimento.addColor("#230e5b").addColor("#18f005").addColor("#8b696a").addColor("#6ad5ec");

		chart_veiculo_saida.setCaption("");
		chart_veiculo_saida.setChart_type("pie");
		chart_veiculo_saida.setXaxys("Eixo de X");
		chart_veiculo_saida.setYaxys("Eixo de Y");
		chart_veiculo_saida.setUrl("#");
		chart_veiculo_saida.addColor("#7b0547").addColor("#6c1de6").addColor("#335edf").addColor("#cb9ee9");

		chart_condutor_saida.setCaption("");
		chart_condutor_saida.setChart_type("column");
		chart_condutor_saida.setXaxys("Eixo de X");
		chart_condutor_saida.setYaxys("Eixo de Y");
		chart_condutor_saida.setUrl("#");
		chart_condutor_saida.addColor("#f50297").addColor("#76b10f").addColor("#d60726").addColor("#42cf98");

	}
		
	@Override
	public void render(){
		
		form_1.addField(form_1_date_1);
		form_1.addField(matricula_filter);




		box_viculo_rua_porcento.addField(box_viculo_rua_porcento_title);
		box_viculo_rua_porcento.addField(box_viculo_rua_porcento_lbl);
		box_viculo_rua_porcento.addField(box_viculo_rua_porcento_val);
		box_viculo_rua_porcento.addField(box_viculo_rua_porcento_desc);
		box_viculo_rua_porcento.addField(box_viculo_rua_porcento_url);
		box_viculo_rua_porcento.addField(box_viculo_rua_porcento_bg);

		box_condutor_rua.addField(box_condutor_rua_title);
		box_condutor_rua.addField(box_condutor_rua_val);
		box_condutor_rua.addField(box_condutor_rua_url);
		box_condutor_rua.addField(box_condutor_rua_bg);
		box_condutor_rua.addField(box_condutor_rua_icn);

		box_total_condutor.addField(box_total_condutor_title);
		box_total_condutor.addField(box_total_condutor_val);
		box_total_condutor.addField(box_total_condutor_url);
		box_total_condutor.addField(box_total_condutor_lbl);
		box_total_condutor.addField(box_total_condutor_bg);
		box_total_condutor.addField(box_total_condutor_icn);

		box_veiculo_km_50.addField(box_veiculo_km_50_title);
		box_veiculo_km_50.addField(box_veiculo_km_50_val);
		box_veiculo_km_50.addField(box_veiculo_km_50_txt);
		box_veiculo_km_50.addField(box_veiculo_km_50_url);
		box_veiculo_km_50.addField(box_veiculo_km_50_bg);
		box_veiculo_km_50.addField(box_veiculo_km_50_icn);

		form_1.addButton(btn_pesquisar);
		form_1.addButton(btn_report);
		this.addToPage(form_1);
		this.addToPage(chart_evolucao_movimento);
		this.addToPage(chart_veiculo_saida);
		this.addToPage(chart_condutor_saida);
		this.addToPage(box_viculo_rua_porcento);
		this.addToPage(box_condutor_rua);
		this.addToPage(box_total_condutor);
		this.addToPage(box_veiculo_km_50);
	}
		
	@Override
	public void setModel(Model model) {
		
		form_1_date_1.setValue(model);
		matricula_filter.setValue(model);
		box_viculo_rua_porcento_title.setValue(model);
		box_viculo_rua_porcento_lbl.setValue(model);
		box_viculo_rua_porcento_val.setValue(model);
		box_viculo_rua_porcento_desc.setValue(model);
		box_viculo_rua_porcento_url.setValue(model);
		box_viculo_rua_porcento_bg.setValue(model);
		box_condutor_rua_title.setValue(model);
		box_condutor_rua_val.setValue(model);
		box_condutor_rua_bg.setValue(model);
		box_condutor_rua_icn.setValue(model);
		box_total_condutor_title.setValue(model);
		box_total_condutor_val.setValue(model);
		box_total_condutor_url.setValue(model);
		box_total_condutor_lbl.setValue(model);
		box_total_condutor_bg.setValue(model);
		box_total_condutor_icn.setValue(model);
		box_veiculo_km_50_title.setValue(model);
		box_veiculo_km_50_val.setValue(model);
		box_veiculo_km_50_txt.setValue(model);
		box_veiculo_km_50_url.setValue(model);
		box_veiculo_km_50_bg.setValue(model);	

		chart_evolucao_movimento.loadModel(((Dashboard) model).getChart_evolucao_movimento());
		chart_veiculo_saida.loadModel(((Dashboard) model).getChart_veiculo_saida());
		chart_condutor_saida.loadModel(((Dashboard) model).getChart_condutor_saida());
		}
}

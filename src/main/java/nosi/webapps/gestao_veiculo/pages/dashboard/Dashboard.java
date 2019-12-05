package nosi.webapps.gestao_veiculo.pages.dashboard;

import nosi.core.gui.components.IGRPLink;
import nosi.core.webapp.Report;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import java.util.ArrayList;
import java.util.List;
import nosi.core.gui.components.IGRPChart2D;
import nosi.core.gui.components.IGRPChart3D;

public class Dashboard extends Model{		

	@RParam(rParamName = "p_form_1_date_1")
	private String form_1_date_1;

	@RParam(rParamName = "p_matricula_filter")
	private String matricula_filter;

	@RParam(rParamName = "p_box_viculo_rua_porcento_title")
	private String box_viculo_rua_porcento_title;

	@RParam(rParamName = "p_box_viculo_rua_porcento_lbl")
	private String box_viculo_rua_porcento_lbl;

	@RParam(rParamName = "p_box_viculo_rua_porcento_val")
	private String box_viculo_rua_porcento_val;

	@RParam(rParamName = "p_box_viculo_rua_porcento_desc")
	private String box_viculo_rua_porcento_desc;

	@RParam(rParamName = "p_box_viculo_rua_porcento_url")
	private String box_viculo_rua_porcento_url;

	@RParam(rParamName = "p_box_viculo_rua_porcento_bg")
	private String box_viculo_rua_porcento_bg;

	@RParam(rParamName = "p_box_condutor_rua_title")
	private String box_condutor_rua_title;

	@RParam(rParamName = "p_box_condutor_rua_val")
	private String box_condutor_rua_val;

	@RParam(rParamName = "p_box_condutor_rua_url")
	private IGRPLink box_condutor_rua_url;
	@RParam(rParamName = "p_box_condutor_rua_url_desc")
	private String box_condutor_rua_url_desc;

	@RParam(rParamName = "p_box_condutor_rua_bg")
	private String box_condutor_rua_bg;

	@RParam(rParamName = "p_box_condutor_rua_icn")
	private String box_condutor_rua_icn;

	@RParam(rParamName = "p_box_total_condutor_title")
	private String box_total_condutor_title;

	@RParam(rParamName = "p_box_total_condutor_val")
	private String box_total_condutor_val;

	@RParam(rParamName = "p_box_total_condutor_url")
	private String box_total_condutor_url;

	@RParam(rParamName = "p_box_total_condutor_lbl")
	private String box_total_condutor_lbl;

	@RParam(rParamName = "p_box_total_condutor_bg")
	private String box_total_condutor_bg;

	@RParam(rParamName = "p_box_total_condutor_icn")
	private String box_total_condutor_icn;

	@RParam(rParamName = "p_box_veiculo_km_50_title")
	private String box_veiculo_km_50_title;

	@RParam(rParamName = "p_box_veiculo_km_50_val")
	private String box_veiculo_km_50_val;

	@RParam(rParamName = "p_box_veiculo_km_50_txt")
	private String box_veiculo_km_50_txt;

	@RParam(rParamName = "p_box_veiculo_km_50_url")
	private String box_veiculo_km_50_url;

	@RParam(rParamName = "p_box_veiculo_km_50_bg")
	private String box_veiculo_km_50_bg;

	@RParam(rParamName = "p_box_veiculo_km_50_icn")
	private String box_veiculo_km_50_icn;
	
	private List<Chart_evolucao_movimento> chart_evolucao_movimento = new ArrayList<>();	
	public void setChart_evolucao_movimento(List<Chart_evolucao_movimento> chart_evolucao_movimento){
		this.chart_evolucao_movimento = chart_evolucao_movimento;
	}
	public List<Chart_evolucao_movimento> getChart_evolucao_movimento(){
		return this.chart_evolucao_movimento;
	}

	
	private List<Chart_veiculo_saida> chart_veiculo_saida = new ArrayList<>();	
	public void setChart_veiculo_saida(List<Chart_veiculo_saida> chart_veiculo_saida){
		this.chart_veiculo_saida = chart_veiculo_saida;
	}
	public List<Chart_veiculo_saida> getChart_veiculo_saida(){
		return this.chart_veiculo_saida;
	}

	
	private List<Chart_condutor_saida> chart_condutor_saida = new ArrayList<>();	
	public void setChart_condutor_saida(List<Chart_condutor_saida> chart_condutor_saida){
		this.chart_condutor_saida = chart_condutor_saida;
	}
	public List<Chart_condutor_saida> getChart_condutor_saida(){
		return this.chart_condutor_saida;
	}

	
	public void setForm_1_date_1(String form_1_date_1){
		this.form_1_date_1 = form_1_date_1;
	}
	public String getForm_1_date_1(){
		return this.form_1_date_1;
	}
	
	public void setMatricula_filter(String matricula_filter){
		this.matricula_filter = matricula_filter;
	}
	public String getMatricula_filter(){
		return this.matricula_filter;
	}
	
	public void setBox_viculo_rua_porcento_title(String box_viculo_rua_porcento_title){
		this.box_viculo_rua_porcento_title = box_viculo_rua_porcento_title;
	}
	public String getBox_viculo_rua_porcento_title(){
		return this.box_viculo_rua_porcento_title;
	}
	
	public void setBox_viculo_rua_porcento_lbl(String box_viculo_rua_porcento_lbl){
		this.box_viculo_rua_porcento_lbl = box_viculo_rua_porcento_lbl;
	}
	public String getBox_viculo_rua_porcento_lbl(){
		return this.box_viculo_rua_porcento_lbl;
	}
	
	public void setBox_viculo_rua_porcento_val(String box_viculo_rua_porcento_val){
		this.box_viculo_rua_porcento_val = box_viculo_rua_porcento_val;
	}
	public String getBox_viculo_rua_porcento_val(){
		return this.box_viculo_rua_porcento_val;
	}
	
	public void setBox_viculo_rua_porcento_desc(String box_viculo_rua_porcento_desc){
		this.box_viculo_rua_porcento_desc = box_viculo_rua_porcento_desc;
	}
	public String getBox_viculo_rua_porcento_desc(){
		return this.box_viculo_rua_porcento_desc;
	}
	
	public void setBox_viculo_rua_porcento_url(String box_viculo_rua_porcento_url){
		this.box_viculo_rua_porcento_url = box_viculo_rua_porcento_url;
	}
	public String getBox_viculo_rua_porcento_url(){
		return this.box_viculo_rua_porcento_url;
	}
	
	public void setBox_viculo_rua_porcento_bg(String box_viculo_rua_porcento_bg){
		this.box_viculo_rua_porcento_bg = box_viculo_rua_porcento_bg;
	}
	public String getBox_viculo_rua_porcento_bg(){
		return this.box_viculo_rua_porcento_bg;
	}
	
	public void setBox_condutor_rua_title(String box_condutor_rua_title){
		this.box_condutor_rua_title = box_condutor_rua_title;
	}
	public String getBox_condutor_rua_title(){
		return this.box_condutor_rua_title;
	}
	
	public void setBox_condutor_rua_val(String box_condutor_rua_val){
		this.box_condutor_rua_val = box_condutor_rua_val;
	}
	public String getBox_condutor_rua_val(){
		return this.box_condutor_rua_val;
	}
	
	public IGRPLink setBox_condutor_rua_url(String app,String page,String action){
		this.box_condutor_rua_url = new IGRPLink(app,page,action);
		return this.box_condutor_rua_url;
	}
	public IGRPLink getBox_condutor_rua_url(){
		return this.box_condutor_rua_url;
	}
	public void setBox_condutor_rua_url_desc(String box_condutor_rua_url_desc){
		this.box_condutor_rua_url_desc = box_condutor_rua_url_desc;
	}
	public String getBox_condutor_rua_url_desc(){
		return this.box_condutor_rua_url_desc;
	}
	public IGRPLink setBox_condutor_rua_url(String link){
		this.box_condutor_rua_url = new IGRPLink(link);
		return this.box_condutor_rua_url;
	}
	public IGRPLink setBox_condutor_rua_url(Report link){
		this.box_condutor_rua_url = new IGRPLink(link);
		return this.box_condutor_rua_url;
	}
	
	public void setBox_condutor_rua_bg(String box_condutor_rua_bg){
		this.box_condutor_rua_bg = box_condutor_rua_bg;
	}
	public String getBox_condutor_rua_bg(){
		return this.box_condutor_rua_bg;
	}
	
	public void setBox_condutor_rua_icn(String box_condutor_rua_icn){
		this.box_condutor_rua_icn = box_condutor_rua_icn;
	}
	public String getBox_condutor_rua_icn(){
		return this.box_condutor_rua_icn;
	}
	
	public void setBox_total_condutor_title(String box_total_condutor_title){
		this.box_total_condutor_title = box_total_condutor_title;
	}
	public String getBox_total_condutor_title(){
		return this.box_total_condutor_title;
	}
	
	public void setBox_total_condutor_val(String box_total_condutor_val){
		this.box_total_condutor_val = box_total_condutor_val;
	}
	public String getBox_total_condutor_val(){
		return this.box_total_condutor_val;
	}
	
	public void setBox_total_condutor_url(String box_total_condutor_url){
		this.box_total_condutor_url = box_total_condutor_url;
	}
	public String getBox_total_condutor_url(){
		return this.box_total_condutor_url;
	}
	
	public void setBox_total_condutor_lbl(String box_total_condutor_lbl){
		this.box_total_condutor_lbl = box_total_condutor_lbl;
	}
	public String getBox_total_condutor_lbl(){
		return this.box_total_condutor_lbl;
	}
	
	public void setBox_total_condutor_bg(String box_total_condutor_bg){
		this.box_total_condutor_bg = box_total_condutor_bg;
	}
	public String getBox_total_condutor_bg(){
		return this.box_total_condutor_bg;
	}
	
	public void setBox_total_condutor_icn(String box_total_condutor_icn){
		this.box_total_condutor_icn = box_total_condutor_icn;
	}
	public String getBox_total_condutor_icn(){
		return this.box_total_condutor_icn;
	}
	
	public void setBox_veiculo_km_50_title(String box_veiculo_km_50_title){
		this.box_veiculo_km_50_title = box_veiculo_km_50_title;
	}
	public String getBox_veiculo_km_50_title(){
		return this.box_veiculo_km_50_title;
	}
	
	public void setBox_veiculo_km_50_val(String box_veiculo_km_50_val){
		this.box_veiculo_km_50_val = box_veiculo_km_50_val;
	}
	public String getBox_veiculo_km_50_val(){
		return this.box_veiculo_km_50_val;
	}
	
	public void setBox_veiculo_km_50_txt(String box_veiculo_km_50_txt){
		this.box_veiculo_km_50_txt = box_veiculo_km_50_txt;
	}
	public String getBox_veiculo_km_50_txt(){
		return this.box_veiculo_km_50_txt;
	}
	
	public void setBox_veiculo_km_50_url(String box_veiculo_km_50_url){
		this.box_veiculo_km_50_url = box_veiculo_km_50_url;
	}
	public String getBox_veiculo_km_50_url(){
		return this.box_veiculo_km_50_url;
	}
	
	public void setBox_veiculo_km_50_bg(String box_veiculo_km_50_bg){
		this.box_veiculo_km_50_bg = box_veiculo_km_50_bg;
	}
	public String getBox_veiculo_km_50_bg(){
		return this.box_veiculo_km_50_bg;
	}
	
	public void setBox_veiculo_km_50_icn(String box_veiculo_km_50_icn){
		this.box_veiculo_km_50_icn = box_veiculo_km_50_icn;
	}
	public String getBox_veiculo_km_50_icn(){
		return this.box_veiculo_km_50_icn;
	}


	public static class Chart_evolucao_movimento extends IGRPChart3D{
		public Chart_evolucao_movimento(String eixoX, String eixoY, Object eixoZ) {
			super(eixoX, eixoY,eixoZ);
		}
		public Chart_evolucao_movimento() {
		}
	}
	public static class Chart_veiculo_saida extends IGRPChart2D{
		public Chart_veiculo_saida(String eixoX, Object eixoY) {
			super(eixoX, eixoY);
		}
		public Chart_veiculo_saida() {
		}
	}
	public static class Chart_condutor_saida extends IGRPChart3D{
		public Chart_condutor_saida(String eixoX, String eixoY, Object eixoZ) {
			super(eixoX, eixoY,eixoZ);
		}
		public Chart_condutor_saida() {
		}
	}

	public void loadChart_evolucao_movimento(BaseQueryInterface query) {
		this.setChart_evolucao_movimento(this.loadTable(query,Chart_evolucao_movimento.class));
	}

	public void loadChart_veiculo_saida(BaseQueryInterface query) {
		this.setChart_veiculo_saida(this.loadTable(query,Chart_veiculo_saida.class));
	}

	public void loadChart_condutor_saida(BaseQueryInterface query) {
		this.setChart_condutor_saida(this.loadTable(query,Chart_condutor_saida.class));
	}

}

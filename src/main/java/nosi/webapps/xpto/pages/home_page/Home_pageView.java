package nosi.webapps.xpto.pages.home_page;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Home_pageView extends View {

	public Field sectionheader_1_text;
	public Field table_1_text_1;
	public Field text_1;
	public IGRPSectionHeader sectionheader_1;
	public IGRPTable table_1;


	public Home_pageView(){

		this.setPageTitle("Home Page");
			
		sectionheader_1 = new IGRPSectionHeader("sectionheader_1","");

		table_1 = new IGRPTable("table_1","");

		sectionheader_1_text = new TextField(model,"sectionheader_1_text");
		sectionheader_1_text.setLabel(gt(""));
		sectionheader_1_text.setValue(gt("<p style='text-align: center;'><span style='font-size:24px;'><span style='color:#27ae60;'><span style='font-family:Trebuchet MS,Helvetica,sans-serif;'><strong>Home</strong></span></span></span></p>"));
		sectionheader_1_text.propertie().add("type","text").add("name","p_sectionheader_1_text").add("maxlength","4000");
		
		table_1_text_1 = new TextField(model,"table_1_text_1");
		table_1_text_1.setLabel(gt("Text"));
		table_1_text_1.propertie().add("name","p_table_1_text_1").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		text_1 = new TextField(model,"text_1");
		text_1.setLabel(gt("Text"));
		text_1.propertie().add("name","p_table_1_text_1").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		


		
	}
		
	@Override
	public void render(){
		
		sectionheader_1.addField(sectionheader_1_text);

		table_1.addField(table_1_text_1);
		table_1.addField(text_1);

		this.addToPage(sectionheader_1);
		this.addToPage(table_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		table_1_text_1.setValue(model);
		text_1.setValue(model);	

		table_1.loadModel(((Home_page) model).getTable_1());
		}
}

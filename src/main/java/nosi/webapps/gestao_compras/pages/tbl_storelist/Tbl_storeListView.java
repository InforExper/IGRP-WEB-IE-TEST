/*-------------------------*/

/*Create View*/
package nosi.webapps.gestao_compras.pages.tbl_storelist;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Tbl_storeListView extends View {

	public Field id;
	public Field description;
	public Field location;
	public Field id_user;
	public IGRPTable table_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_new;
	public IGRPButton btn_update;
	public IGRPButton btn_delete;

	public Tbl_storeListView(){

		this.setPageTitle("");
			
		table_1 = new IGRPTable("table_1","Listar store");

		id = new HiddenField(model,"id");
		id.setLabel(gt(""));
		id.propertie().add("tag","id").add("name","p_id").add("type","hidden").add("isAutoincrement","true").add("java-type","int").add("required","true");
		
		description = new TextField(model,"description");
		description.setLabel(gt("description"));
		description.propertie().add("name","p_description").add("maxlength","255").add("disabled","false").add("readonly","false").add("required","true").add("type","text").add("placeholder",gt("")).add("java-type","String").add("tag","description");
		
		location = new TextField(model,"location");
		location.setLabel(gt("location"));
		location.propertie().add("name","p_location").add("maxlength","255").add("disabled","false").add("readonly","false").add("required","false").add("type","text").add("placeholder",gt("")).add("java-type","String");
		
		id_user = new NumberField(model,"id_user");
		id_user.setLabel(gt("id user"));
		id_user.propertie().add("name","p_id_user").add("maxlength","11").add("disabled","false").add("readonly","false").add("required","false").add("type","number").add("placeholder",gt("")).add("java-type","int");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_new = new IGRPButton("New","gestao_compras","Tbl_storeList","new","modal|refresh","success|fa-plus","","");
		btn_new.propertie.add("rel","new").add("action-id","82").add("crud_op","addNew").add("type","specific");

		btn_update = new IGRPButton("Update","gestao_compras","Tbl_storeList","update","mpsubmit|refresh","warning|fa-pencil","","");
		btn_update.propertie.add("rel","update").add("action-id","82").add("crud_op","edit").add("type","form");

		btn_delete = new IGRPButton("Delete","gestao_compras","Tbl_storeList","delete","confirm","danger|fa-trash","","");
		btn_delete.propertie.add("rel","delete").add("action-id","83").add("crud_op","delete").add("type","form");

		
	}
		
	@Override
	public void render(){
		

		table_1.addField(id);
		table_1.addField(description);
		table_1.addField(location);
		table_1.addField(id_user);

		toolsbar_1.addButton(btn_new);
		table_1.addButton(btn_update);
		table_1.addButton(btn_delete);
		this.addToPage(table_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		id.setValue(model);
		description.setValue(model);
		location.setValue(model);
		id_user.setValue(model);	

		table_1.loadModel(((Tbl_storeList) model).getTable_1());
		}
}
/*-------------------------*/
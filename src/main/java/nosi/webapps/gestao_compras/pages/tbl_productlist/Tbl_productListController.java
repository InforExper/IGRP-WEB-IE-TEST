/*-------------------------*/

/*Create Controller*/

package nosi.webapps.gestao_compras.pages.tbl_productlist;

import nosi.core.webapp.Controller;
import nosi.core.webapp.databse.helpers.ResultSet;
import nosi.core.webapp.databse.helpers.QueryInterface;
import java.io.IOException;
import nosi.core.webapp.Core;
import nosi.core.webapp.Response;


/*----#start-code(packages_import)----*/


/*----#end-code----*/


public class Tbl_productListController extends Controller {
		

	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Tbl_productList model = new Tbl_productList();
		model.load();
		Tbl_productListView view = new Tbl_productListView();
		/*----#start-code(index)----*/
		QueryInterface query = Core.query("gestao_compras_postgresql_1","SELECT id as id,description as description,reference as reference,id_user as id_user FROM public.tbl_product");
		model.loadTable_1(query);
		
		view.id.setParam(true);
		/*----#end-code----*/
		view.setModel(model);
		
		view.id.setParam(true);
		return this.renderView(view);
	}


	public Response actionNew() throws IOException, IllegalArgumentException, IllegalAccessException{
		/*----#start-code(new)----*/
		
		/*----#end-code----*/
		return this.redirect("gestao_compras","Tbl_productForm","index");
	}

	public Response actionUpdate() throws IOException, IllegalArgumentException, IllegalAccessException{
		/*----#start-code(update)----*/
		this.addQueryString("target","_blank");
		this.addQueryString("isEdit","true");
		this.addQueryString("p_id",Core.getParam("p_id"));
		/*----#end-code----*/
		return this.redirect("gestao_compras","Tbl_productForm","index",this.queryString());
	}

	public Response actionDelete() throws IOException, IllegalArgumentException, IllegalAccessException{
		Tbl_productList.Table_1 model = new Tbl_productList.Table_1();
		/*----#start-code(delete)----*/
		ResultSet r = Core.delete("gestao_compras_postgresql_1","public","tbl_product").where("id=:id")
				.addInt("id",Core.getParamInt("p_id"))
				.execute();
		if(!r.hasError())
			Core.setMessageSuccess();
		else
			Core.setMessageError();
		/*----#end-code----*/
		return this.redirect("gestao_compras","Tbl_productList","index");
	}
}

package nosi.webapps.gestao_compras.pages.registar_compra;

import nosi.core.webapp.Controller;
import nosi.core.webapp.databse.helpers.ResultSet;
import nosi.core.webapp.databse.helpers.QueryInterface;
import java.io.IOException;
import nosi.core.webapp.Core;
import nosi.core.webapp.Response;
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/

import nosi.webapps.gestao_compras.dao.Compra;
import nosi.webapps.gestao_compras.dao.Loja;
import nosi.webapps.gestao_compras.dao.Produto;
import nosi.webapps.gestao_compras.pages.registar_compra.Registar_compra.Formlist_1;
import nosi.webapps.gestao_compras.pages.registar_produto.Registar_produto.Produtos;

/*----#end-code----*/
		
public class Registar_compraController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Registar_compra model = new Registar_compra();
		model.load();
		Registar_compraView view = new Registar_compraView();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadFormlist_1(Core.query(null,"SELECT '2' as id_product,'224' as price,'180' as quantity,'Iste aliqua deserunt aperiam doloremque' as total "));
		view.id_store.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		view.id_product.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		  ----#gen-example */
		/*----#start-code(index)----*/
		view.id_store.setQuery(Core.query("SELECT id as ID, descrption as NAME from tbl_loja"), "-- --");
		view.id_product.setQuery(Core.query("SELECT id as ID, descrption as NAME from tbl_produto"), "-- --");
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionSave() throws IOException, IllegalArgumentException, IllegalAccessException{
		Registar_compra model = new Registar_compra();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_compras","Registar_compra","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/*----#start-code(save)----*/
		long startTime = System.currentTimeMillis();
		
//		Loja loja = new Loja().findOne(model.getId_store());
		
		for (Formlist_1 p : model.getFormlist_1()) {
			
			Compra compra = new Compra();
//			Produto produto = (new Produto()).findOne(Core.toInt(p.getId_product().getKey()));
			
			compra.setId_produto(Core.toInt(p.getId_product().getKey()));
			compra.setId_loja(model.getId_store());
			compra.setQuntity(Core.toDouble(p.getQuantity().getKey()));
			compra.setPrice(Core.toDouble(p.getPrice().getKey()));
			compra.setDate_purchase(Core.ToDate(model.getDate_purchase()));
			compra.setDate_created(Core.getCurrentDateSql());
			compra = compra.insert();
			
			Core.setMessageInfo("ID:: " + compra.getId());
		}

		long endTime = System.currentTimeMillis();
		Core.setMessageSuccess("Guardado!!!");
//		Core.setMessageInfo("ID:: " + compra.getId());
//
//		if (!model.validate()) {
//			return this.forward("gestao_compras","Registar_compra","index",this.queryString());
//		}
//		
//		Core.setMessageInfo("teste 2");
//		
//		QueryInterface transaction = Core.transaction();
//		
//		try {
//			transaction.begin();
//			for (Formlist_1 p : model.getFormlist_1()) {
//				ResultSet res = transaction.insert("tbl_product")
//					.addInt("id_product", Core.convertInt p.getId_product().getKey())
//					.addDouble("price", p.getPrice().getKey())
//					.addDouble("quantity", p.getQuantity().getKey())
//					.addInt("id_user", Core.getCurrentUser().getId())
//					.addDate("date_purchase", model.getDate_purchase())
//					.addDate("date_dreated", Core.getCurrentDate())
//					.execute();				
//				
////				if (Core.isNotNull(res) && res.hasError()) {
////					
////				}
//			}
//			transaction.commit();
//			Core.setMessageSuccess("Guardado!!!");
//			
//		} catch (SQLException e) {
//			try {
//				transaction.roolback();
//				Core.setMessageError("Erro ao gravar");
//				
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		} finally {
//			try {
//				transaction.closeConnection();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		
		/*----#end-code----*/
		return this.redirect("gestao_compras","Registar_compra","index", this.queryString());	
	}
	
		
		
/*----#start-code(custom_actions)----*/

	public Response actionCalTotal() {
		
		Double _price = Core.getParamDouble("p_price");
		Double _quantity = Core.getParamDouble("p_quantity");
		
		Double _total = _price * _quantity;
        String _formlist = Core.getParam("p_formlist_1");
		
		String _resp = "<content><total>"+String.format("%.2f", _total)+"</total>"
				+
				"<header_total>"+_formlist+"5656</header_total></content>";

		return this.renderView(_resp);	
	}
  
/*----#end-code----*/
}

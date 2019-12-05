package nosi.webapps.gestao_compras.pages.registar_produto;

import nosi.core.webapp.Controller;
import nosi.core.webapp.databse.helpers.ResultSet;
import nosi.core.webapp.databse.helpers.QueryInterface;
import java.io.IOException;
import nosi.core.webapp.Core;
import nosi.core.webapp.Response;
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/

import nosi.webapps.gestao_compras.pages.registar_produto.Registar_produto.Produtos;
import java.sql.SQLException;

/*----#end-code----*/
		
public class Registar_produtoController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Registar_produto model = new Registar_produto();
		model.load();
		Registar_produtoView view = new Registar_produtoView();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadProdutos(Core.query(null,"SELECT 'Stract doloremque stract elit accusantium' as description,'Aperiam totam sit elit mollit' as reference "));
		  ----#gen-example */
		/*----#start-code(index)----*/
		
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionSave() throws IOException, IllegalArgumentException, IllegalAccessException{
		Registar_produto model = new Registar_produto();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_compras","Registar_produto","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/*----#start-code(save)----*/
		if (!model.validate()) {
			return this.forward("gestao_compras","Registar_produto","index",this.queryString());
		}
		
		Core.setMessageInfo("teste 2");
		
		QueryInterface transaction = Core.transaction();
		
		try {
			transaction.begin();
			for (Produtos p : model.getProdutos()) {
				ResultSet res = transaction.insert("tbl_product")
					.addString("description", p.getDescription().getValue())
					.addString("reference", p.getReference().getKey() + " 99999")
					.addInt("id_user", Core.getCurrentUser().getId())
					.execute();				
				
//				if (Core.isNotNull(res) && res.hasError()) {
//					
//				}
			}
			transaction.commit();
			Core.setMessageSuccess("Guardado!!!");
			
		} catch (SQLException e) {
			try {
				transaction.roolback();
				Core.setMessageError("Erro ao gravar");
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				transaction.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/*----#end-code----*/
		return this.redirect("gestao_compras","Registar_produto","index", this.queryString());	
	}
	
		
		
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}

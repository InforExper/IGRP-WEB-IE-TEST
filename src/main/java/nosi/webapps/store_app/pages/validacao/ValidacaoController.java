package nosi.webapps.store_app.pages.validacao;

import nosi.core.webapp.Controller;
import nosi.core.webapp.databse.helpers.ResultSet;
import nosi.core.webapp.databse.helpers.QueryInterface;
import java.io.IOException;
import nosi.core.webapp.Core;
import nosi.core.webapp.Response;
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/


/*----#end-code----*/
		
public class ValidacaoController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Validacao model = new Validacao();
		model.load();
		ValidacaoView view = new ValidacaoView();
		view.aprovar.loadDomain("VEICULO_SIM_NAO","-- Selecionar --");
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadFormlist_compras(Core.query(null,"SELECT 'Aliqua unde consectetur rem omnis' as descricao,'168' as quantidade "));
		  ----#gen-example */
		/*----#start-code(index)----*/
		
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
		
		
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}

package nosi.webapps.store_app.process.process_pedido_compra;

/*----#start-code(packages_import)----*/

import java.io.IOException;
import java.util.List;
import nosi.core.webapp.Response;
import javax.servlet.ServletException;
import nosi.core.webapp.Core;
import nosi.core.webapp.databse.helpers.ResultSet;
import nosi.core.webapp.databse.helpers.QueryInterface;
import nosi.webapps.igrp.dao.TipoDocumentoEtapa;
import nosi.core.webapp.bpmn.BPMNTaskController;
import nosi.webapps.store_app.pages.pedido_page.Pedido_page;
import nosi.webapps.store_app.pages.pedido_page.Pedido_pageView;
/*----#end-code----*/



/**
 *demo@nosi.cv
 *27-11-2019
*/

public class TaskpedidoController extends BPMNTaskController {

	public Response actionIndex() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {
		Pedido_pageView view = new Pedido_pageView();
		Pedido_page model = new Pedido_page();
		model.load();

		/*----#start-code(index)----*/
		model.loadFromTask("pedido");
		/*----#end-code----*/

		return super.index("store_app",model,view,this);
	}

	public Response actionSave() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {

		/*----#start-code(save)----*/

		/*----#end-code----*/

		return super.save();
	}

	public Response actionUpdate() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {

		/*----#start-code(update)----*/

		/*----#end-code----*/

		return super.update();
	}

	public List<TipoDocumentoEtapa> getInputDocumentType() {
		return super.getInputDocumentType();
	}

	public List<TipoDocumentoEtapa> getOutputDocumentType() {
		return super.getOutputDocumentType();
	}



	/*----#start-code(custom_actions)----*/

	/*----#end-code----*/



}

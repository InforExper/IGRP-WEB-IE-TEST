package nosi.webapps.store_app.process.process_pedido_compra;

/*----#start-code(packages_import)----*/

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import nosi.core.webapp.Core;
import nosi.core.webapp.Response;
import nosi.core.webapp.bpmn.BPMNTaskController;
import nosi.webapps.igrp.dao.TipoDocumentoEtapa;
import nosi.webapps.store_app.dao.ItemRequisicao;
import nosi.webapps.store_app.dao.Requisicao;
import nosi.webapps.store_app.pages.validacao.Validacao;
import nosi.webapps.store_app.pages.validacao.Validacao.Formlist_compras;
import nosi.webapps.store_app.pages.validacao.ValidacaoView;
/*----#end-code----*/



/**
 *demo@nosi.cv
 *27-11-2019
*/

public class TaskvalidacaoController extends BPMNTaskController {

	public Response actionIndex() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {
		ValidacaoView view = new ValidacaoView();
		Validacao model = new Validacao();
		model.load();

		/*----#start-code(index)----*/
//		
		
		view.aprovar.loadDomain("VEICULO_SIM_NAO", null, "-- Selecionar --");
      	//model.loadFromTask("validacao");
		model.loadFromTask("pedido");
		Core.setMessageInfo("Aprovar: " + Core.getTaskVariable("validacao", "p_aprovar"));
		Core.setTaskVariableInt("local_variavel", "local", 1); // global or local... por default global
		Core.setTaskVariableString("global_variavel", "tes"); //variavel global para todo a etapa do processo
		model.setAprovar(Core.getTaskVariable("validacao", "p_aprovar"));
		/*----#end-code----*/

		return super.index("store_app",model,view,this);
	}

	public Response actionSave() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {

		/*----#start-code(save)----*/
		try {

			Validacao _modelValidacao = new Validacao();
			
			_modelValidacao.load();
			
			Requisicao _requisicao = new Requisicao();
			
			_requisicao.setJustificacao(Core.getTaskVariable("pedido", "p_justificacao"));
			_requisicao.setDataRequisicao(Core.getCurrentDateSql());
			
			_requisicao.setEstado("S".compareTo(_modelValidacao.getAprovar()) == 0 ? "APROVADO": "REJEITADO");
					
			_requisicao = _requisicao.insert();
			
			for (Formlist_compras f : _modelValidacao.getFormlist_compras()) {
				ItemRequisicao item = new ItemRequisicao();
				
				item.setDescricao(f.getDescricao().getKey());
				item.setQuantidade(Core.toInt(f.getQuantidade().getKey()));
				item.setRequisicao_id(_requisicao.getId());
				item.insert();
			}
			
			if (_requisicao.hasError()) {
				throw new Exception("Erro a gravar.");
			}

		} catch (Exception e) {
			Core.setMessageError(e.getMessage());
			return this.forward("store_app", "Taskvalidacao", "index");
		}
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

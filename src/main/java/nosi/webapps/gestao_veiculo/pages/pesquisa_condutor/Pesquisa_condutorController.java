package nosi.webapps.gestao_veiculo.pages.pesquisa_condutor;

import nosi.core.webapp.Controller;
import nosi.core.webapp.databse.helpers.ResultSet;
import nosi.core.webapp.databse.helpers.QueryInterface;
import java.io.IOException;
import nosi.core.webapp.Core;
import nosi.core.webapp.Response;
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/

import nosi.webapps.gestao_veiculo.dao.Condutor;

import java.util.ArrayList;
import java.util.List;
import nosi.webapps.gestao_veiculo.dao.Movimento;
import nosi.webapps.gestao_veiculo.pages.pesquisa_condutor.Pesquisa_condutor.Table_condutor;
/*----#end-code----*/
		
public class Pesquisa_condutorController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Pesquisa_condutor model = new Pesquisa_condutor();
		model.load();
		Pesquisa_condutorView view = new Pesquisa_condutorView();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadTable_condutor(Core.query(null,"SELECT 'Stract aliqua anim sit deserunt' as nome,'Anim voluptatem dolor consectetur omnis' as cni,'Perspiciatis anim accusantium totam unde' as carta_conducao,'hidden-033e_8f51' as id_condutor "));
		  ----#gen-example */
		/*----#start-code(index)----*/
		/*Condutor condutor = new Condutor();

		List<Condutor> condutores = condutor.find()
				.where("nome", "like", Core.isNotNull(model.getNome_search()) ? "%" + model.getNome_search() + "%" : null)
				.orWhere("cni", "like", Core.isNotNull(model.getCni_search()) ? "%" + model.getCni_search() + "%" : null)
				.orWhere("carta_conducao", "like", Core.isNotNull(model.getCarta_conducao_search()) ? "%" + model.getCarta_conducao_search() + "%" : null)
				.all();

		List<Table_condutor> table_condutor = new ArrayList<>();
		
		for (Condutor c : condutores) {
			
			Table_condutor item = new Table_condutor();
			
			item.setCarta_conducao(c.getCarta_conducao());
			item.setCni(c.getCni());
			item.setId_condutor(c.getId());
			item.setNome(c.getNome());
			
			table_condutor.add(item);
		}
		
		model.setTable_condutor(table_condutor);*/

		model.loadTable_condutor(Core.query("SELECT nome,cni,carta_conducao,id as id_condutor from condutores where lower(nome) like lower('%'||:nome ||'%') ")
			//	.addString("cni", model.getCni_search())
				.addString("nome", model.getNome_search())
				//.addString("carta_conducao", model.getCarta_conducao_search())
				);

		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionPesquisar() throws IOException, IllegalArgumentException, IllegalAccessException{
		Pesquisa_condutor model = new Pesquisa_condutor();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_veiculo","Pesquisa_condutor","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/*----#start-code(pesquisar)----*/
		
		return this.forward("gestao_veiculo","Pesquisa_condutor","index",this.queryString());
		/*----#end-code----*/
			
	}
	
		
		
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}

package nosi.webapps.gestao_veiculo.pages.registar_movimento;

import nosi.core.webapp.Controller;
import nosi.core.webapp.databse.helpers.ResultSet;
import nosi.core.webapp.databse.helpers.QueryInterface;
import java.io.IOException;
import nosi.core.webapp.Core;
import nosi.core.webapp.Response;
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import nosi.webapps.gestao_veiculo.dao.Movimento;
import nosi.webapps.gestao_veiculo.dao.Veiculo;

import java.sql.Timestamp;
/*----#end-code----*/
		
public class Registar_movimentoController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Registar_movimento model = new Registar_movimento();
		model.load();
		Registar_movimentoView view = new Registar_movimentoView();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		view.veiculo.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		  ----#gen-example */
		/*----#start-code(index)----*/
		Core.setMessageInfo("teste");
		Map<Integer, String> veiculosMap =  new HashMap<>();
		/*List<Veiculo> veiculos = new Veiculo().findAll();
		
		for (Veiculo v : veiculos) {
			veiculosMap.put(v.getId(), v.getMatricula());
		}
		
		view.veiculo.setValue(veiculosMap);*/
		veiculosMap.put(null, "---");
		veiculosMap.putAll(new Veiculo().findAll().stream().collect(Collectors.toMap(v -> v.getId(), v -> v.getMatricula())));
		view.veiculo.setValue(veiculosMap);
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionSave() throws IOException, IllegalArgumentException, IllegalAccessException{
		Registar_movimento model = new Registar_movimento();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_veiculo","Registar_movimento","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/*----#start-code(save)----*/
		
		Movimento movimento = new Movimento();

		//yyyy-mm-dd hh:mm:ss
//		movimento.setCondutor_id(Core.toInt( model.getId_condutor()));
//		movimento.setVeiculo_id(Core.toInt( model.getVeiculo()));
		movimento.setKm_saida(model.getKm_saida());
		movimento.setData_saida(Timestamp.valueOf(Core.convertDate(model.getData_saida(),"dd-mm-yyyy", "yyyy-mm-dd") + " " + model.getHora() + ":00") );
		movimento.insert();
		
		Core.setMessageSuccess("Guardado!!!");
		/*----#end-code----*/
		return this.redirect("gestao_veiculo","Registar_movimento","index", this.queryString());	
	}
	
		
		
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}

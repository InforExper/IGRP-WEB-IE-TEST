package nosi.webapps.gestao_veiculo.pages.dashboard;

import nosi.core.webapp.Controller;
import nosi.core.webapp.databse.helpers.ResultSet;
import nosi.core.webapp.databse.helpers.QueryInterface;
import java.io.IOException;
import nosi.core.webapp.Core;
import nosi.core.webapp.Report;
import nosi.core.webapp.Response;
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/
import nosi.webapps.gestao_veiculo.dao.Condutor;
import nosi.webapps.gestao_veiculo.dao.Movimento;
import java.util.List;
import nosi.core.webapp.databse.helpers.ResultSet.Record;
// teste
/*----#end-code----*/
		
public class DashboardController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Dashboard model = new Dashboard();
		model.load();
		model.setBox_viculo_rua_porcento_title("Total Veiculo Na Rua");
		model.setBox_viculo_rua_porcento_lbl("percent");
		model.setBox_viculo_rua_porcento_val("23.1");
		model.setBox_viculo_rua_porcento_desc("Ver Veículos Por Entrar");
		model.setBox_viculo_rua_porcento_url("http://www.example.com");
		model.setBox_viculo_rua_porcento_bg("cp-cyan");
		model.setBox_total_condutor_title("Total Condutor");
		model.setBox_total_condutor_val("512");
		model.setBox_total_condutor_url("http://www.example.com");
		model.setBox_total_condutor_lbl("View Details");
		model.setBox_total_condutor_bg("cp-cyan");
		model.setBox_total_condutor_icn("fa-user-circle-o");
		model.setBox_veiculo_km_50_title("Veiculo KM maior 50");
		model.setBox_veiculo_km_50_val("666");
		model.setBox_veiculo_km_50_txt("Read More...");
		model.setBox_veiculo_km_50_url("http://www.example.com");
		model.setBox_veiculo_km_50_bg("cp-cyan");
		model.setBox_veiculo_km_50_icn("fa-dashboard");
		model.setBox_condutor_rua_title("Total Condutor na rua");
		model.setBox_condutor_rua_val("970");
		model.setBox_condutor_rua_url(Core.getIGRPLink("gestao_veiculo","Veiculos_lista","index"));
		model.setBox_condutor_rua_bg("cp-cyan");
		model.setBox_condutor_rua_icn("fa-car");
		DashboardView view = new DashboardView();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		view.chart_evolucao_movimento.loadQuery(Core.query(null,"SELECT 'X1' as EixoX, 'Y1' as EixoY, 15 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 10 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 23 as EixoZ"
                                      +" UNION SELECT 'X3' as EixoX, 'Y3' as EixoY, 40 as EixoZ"));
		view.chart_veiculo_saida.loadQuery(Core.query(null,"SELECT 'X1' as EixoX, 'Y1' as EixoY, 15 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 10 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 23 as EixoZ"
                                      +" UNION SELECT 'X3' as EixoX, 'Y3' as EixoY, 40 as EixoZ"));
		view.chart_condutor_saida.loadQuery(Core.query(null,"SELECT 'X1' as EixoX, 'Y1' as EixoY, 15 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 10 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 23 as EixoZ"
                                      +" UNION SELECT 'X3' as EixoX, 'Y3' as EixoY, 40 as EixoZ"));
		model.setBox_viculo_rua_porcento_url(Core.getIGRPLink("your app","your page","your action"));
		model.setBox_total_condutor_url(Core.getIGRPLink("your app","your page","your action"));
		model.setBox_veiculo_km_50_url(Core.getIGRPLink("your app","your page","your action"));
		  ----#gen-example */
		/*----#start-code(index)----*/
		
		// usando HQL em cima de class Movimento
//		List<Movimento> movimentos = Core.query("select m from Movimento").getResultList(Movimento.class);
		Movimento m = new Movimento();
		
		long total_veiculo_rua = m.find()
				.andWhereIsNull("data_entrada")
				.andWhereNotNull("data_saida")
				.getCount();

//		int total_condutor = Core.query("select count(*) as total from condutores").getSingleRecord().getInt("total");
		long total_condutor = new Condutor().getCount();
//		
		long total_veiculo_km = m.find().where("km_saida", ">", new Double(50000) ).getCount();
//		
		model.setBox_viculo_rua_porcento_val("" + total_veiculo_rua);
		model.setBox_viculo_rua_porcento_url(Core.getLinkReport("VEICULO_RUA").getLink());
		
		model.setBox_condutor_rua_val("" + total_veiculo_rua);
		
		
		model.setBox_total_condutor_val("" + total_condutor);
		model.setBox_total_condutor_url(Core.getLinkReport("LS_Condutor").getLink());
		
		model.setBox_veiculo_km_50_val("" + total_veiculo_km);

		Core.setMessageInfo("total_condutor: " + total_condutor);
		
//		List<Movimento> movimentos = Core.query("select m from Movimento").getResultList(Movimento.class);
//		int total_c = Core.query("select count(*) as total from tbl_condutor").getSingleRecord().getInt("total");
//		Record query = Core.query("select count(*) as total from tbl_condutor").getSingleRecord();
//		query.getInt("total");
//		query.getString("nome");
		
//		 Record query = Core.query("select * from tbl_condutor").getRecordList();
//		 query.RowList.forEach(row->{
//			 row.getInt("nome");
//		 });
		
		//++++++++++++ Graficos ++++++++++++++++++ //
		view.chart_evolucao_movimento.loadQuery(
				Core.query("select to_char(data_saida, 'yyyy-mm-dd') EixoX, v.matricula as EixoY, count(*) as EixoZ\r\n" + 
						"from movimentos m, veiculos v where v.id = m.veiculo_id\r\n" + 
						"GROUP by to_char(data_saida, 'yyyy-mm-dd'), v.matricula  order by to_char(data_saida, 'yyyy-mm-dd')"));
		
		view.chart_veiculo_saida.loadQuery(
				Core.query("select to_char(data_saida, 'yyyy-mm-dd') as EixoX, count(*) as EixoY "
				+ "from movimentos GROUP by to_char(data_saida, 'yyyy-mm-dd') order by to_char(data_saida, 'yyyy-mm-dd')"));
		
		view.chart_condutor_saida.loadQuery(
				Core.query("select to_char(m.data_saida,'yyyy-mm-dd') as EixoX,  c.nome as EixoY, count(*) as EixoZ " + 
						"				from condutores c, movimentos m " + 
						"				where c.id=m.condutor_id " + 
						"				group by c.nome,to_char(m.data_saida,'yyyy-mm-dd') order by to_char(data_saida, 'yyyy-mm-dd')"));
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionPesquisar() throws IOException, IllegalArgumentException, IllegalAccessException{
		Dashboard model = new Dashboard();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_veiculo","Veiculos_lista","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/*----#start-code(pesquisar)----*/
		
		return this.forward("gestao_veiculo","Dashboard","index",this.queryString());
		/*----#end-code----*/
			
	}
	
	public Response actionReport() throws IOException, IllegalArgumentException, IllegalAccessException{
		Dashboard model = new Dashboard();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_veiculo","Veiculos_lista","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/*----#start-code(report)----*/
//		Core.getLinkReport("VEICULO_RUA").addParam("marca","?").addParam("matricula","?");
		
		return Core.getLinkReport("VEICULO_RUA", new Report().addParam("marca", null).addParam("matricula", model.getMatricula_filter()));
//		return Core.getLinkReport("VEICULO_RUA", null);
		
		/*----#end-code----*/
			
	}
	
		
		
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}

package nosi.webapps.gestao_veiculo.pages.pesquisa_condutor;

import nosi.core.gui.components.IGRPTable;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import java.util.ArrayList;
import java.util.List;

public class Pesquisa_condutor extends Model{		

	@RParam(rParamName = "p_nome_search")
	private String nome_search;

	@RParam(rParamName = "p_carta_conducao_search")
	private String carta_conducao_search;

	@RParam(rParamName = "p_cni_search")
	private String cni_search;
	
	private List<Table_condutor> table_condutor = new ArrayList<>();	
	public void setTable_condutor(List<Table_condutor> table_condutor){
		this.table_condutor = table_condutor;
	}
	public List<Table_condutor> getTable_condutor(){
		return this.table_condutor;
	}

	
	public void setNome_search(String nome_search){
		this.nome_search = nome_search;
	}
	public String getNome_search(){
		return this.nome_search;
	}
	
	public void setCarta_conducao_search(String carta_conducao_search){
		this.carta_conducao_search = carta_conducao_search;
	}
	public String getCarta_conducao_search(){
		return this.carta_conducao_search;
	}
	
	public void setCni_search(String cni_search){
		this.cni_search = cni_search;
	}
	public String getCni_search(){
		return this.cni_search;
	}


	public static class Table_condutor extends IGRPTable.Table{
		private String nome;
		private String cni;
		private String carta_conducao;
		private int id_condutor;
		public void setNome(String nome){
			this.nome = nome;
		}
		public String getNome(){
			return this.nome;
		}

		public void setCni(String cni){
			this.cni = cni;
		}
		public String getCni(){
			return this.cni;
		}

		public void setCarta_conducao(String carta_conducao){
			this.carta_conducao = carta_conducao;
		}
		public String getCarta_conducao(){
			return this.carta_conducao;
		}

		public void setId_condutor(int id_condutor){
			this.id_condutor = id_condutor;
		}
		public int getId_condutor(){
			return this.id_condutor;
		}

	}

	public void loadTable_condutor(BaseQueryInterface query) {
		this.setTable_condutor(this.loadTable(query,Table_condutor.class));
	}

}

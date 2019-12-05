package nosi.webapps.store_app.pages.validacao;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.SeparatorList;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import nosi.core.validator.constraints.*;

public class Validacao extends Model{		

	@NotNull()
	@RParam(rParamName = "p_aprovar")
	private String aprovar;
	
	@SeparatorList(name = Formlist_compras.class)
	@Valid
	private List<Formlist_compras> formlist_compras = new ArrayList<>();	
	public void setFormlist_compras(List<Formlist_compras> formlist_compras){
		this.formlist_compras = formlist_compras;
	}
	public List<Formlist_compras> getFormlist_compras(){
		return this.formlist_compras;
	}
	@RParam(rParamName = "p_formlist_compras_id")
	private String[] p_formlist_compras_id;
	@RParam(rParamName = "p_formlist_compras_del")
	private String[] p_formlist_compras_del;
	@RParam(rParamName = "p_formlist_compras_edit")
	private String[] p_formlist_compras_edit;
	
	public void setP_formlist_compras_id(String[] p_formlist_compras_id){
		this.p_formlist_compras_id = p_formlist_compras_id;
	}
	public String[] getP_formlist_compras_id(){
		return this.p_formlist_compras_id;
	}
	
	public void setP_formlist_compras_del(String[] p_formlist_compras_del){
		this.p_formlist_compras_del = p_formlist_compras_del;
	}
	public String[] getP_formlist_compras_del(){
		return this.p_formlist_compras_del;
	}
	
	public void setP_formlist_compras_edit(String[] p_formlist_compras_edit){
		this.p_formlist_compras_edit = p_formlist_compras_edit;
	}
	public String[] getP_formlist_compras_edit(){
		return this.p_formlist_compras_edit;
	}
	
	public void setAprovar(String aprovar){
		this.aprovar = aprovar;
	}
	public String getAprovar(){
		return this.aprovar;
	}


	public static class Formlist_compras{
		private Pair formlist_compras_id;
		@PairNotNull()

		private Pair descricao;

		private Pair quantidade;
		public void setFormlist_compras_id(Pair formlist_compras_id){
			this.formlist_compras_id = formlist_compras_id;
		}
		public Pair getFormlist_compras_id(){
			return this.formlist_compras_id;
		}
		public void setDescricao(Pair descricao){
			this.descricao = descricao;
		}
		public Pair getDescricao(){
			return this.descricao;
		}

		public void setQuantidade(Pair quantidade){
			this.quantidade = quantidade;
		}
		public Pair getQuantidade(){
			return this.quantidade;
		}

	}

	public void loadFormlist_compras(BaseQueryInterface query) {
		this.setFormlist_compras(this.loadFormList(query,Formlist_compras.class));
	}

}

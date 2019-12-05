package nosi.webapps.gestao_compras.pages.registar_produto;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.SeparatorList;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import nosi.core.validator.constraints.*;

public class Registar_produto extends Model{		

	@RParam(rParamName = "p_sectionheader_1_text")
	private String sectionheader_1_text;
	
	@SeparatorList(name = Produtos.class)
	@Valid
	private List<Produtos> produtos = new ArrayList<>();	
	public void setProdutos(List<Produtos> produtos){
		this.produtos = produtos;
	}
	public List<Produtos> getProdutos(){
		return this.produtos;
	}
	@RParam(rParamName = "p_produtos_id")
	private String[] p_produtos_id;
	@RParam(rParamName = "p_produtos_del")
	private String[] p_produtos_del;
	@RParam(rParamName = "p_produtos_edit")
	private String[] p_produtos_edit;
	
	public void setP_produtos_id(String[] p_produtos_id){
		this.p_produtos_id = p_produtos_id;
	}
	public String[] getP_produtos_id(){
		return this.p_produtos_id;
	}
	
	public void setP_produtos_del(String[] p_produtos_del){
		this.p_produtos_del = p_produtos_del;
	}
	public String[] getP_produtos_del(){
		return this.p_produtos_del;
	}
	
	public void setP_produtos_edit(String[] p_produtos_edit){
		this.p_produtos_edit = p_produtos_edit;
	}
	public String[] getP_produtos_edit(){
		return this.p_produtos_edit;
	}
	
	public void setSectionheader_1_text(String sectionheader_1_text){
		this.sectionheader_1_text = sectionheader_1_text;
	}
	public String getSectionheader_1_text(){
		return this.sectionheader_1_text;
	}


	public static class Produtos{
		private Pair produtos_id;
		@PairNotNull(message="Favor Preencher Descrição.")

		private Pair description;
		@PairSize(min=3,max=10,message="Referencia min 3 e max 10.")

		private Pair reference;
		public void setProdutos_id(Pair produtos_id){
			this.produtos_id = produtos_id;
		}
		public Pair getProdutos_id(){
			return this.produtos_id;
		}
		public void setDescription(Pair description){
			this.description = description;
		}
		public Pair getDescription(){
			return this.description;
		}

		public void setReference(Pair reference){
			this.reference = reference;
		}
		public Pair getReference(){
			return this.reference;
		}

	}

	public void loadProdutos(BaseQueryInterface query) {
		this.setProdutos(this.loadFormList(query,Produtos.class));
	}

}

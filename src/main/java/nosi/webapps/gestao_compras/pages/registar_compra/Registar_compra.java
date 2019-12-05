package nosi.webapps.gestao_compras.pages.registar_compra;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.SeparatorList;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import nosi.core.validator.constraints.*;

public class Registar_compra extends Model{		

	@RParam(rParamName = "p_header_text")
	private String header_text;

	@NotNull(message="Favor Seleccionar a Loja.")
	@RParam(rParamName = "p_id_store")
	private int id_store;

	@NotNull(message="Favor Indicar a data de compra.")
	@PastOrPresent(message="Campo data não pode ser nu futuro.")
	@RParam(rParamName = "p_date_purchase")
	private String date_purchase;
	
	@SeparatorList(name = Formlist_1.class)
	@Valid
	private List<Formlist_1> formlist_1 = new ArrayList<>();	
	public void setFormlist_1(List<Formlist_1> formlist_1){
		this.formlist_1 = formlist_1;
	}
	public List<Formlist_1> getFormlist_1(){
		return this.formlist_1;
	}
	@RParam(rParamName = "p_formlist_1_id")
	private String[] p_formlist_1_id;
	@RParam(rParamName = "p_formlist_1_del")
	private String[] p_formlist_1_del;
	@RParam(rParamName = "p_formlist_1_edit")
	private String[] p_formlist_1_edit;
	
	public void setP_formlist_1_id(String[] p_formlist_1_id){
		this.p_formlist_1_id = p_formlist_1_id;
	}
	public String[] getP_formlist_1_id(){
		return this.p_formlist_1_id;
	}
	
	public void setP_formlist_1_del(String[] p_formlist_1_del){
		this.p_formlist_1_del = p_formlist_1_del;
	}
	public String[] getP_formlist_1_del(){
		return this.p_formlist_1_del;
	}
	
	public void setP_formlist_1_edit(String[] p_formlist_1_edit){
		this.p_formlist_1_edit = p_formlist_1_edit;
	}
	public String[] getP_formlist_1_edit(){
		return this.p_formlist_1_edit;
	}
	
	public void setHeader_text(String header_text){
		this.header_text = header_text;
	}
	public String getHeader_text(){
		return this.header_text;
	}
	
	public void setId_store(int id_store){
		this.id_store = id_store;
	}
	public int getId_store(){
		return this.id_store;
	}
	
	public void setDate_purchase(String date_purchase){
		this.date_purchase = date_purchase;
	}
	public String getDate_purchase(){
		return this.date_purchase;
	}


	public static class Formlist_1{
		private Pair formlist_1_id;

		private Pair id_product;
		@PairNotNull()

		private Pair price;
		@PairNotNull()

		private Pair quantity;

		private Pair total;
		public void setFormlist_1_id(Pair formlist_1_id){
			this.formlist_1_id = formlist_1_id;
		}
		public Pair getFormlist_1_id(){
			return this.formlist_1_id;
		}
		public void setId_product(Pair id_product){
			this.id_product = id_product;
		}
		public Pair getId_product(){
			return this.id_product;
		}

		public void setPrice(Pair price){
			this.price = price;
		}
		public Pair getPrice(){
			return this.price;
		}

		public void setQuantity(Pair quantity){
			this.quantity = quantity;
		}
		public Pair getQuantity(){
			return this.quantity;
		}

		public void setTotal(Pair total){
			this.total = total;
		}
		public Pair getTotal(){
			return this.total;
		}

	}

	public void loadFormlist_1(BaseQueryInterface query) {
		this.setFormlist_1(this.loadFormList(query,Formlist_1.class));
	}

}

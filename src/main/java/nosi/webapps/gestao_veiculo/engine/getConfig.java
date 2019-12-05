package nosi.webapps.gestao_veiculo.engine;

import org.apache.poi.ss.formula.functions.T;

import nosi.base.ActiveRecord.BaseActiveRecord;
import oracle.net.aso.t;

/**
 * ati88
 * 05/12/2019
 */
public class getConfig {
	
	public static class gestaoVeiculoConf{
		public static final String NAME = "gestao_veiculo";
		public static final String DB_POSTGRES = "gestao_veiculo_postgresql";
		
		@SuppressWarnings("hiding")
		public static <T> void setConnectionAndName(BaseActiveRecord<T> object) {
			object.setApplicationName(NAME);
			object.setConnectionName(DB_POSTGRES);
		}
	}
	
	public static class gestaoComprasConf {
		public static final String NAME = "gestao_compras";
		public static final String DB_POSTGRES = "gestao_compras_postgresql_1";
	}

	public static class storeAppConf {
		public static final String NAME = "store_app";
		public static final String DB_POSTGRES = "store_app_postgresql";
	}

	public interface connectionAndName {
		@SuppressWarnings("hiding")
		public static <T> void setConnectionAndName(BaseActiveRecord<T> object) {}
	}
	
	
}

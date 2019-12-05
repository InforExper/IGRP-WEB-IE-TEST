package nosi.webapps.gestao_veiculo.services.soap.soap_client;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.bind.annotation.XmlElement;

import nosi.webapps.gestao_veiculo.dao.Veiculo;

/**
 * ati88
 * 04/12/2019
 */
public class SoapVeiculoClient {

	public List<Veiculo> getVeiculos(){
		Veiculo v = new Veiculo();
//		v.setApplicationName("gestao_veiculo");
//		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v. findAll(); 
	}
	

	public Veiculo getVeiculoById(Integer id) {
		Veiculo v = new Veiculo();

//		v.setApplicationName("gestao_veiculo");
//		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v. findOne(id);
	}

	public Veiculo createVeiculo(Veiculo v) {

//		v.setApplicationName("gestao_veiculo");
//		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.insert();
	}

	public Veiculo updateVeiculo(Veiculo v) {

//		v.setApplicationName("gestao_veiculo");
//		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.update();
	}
	
	public boolean deleteVeiculoById(Integer id) {
		Veiculo v = new Veiculo();
//		v.setApplicationName("gestao_veiculo");
//		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.delete(id);
	}
}

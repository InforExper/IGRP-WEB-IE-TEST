package nosi.webapps.gestao_veiculo.services.soap;
/**
 * ati88
 * 04/12/2019
 */

import java. util. List; 
import javax.jws.*;
import javax.xml.bind.annotation.XmlElement;

import nosi.core.webapp.Core;
import nosi.webapps.gestao_veiculo.dao.Veiculo; 

@WebService(name = "veiculo_service", targetNamespace = "http://formacao.igrpweb.cv")
public class SoapVeiculoService {

	@WebMethod(operationName = "list_veiculos")
	@WebResult(name = "veiculos")
	public List<Veiculo> getVeiculos(){
		Veiculo v = new Veiculo();
		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v. findAll();
	}
	

	@WebMethod(operationName = "veiculos_by_id")
	@WebResult(name = "veiculo")
	public Veiculo getVeiculoById(@WebParam(name="id") @XmlElement(required = true) Integer id) {
		Veiculo v = new Veiculo();

		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.findOne(id);
	}

	@WebMethod(operationName = "create_veiculos")
	@WebResult(name = "veiculo")
	public Veiculo createVeiculo(Veiculo v) {

		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.insert();
	}

	@WebMethod(operationName = "update_veiculos")
	@WebResult(name = "veiculo")
	public Veiculo updateVeiculo(Veiculo v2) {
		Veiculo v = new Veiculo();
		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		v = v.findOne(v2.getId());

		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		if (Core.isNotNull(v2.getMarca())) {
			v.setMarca(v2.getMarca());
		}	

		if (Core.isNotNull(v2.getMatricula())) {
			v.setMatricula(v2.getMatricula());
		}
		
		if (Core.isNotNull(v2.getCor())) {
			v.setCor(v2.getCor());
		}
		
		return v.update();
		
	}
	

	@WebMethod(operationName = "delete_veiculos")
	@WebResult(name = "veiculo")
	public boolean deleteVeiculoById(@WebParam(name="id") @XmlElement(required = true) Integer id) {
		Veiculo v = new Veiculo();
		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.delete(id);
	}
}

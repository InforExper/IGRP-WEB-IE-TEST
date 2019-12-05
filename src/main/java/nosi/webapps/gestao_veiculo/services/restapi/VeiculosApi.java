package nosi.webapps.gestao_veiculo.services.restapi;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nosi.webapps.gestao_veiculo.controllers.VeiculoController;
import nosi.webapps.gestao_veiculo.dao.Veiculo;
import nosi.webapps.gestao_veiculo.dao.dto.VeiculoDto;
import nosi.webapps.gestao_veiculo.engine.getConfig.gestaoVeiculoConf;

/**
 * ati88
 * 02/12/2019
 */

@Path("/veiculos")
public class VeiculosApi {

	VeiculoController veiculoController = new VeiculoController();
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VeiculoDto> getProducts() {
		return veiculoController.getVeiculos();
	}
	
}

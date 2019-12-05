package nosi.webapps.gestao_veiculo.services.restapi;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * ati88
 * 02/12/2019
 */
@ApplicationPath("rest")
public class Config extends ResourceConfig{
	public Config() {
		packages("nosi.webapps.gestao_veiculo.services.restapi");
	}
}

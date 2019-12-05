package nosi.webapps.gestao_veiculo.controllers;
/**
 * ati88
 * 04/12/2019
 */

import java.awt.print.Pageable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java. util. List;

import org.apache.commons.beanutils.BeanUtils;

import nosi.core.webapp.Core;
import nosi.webapps.gestao_veiculo.dao.Veiculo;
import nosi.webapps.gestao_veiculo.dao.dto.VeiculoDto;
import nosi.webapps.gestao_veiculo.engine.getConfig.gestaoVeiculoConf; 
import org.modelmapper.ModelMapper;

import com.google.common.reflect.TypeToken;

public class VeiculoController {
	
	public List<VeiculoDto> getVeiculos(){
		Veiculo v = new Veiculo();
		v.setApplicationName(gestaoVeiculoConf.NAME);
		v.setConnectionName(gestaoVeiculoConf.DB_POSTGRES);
//		gestaoVeiculoConf.setConnectionAndName(v);
		
		 List<Veiculo> vL =v.findAll();
		// Create Conversion Type
		 Type listType = new TypeToken<List<VeiculoDto>>(){}.getType();
		// Convert List of Entity objects to a List of DTOs objects 
		List<VeiculoDto> veiculoDto = new ModelMapper().map(vL, listType);
		
//		Core.mapArray(v, veiculoDto);
//		Core.mapper(v.findAll(), veiculoDto);
		return veiculoDto;
	}
	

	public Veiculo getVeiculoById(Integer id) {
		Veiculo v = new Veiculo();

		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.findOne(id);
	}


	public Veiculo createVeiculo(Veiculo v) {

		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.insert();
	}

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
	
	public boolean deleteVeiculoById(Integer id) {
		Veiculo v = new Veiculo();
		v.setApplicationName("gestao_veiculo");
		v.setConnectionName("gestao_veiculo_postgresql");
		
		return v.delete(id);
	}
}

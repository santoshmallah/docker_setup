package com.sql.smartpra.ods.datatrans.ods_datatrans.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MongoEntity;
import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MasOdsConfigParameter;
import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.TicketMainModel;
import com.sql.smartpra.ods.datatrans.ods_datatrans.services.OdsServiceInterface;

@RestController
@RequestMapping("/api/Ods")
public class OdsFetchController {

	@Autowired
	private OdsServiceInterface odsServiceInter;


	/*
	 * public OdsFetchController(OdsService odsService) { this.odsService =
	 * odsService; }
	 */

	@GetMapping("/")
	public List<MasOdsConfigParameter> getAllEntity() {
		
		//System.out.println()
		//List<SalesEntity> ls=odsServiceInter.getAllEntity();
		//return ls; 
		
		return odsServiceInter.getAllEntity();
		
	}	
	
	  @GetMapping("/getById/{mas_ods_config_parameter_id}") 
	  public Optional<MasOdsConfigParameter>getAllEntityById(@PathVariable Integer mas_ods_config_parameter_id) {
	  
		  return odsServiceInter.getAllEntityById(mas_ods_config_parameter_id);
	  }	 
	  
	  @GetMapping("/entities")
	    public Map<Long, String> getEntitiesWithCondition() {
	        return odsServiceInter.getEntitiesByIdCondition();
	    }
	  
	  
	  @GetMapping("/fetchMongo")
		public CompletableFuture<List<MongoEntity>> getAll() {
			return odsServiceInter.fetchAll();
		}
	  
	  @GetMapping("/fetchJsonData")
		public  ResponseEntity<List<Document>> getAllJsonData() {
		  List<Document> result = odsServiceInter.getAllJsonData();
	        return ResponseEntity.ok(result); 
		}

}

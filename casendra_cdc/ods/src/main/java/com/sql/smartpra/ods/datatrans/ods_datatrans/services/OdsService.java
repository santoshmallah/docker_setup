package com.sql.smartpra.ods.datatrans.ods_datatrans.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MongoEntity;
import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MasOdsConfigParameter;
import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.TicketMainModel;
import com.sql.smartpra.ods.datatrans.ods_datatrans.repositorys.MongoRepo;
import com.sql.smartpra.ods.datatrans.ods_datatrans.repositorys.NewMongoRepo;
import com.sql.smartpra.ods.datatrans.ods_datatrans.repositorys.OdsRepository;

@Service
public class OdsService implements OdsServiceInterface{

	@Autowired
	private MongoRepo mongoRepo;
	
	@Autowired
	private NewMongoRepo newMongoRepo;
	
	@Autowired
	private OdsRepository odsRepository;

	public List<MasOdsConfigParameter> getAllEntity() {
		List<MasOdsConfigParameter> All_ls=odsRepository.findAll();
		System.out.println(All_ls);
		return All_ls;
			
	}

	@Override
	public Optional<MasOdsConfigParameter> getAllEntityById(Integer mas_ods_config_parameter_id) {
		
		Optional<MasOdsConfigParameter> ls=odsRepository.findById(mas_ods_config_parameter_id);
		System.out.println(ls);
		return ls;
	}

	@Override
	public Map<Long, String> getEntitiesByIdCondition() {
		List<MasOdsConfigParameter> entities = odsRepository.findAll();
        Map<Long, String> resultMap = new HashMap<>();
        
        for (MasOdsConfigParameter entity : entities) {
           
            if (entity.getClient_id()!= null) {
 
                resultMap.put((long)entity.getMas_ods_config_parameter_id(), entity.getClass().getSimpleName());               
            }
        }
        
        return resultMap;
	}

	@Override
	@Async
	public CompletableFuture<List<MongoEntity>> fetchAll() {
		List<MongoEntity> mongoEntity=mongoRepo.findAll();
		return CompletableFuture.completedFuture(mongoEntity);
	}

	@Override
	public List fetchAllJsonData() {
		
		return mongoRepo.findAll();
	}

	@Override
	public List<Document> getAllJsonData() {
	
		return newMongoRepo.findJsonData();
	}	
	
	
	
	

	/*
	 * @Override public Optional<SalesEntity> getEntityId(Optional<String> clientId)
	 * {
	 * 
	 * return odsRepository.findById(clientId); }
	 */
	
	
	/*
	 * @Override public Optional<SalesEntity> getEntityId(Long client_id) { return
	 * odsRepository.findById(client_id); }
	 */
}

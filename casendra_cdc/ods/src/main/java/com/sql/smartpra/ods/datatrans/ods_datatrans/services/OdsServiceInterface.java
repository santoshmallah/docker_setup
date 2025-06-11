package com.sql.smartpra.ods.datatrans.ods_datatrans.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.bson.Document;

import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MongoEntity;
import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MasOdsConfigParameter;
import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.TicketMainModel;

public interface OdsServiceInterface {
	
	List<MasOdsConfigParameter> getAllEntity();

	//Optional<SalesEntity> getEntityId(Optional<String> clientId);

	Optional<MasOdsConfigParameter> getAllEntityById(Integer mas_ods_config_parameter_ident_id);

	Map<Long, String> getEntitiesByIdCondition();

	CompletableFuture<List<MongoEntity>> fetchAll();

	List<TicketMainModel> fetchAllJsonData();

	List<Document> getAllJsonData();

	//List<SalesEntity> getEntityId();
}

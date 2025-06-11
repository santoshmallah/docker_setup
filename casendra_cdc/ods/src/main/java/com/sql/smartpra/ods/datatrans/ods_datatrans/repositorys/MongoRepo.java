package com.sql.smartpra.ods.datatrans.ods_datatrans.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MongoEntity;

@Repository
public interface MongoRepo extends MongoRepository<MongoEntity, String>{

}

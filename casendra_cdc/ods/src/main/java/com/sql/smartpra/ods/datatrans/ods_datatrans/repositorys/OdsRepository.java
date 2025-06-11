package com.sql.smartpra.ods.datatrans.ods_datatrans.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sql.smartpra.ods.datatrans.ods_datatrans.entity.MasOdsConfigParameter;

@Repository
public interface OdsRepository extends JpaRepository<MasOdsConfigParameter, Integer>{

	Optional<MasOdsConfigParameter> findById(Integer mas_ods_config_parameter_id);
	//List<SalesEntity> findAll();

	//List<SalesEntity> findById(SalesEntity salesEntity, Optional<String> exceptionCall);

}

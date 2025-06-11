package com.sql.smartpra.ods.datatrans.ods_datatrans.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "mas_scenario")
public class MongoEntity {
	
	@Id
	private String id;
	private String clientId;
	private int scenarioNumber;
	private String module;
	private String transactiontype;
	private String selfOalIndicator;
	private String salesExistIndicator;
	private String docType;
	private String chargeCatCode;
	private String chargeCode;
	private String supplierType;
	private String exceptionCode;
	private String preImplementationIndicator;
	private String miscDocumentUtiltype;
	private String miscDocumentIssuedFor; 
	private String invoicetype;
	private String sourceCode;
	private String deliveringCarrierIndicator;
	private String receivingCarrierIndicator;
	private String primeReissueIndicator;
	private String fopType;
	private String rejectionMemoType;
	private String ancillaryService;
	private String bspAgentFlag;
	private String isActive;
	private String createdBy;
	private String createdDate;
	private String lastUpdatedBy;
	private String lastUpdatedDate;
	private String allianceName;
	private String serviceCode;
	private String principleIndicator;

}

package com.sql.smartpra.ods.datatrans.ods_datatrans.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "ticket_mainDTO")
public class TicketMainModel {
	
	@Id
	private String id;
	private String root;
	private String ticketCoupons;
	private String ticketPaymentDetails;
	private String ticketSales;
	private String ticketTaxs;
	private String ticketRemarks;


}

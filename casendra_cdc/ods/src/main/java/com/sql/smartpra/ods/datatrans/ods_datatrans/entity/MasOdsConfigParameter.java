package com.sql.smartpra.ods.datatrans.ods_datatrans.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
@Getter
@Setter
@Entity
@Table(name = "mas_ods_config_parameter",schema="dbo")
public class MasOdsConfigParameter {

	@Id
	@Column(name = "mas_ods_config_parameter_id")
	private int mas_ods_config_parameter_id;
	
	@Column(name = "client_id")
	private String client_id;
	
	@Column(name = "table_name")
	private String table_name;
	
	@Column(name = "column_name")
	private String column_name;
	
	@Column(name = "json_property")
	private String json_property;
	
	@Column(name = "module")
	private String module;
	
	@Column(name = "json_node")
	private String json_node;
	
	@Column(name = "priority")
	private int priority;
	
	@Column(name = "created_by")
	private String created_by;
	
	@Column(name = "created_date")
	private LocalDateTime created_date;
	
	@Column(name = "last_updated_by")
	private String last_updated_by;
	
	@Column(name = "last_updated_date")
	private LocalDateTime last_updated_date;

}

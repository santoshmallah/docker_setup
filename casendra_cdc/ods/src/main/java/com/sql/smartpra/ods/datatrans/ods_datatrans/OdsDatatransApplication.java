package com.sql.smartpra.ods.datatrans.ods_datatrans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class OdsDatatransApplication {

	public static void main(String[] args) {
		SpringApplication.run(OdsDatatransApplication.class, args);
	}

}

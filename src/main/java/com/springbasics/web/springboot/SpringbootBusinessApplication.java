package com.springbasics.web.springboot;

import com.springbasics.web.springboot.Bussines.BusinessService;
import com.springbasics.web.springboot.Bussines.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringbootBusinessApplication implements CommandLineRunner {

	@Autowired
	BusinessService businessService1;
	@Autowired
	BusinessService2 businessService2;

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {

		SpringApplication.run(SpringbootBusinessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Business Service1 DAO {}", businessService1.getDAO());
		LOG.info("Business Service2 DAO {}", businessService2.getDAO());
//		LOG.info("Business Service2 DAO {}", businessService2.getDAOLength());
	}


}

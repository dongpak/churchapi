/**
 * 
 */
package com.churchclerk.churchapi;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author dongp
 *
 */
@EntityScan({"com.churchclerk"})
@ComponentScan({"com.churchclerk"})
@SpringBootApplication
public class ChurchApiApplication {

	private static Logger logger = LoggerFactory.getLogger(ChurchApiApplication.class);

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ChurchApiApplication.class, args);
	}

}

/**
 * @author rohit09103
 * @date 18-Aug-2018
 */
package com.localhost.springboot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rohit09103
 *
 */
@SpringBootApplication
@RestController
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello from docker conmtainer world!";
	}

}

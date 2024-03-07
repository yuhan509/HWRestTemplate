package com.example.hwrestteamplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HwrestteamplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HwrestteamplateApplication.class, args);
	}

}




/*
*
*   homework
 *      1. google RestTemplate
 *      2. create spring boot project
 *         configure rest template in configuration class
 *         inject rest template in service class
 *         send request to "3rd party url" , get response
 *         return to controller layer  -> return to user
 *         /xx
 *         1. get all
 *         2. get all,  request parameter
 *         < 15min
 *
 *         github
*
*
* */
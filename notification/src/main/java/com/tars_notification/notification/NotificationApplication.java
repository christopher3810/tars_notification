package com.tars_notification.notification;

import com.tars_notification.notification.config.KISBase;
import com.tars_notification.notification.connector.KoreaStockConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class NotificationApplication {
	@Autowired
	private KISBase kisBase;

	public static void main(String[] args) {

		SpringApplication.run(NotificationApplication.class, args);
		KoreaStockConnector KSC = new KoreaStockConnector();
		KSC.GetCurrentStockPrice();
	}

}

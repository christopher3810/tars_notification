package com.tars_notification.notification.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Slf4j
public class KISTWebClient
{

    private final String KISTBaseUrl = "https://openapi.koreainvestment.com:9443";

    //TODO : 최상위 클래스에서 WebClientConfig용
    @Bean(name = "WebClient")
    public WebClient WebClient() {

        return WebClient.builder().baseUrl(KISTBaseUrl)
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 * 1024))
            .defaultHeader(
                //Default로 들어가야할 header 설정하기
            )
    }

}

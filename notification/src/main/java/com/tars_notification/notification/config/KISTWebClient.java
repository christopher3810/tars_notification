package com.tars_notification.notification.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class KISTWebClient {

    @Value("${KIS.APP_KEY}")
    private String KSIAppKey;

    @Value("${KIS.APP_SECRET}")
    private String KSIAppSecret;

    @Value("${KIS.BASE_URL}")
    private String BaseUrl;

//    //TODO : 최상위 클래스에서 WebClientConfig용
//    @Bean(name = "WebClient")
//    public WebClient WebClient() {
//
//        return WebClient.builder().baseUrl(BaseUrl)
//            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 * 1024))
//            .defaultHeader(
//                //Default 로 들어가야할 token header 값을 넣어두기
//            )
//    }

    private String GetKSIToken() {
        Mono<String> tokenMono = WebClient.builder().baseUrl(BaseUrl + "/oauth2/tokenP").build()
            .post()
            .header("content-type", "application/json")
            .header("appkey", this.KSIAppKey)
            .header("appsecret", this.KSIAppSecret)
            .exchangeToMono(response -> {
                return response.bodyToMono(String.class);
            });
        return tokenMono.block();
    }

}

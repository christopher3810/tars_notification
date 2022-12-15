package com.tars_notification.notification.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Slf4j
public class KISBase {

    @Value("${KIS.APP_KEY}")
    private String KSIAppKey;

    @Value("${KIS.APP_SECRET}")
    private String KSIAppSecret;

    @Value("${KIS.URL.Base}")
    private String BaseUrl;

    //TODO : 최상위 클래스에서 WebClientConfig용
    @Bean
    public WebClient WebClient() {
        return WebClient.builder().baseUrl(BaseUrl)
            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 * 1024))
            .defaultHeader("authorization", "Bearer " + this.GetKSIToken())
            .defaultHeader("appkey", this.KSIAppKey).defaultHeader("appsecret", this.KSIAppSecret)
            .build();

    }

    private String GetKSIToken() {
        log.info("Start Request KSI Token");
        String tokenMono = WebClient.builder().baseUrl(BaseUrl + "/oauth2/tokenP").build().post()
            .header("content-type", "application/json").header("appkey", this.KSIAppKey)
            .header("appsecret", this.KSIAppSecret).retrieve().bodyToMono(String.class).block();
        return new Gson().fromJson(tokenMono, JsonObject.class).get("access_token").getAsString();
    }

}

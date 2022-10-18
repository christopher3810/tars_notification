package com.tars_notification.notification.connector;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public interface RestTemplateConnector {


    // REST API 를 요청하는 주체
    RestTemplate restTemplate;

    // REST API 반환값에 대한 변환을 위해서 미리 선언
    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // 요청 URL
    String API_URL = "https://484b1157-aa28-4204-9ade-098041a7aca8.mock.pstmn.io/rest/test";

    // 요청 URL 로 UriComponents 생성
    private static final UriComponents URI_COMPONENTS
        = UriComponentsBuilder.fromUriString(API_URL)
        .encode().build();


    // *** static 초기화 부분은 너무 길어서 이후에는 표기 안합니다! ***
    static {
        // 참고로 Patch Method 를 쓰기 위해서는
        // HttpComponentsClientHttpRequestFactory를 사용해야 한다!
        HttpComponentsClientHttpRequestFactory factory
            = new HttpComponentsClientHttpRequestFactory();

        factory.setConnectTimeout(5000);
        factory.setReadTimeout(5000);
        factory.setBufferRequestBody(false);

        restTemplate = new RestTemplate(factory);
        restTemplate.getMessageConverters()
            .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        // Response 한글 깨짐 방지

    }


}

package com.tars_notification.notification.connector;

import com.tars_notification.notification.config.KISBase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class KoreaStockConnector {

    //TODO: Stock Quotation API 뿐만 아니라 공통으로 필요한 Field 들을 갖춘
    // 상위 Abstract 객체 만들어야함 -> 필드가 가변적이기 때문에 abstract class 템플릿 메서드 패턴이 맞음.
    // interface로 기능추상화를 하기에는 메서드 명칭이 rest이기 때문에 힘들어 보임
    // bean으로 webclient 기본 객체를 부여받고 connector는 abstract -> connect class 구조가 좋아 보인다.


    private final KISBase kisBase;

    public void GetCurrentStockPrice(String stockType, String stockId) throws Exception {
        String tr_id = "FHKST01010100";
        String uri = "/uapiidomesticstock/v1/quotations/inquire-price";
        try {
            Mono<String> stringMono = kisBase.WebClient().get().uri(builder -> builder.path(uri)
                .queryParam("fid_cond_mrkt_div_code", "J")
                .queryParam("fid_inpput_iscd", "000660")
                .build()
            ).header("tr_id", tr_id).retrieve().bodyToMono(String.class);
            System.out.println("stringMono = " + stringMono.toString());

        } catch (Exception e) {
            log.info("Exception has Occurred when Request GetCurrent APi");
        } finally {
            // 로직 보고 결정
        }
    }
}

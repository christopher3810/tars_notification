package com.tars_notification.notification.connector;

import com.tars_notification.notification.config.KISTWebClient;
import com.tars_notification.notification.constants.KSIApiDataFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class KoreaStockConnector {

    //TODO: Stock Quotation API 뿐만 아니라 공통으로 필요한 Field 들을 갖춘
    // 상위 Abstract 객체 만들어야함 -> 필드가 가변적이기 때문에 abstract class 템플릿 메서드 패턴이 맞음.
    // interface로 기능추상화를 하기에는 메서드 명칭이 rest이기 때문에 힘들어 보임
    // bean으로 webclient 기본 객체를 부여받고 connector는 abstract -> connect class 구조가 좋아 보인다.


    //Spring Bean Field Injection 말고 생성자 injection 확인해보기.
    @Autowired
    KISTWebClient kistWebClient;

    @Value("${KIS.TradingId.Stock-Quotation}")
    private String SQId;

    public void GetCurrentStockPrice() throws Exception {
        String paramData = KSIApiDataFormat.CurrentStockValue.getFormat();
        try {
            //WebClient Connect

        } catch (Exception e) {
            //error 출력
        } finally {
            // 로직 보고 결정
        }
    }
}

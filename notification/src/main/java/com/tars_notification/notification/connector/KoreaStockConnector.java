package com.tars_notification.notification.connector;

import com.tars_notification.notification.constants.KSIApiDataFormat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KoreaStockConnector implements KISAPIConnector{

    public void GetCurrentStockPrice() throws Exception {
        String url = "https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-price";
        String tr_id = "FHKST01010100";
        String paramData = KSIApiDataFormat.CurrentStockValue.getFormat();
        HttpURLConnection KSIUrlConnector = null;
        String responseData = "";
        String returnData = "";
        BufferedReader KsiBr = null;
        StringBuffer sb = new StringBuffer();

        try {
            KSIUrlConnector = GenerateKSIUrl(url, tr_id);
            try{
                OutputStream os = KSIUrlConnector.getOutputStream();
                byte request_data[] = paramData.getBytes("utf-8");
                os.write(request_data);
                os.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            KSIUrlConnector.connect();
            KsiBr = new BufferedReader(new InputStreamReader(KSIUrlConnector.getInputStream(), "UTF-8"));
        } catch (IOException e) {
            KsiBr = new BufferedReader(new InputStreamReader(KSIUrlConnector.getErrorStream(), "UTF-8"));
        } finally {
            try {
                sb = new StringBuffer();
                while ((responseData = KsiBr.readLine()) != null) {
                    sb.append(responseData);
                }
                returnData = sb.toString();
                String responseCode = String.valueOf(KSIUrlConnector.getResponseCode());
                System.out.println("http 응답 코드 : " + responseCode);
                System.out.println("http 응답 데이터 : " + returnData);
                if (KsiBr != null){
                    KsiBr.close();
                }
            } catch (IOException e){
                throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
            }
        }
    }
}

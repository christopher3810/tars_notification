package com.tars_notification.notification.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public interface KISAPIConnector {

    //TODO: open api를 공통 url 포멧까지 config 단에서 넣어서 value로 활용하는게 좋아보임
    // open api url path가 변경되는 경우 -> ex open api v1 -> v2와  같이 api 버전 명세가올라가는 경우
    // 코드레벨에서 수정보다는 conifg 단에서의 string 수정이 빨라보임.
    // interface 활용안에 대해서 생각을 다시 해볼것.
    // url builder의 경우는 util로 뺴는게 나아보임.

    default HttpURLConnection GenerateKSIUrl(String UrlData, String Trid) throws IOException {
        String totalUrl = "";
        totalUrl = UrlData.trim().toString();

        URL url = null;
        HttpURLConnection conn = null;

        String responseData = "";
        BufferedReader br = null;

        StringBuffer sb = new StringBuffer();
        String returnData = "";

        url = new URL(totalUrl);
        conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("authorization", "Bearer {TOKEN}");
        conn.setRequestProperty("appKey", "{Client_ID}");
        conn.setRequestProperty("appSecret", "{Client_Secret}");
        conn.setRequestProperty("personalSeckey", "{personalSeckey}");
        conn.setRequestProperty("tr_id", Trid);
        conn.setRequestProperty("tr_cont", " ");
        conn.setRequestProperty("custtype", "P");
        conn.setRequestProperty("seq_no", " ");
        conn.setRequestProperty("mac_address", "{Mac_address}");
        conn.setRequestProperty("phone_num", "P01011112222");
        conn.setRequestProperty("ip_addr", "{IP_addr}");
        conn.setRequestProperty("hashkey", "{Hash값}");
        conn.setRequestProperty("gt_uid", "{Global UID}");
        conn.setDoOutput(true);
        return conn;
    };
}

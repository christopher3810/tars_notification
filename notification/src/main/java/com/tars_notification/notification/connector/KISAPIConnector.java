package com.tars_notification.notification.connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public interface KISAPIConnector {

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

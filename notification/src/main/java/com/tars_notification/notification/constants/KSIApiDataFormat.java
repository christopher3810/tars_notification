package com.tars_notification.notification.constants;

public enum KSIApiDataFormat {
    CurrentStockValue("{\n" +
        "    \"fid_cond_mrkt_div_code\": \"FID조건시장분류코드\",\n" +
        "    \"fid_input_iscd\": \"FID입력종목코드\"\n" +
        "}");

    private String format;

    KSIApiDataFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

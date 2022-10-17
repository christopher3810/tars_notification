package com.tars_notification.notification.dto;

public class StockCurrentInfo {

    //요청 성공 실패 여부
    private Boolean isSuccess;
    //대표 시장 한글명
    private String rprs_mrkt_or_name;
    //업종 한글 종목 명
    private String bstp_kor_isnm;
    // 주식 현제가
    private String stck_prp;
    // 전일 대비
    private String prdy_vrss;
    private String prdy_vrss_sign;
    private String prdy_ctrt;

    //price
    private String stck_oprc;
    private String stck_hgpr;
    private String stck_lwpr;
    private String stck_mxpr;
    private String stck_llam;
    private String stck_sdpr;

    //외국인 hts 소진율
    private String hts_frgn_ehrt;
    //외국인 순매수 수량
    private String frgn_ntby_qty;

    //프로그램 순매수 수량
    private String pgtr_ntby_qty;

    //디저항 값
    private String dmrs_val;
    //디지지 값
    private String dmsp_val;

    //상장 주수
    private String lstn_stcn;

    private String per;
    private String pbr;

    private String eps;
    private String bps;

    //외국인 보유 수량
    private String frgn_hldn_qty;


}

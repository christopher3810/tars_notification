package com.tars_notification.notification.service.message;

import com.tars_notification.notification.repository.dto.StockInfoDTO;
import org.thymeleaf.TemplateEngine;

public class StockInfoMessageGenerator implements HtmlMSGGenerator{

    private StockInfoDTO stockInfoDTO;

    private String webUrl;

    private TemplateEngine templateEngine;

    public StockInfoMessageGenerator(final String webUrl, final TemplateEngine templateEngine, final StockInfoDTO stockInfoDTO) {
        this.stockInfoDTO  = stockInfoDTO;
        this.webUrl = webUrl;
        this.templateEngine = templateEngine;
    }

    @Override
    public String generateHtml() {



        return null;
    }
}

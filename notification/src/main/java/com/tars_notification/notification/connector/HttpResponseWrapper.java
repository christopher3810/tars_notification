package com.tars_notification.notification.connector;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class HttpResponseWrapper<T>{

    private HttpResponse response;

    private String responseEntity;

    private Gson gson;

    private Class<T> entityType;

    public HttpResponseWrapper(HttpResponse response, Class<T> entityType) throws IOException {
        gson = new Gson();
        this.response = response;
        this.responseEntity = EntityUtils.toString(response.getEntity());
        this.entityType = entityType;
    }

    public int getStatusCode() {
        return response.getStatusLine().getStatusCode();
    }

    public T getEntity() {
        return gson.fromJson(responseEntity, entityType);
    }

    public String getResponseEntity() {
        return responseEntity;
    }
}

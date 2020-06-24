package com.example.demo.weixin;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import okhttp3.*;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.nio.charset.Charset;

public class AuthUtil {
    public static final String APPID = "wx24294cc4e5eee27c";
    public static final String APPSECRET = "c095658f1b41eeee2b699b6b25c7113f";

    public static JSONObject doGetJson(String url) throws Exception {
//        HttpClient httpClient;
//
//        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
//        httpClient = new org.apache.commons.httpclient.HttpClient(connectionManager);
//        GetMethod getMethod = null;
        try {
//            getMethod = new GetMethod(url);
//            HttpMethodParams params = new HttpMethodParams();
//            params.setVersion(HttpVersion.HTTP_1_0);
//            params.setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
//            getMethod.setParams(params);
//            httpClient.executeMethod(getMethod);
//            return JSONObject.fromObject(new String(getMethod.getResponseBody(),Charset.defaultCharset()));
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> wechatInfo = restTemplate.exchange(url, HttpMethod.GET,null,String.class);
            System.out.println(wechatInfo);
            return JSONObject.fromObject(wechatInfo.getBody());

        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    public static JSONObject post(String url,String json){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .post(body)
                .url(url).
                        build();
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()){
                String string = response.body().string();
                System.out.println(string);
                return JSONObject.fromObject(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

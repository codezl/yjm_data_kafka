package com.zcdl.yjm_data_kafka.helper;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * Created by Administrator on 2019/9/24.
 * Use to
 */
@Component
public class HttpHelper {

    JSONObject post(String url, MultiValueMap<String, String> headers, String body) {
        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(url, requestEntity, String.class);
        if (responseEntity == null || requestEntity.getBody() == null) return null;
        return (JSONObject) JSONObject.parse(responseEntity.getBody());
    }

    JSONObject get(String url, MultiValueMap<String, String> headers) {
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);// 10秒 连接主机的超时时间（单位：毫秒）
        requestFactory.setReadTimeout(10000); // 10秒 从主机读取数据的超时时间（单位：毫秒
        ResponseEntity<String> responseEntity = new RestTemplate(requestFactory).exchange(url, HttpMethod.GET, requestEntity, String.class);
        if (responseEntity == null || responseEntity.getBody() == null) return null;
        return (JSONObject) JSONObject.parse(responseEntity.getBody());
    }

    public MultiValueMap<String, String> getAuthorizationHeader(String contentType) {
        MultiValueMap<String, String> requestHeaders = new LinkedMultiValueMap<>();
        switch (contentType) {
            case "form":
                requestHeaders.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
                break;
            case "json":
                requestHeaders.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                break;
            default:
                break;
        }
        return requestHeaders;
    }

    public JSONObject postXWWWFormUrlEncoded(String url, MultiValueMap<String, String> headers, MultiValueMap<String, Object> body) {
        try {
            //ttpEntity  就是存放 两个字段数据  一个是请求数据  一个是请求头！
            // 从定义上就可以看到   虽然可以 POST 等 提交from  数据  但是好
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            if (responseEntity.getBody() == null) return null;
            return (JSONObject) JSONObject.parse(responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JSONObject postXWWWFormUrl(String url, String contentType, MultiValueMap<String, Object> body) {
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            switch (contentType) {
                case "form":
                    headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
                    break;
                case "json":
                    headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                    break;
                default:
            }
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
            if (responseEntity.getBody() == null) return null;
            return (JSONObject) JSONObject.parse(responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JSONObject postM(String url, String contentType, String body) {
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            switch (contentType) {
                case "form":
                    headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
                    break;
                case "json":
                    headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                    break;
                default:
            }
            HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
            ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(url, requestEntity, String.class);
            if (responseEntity == null || requestEntity.getBody() == null) return null;
            return (JSONObject) JSONObject.parse(responseEntity.getBody());
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public JSONObject getM(String url, String contentType) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        switch (contentType) {
            case "form":
                headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
                break;
            case "json":
                headers.add("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
                break;
            default:
        }
        HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(10000);// 10秒 连接主机的超时时间（单位：毫秒）
        requestFactory.setReadTimeout(10000); // 10秒 从主机读取数据的超时时间（单位：毫秒
        ResponseEntity<String> responseEntity = new RestTemplate(requestFactory).exchange(url, HttpMethod.GET, requestEntity, String.class);
        if (responseEntity == null || responseEntity.getBody() == null) return null;
        return (JSONObject) JSONObject.parse(responseEntity.getBody());
    }

    public static String send(String url, JSONObject jsonObject) throws ParseException, IOException {
        String body = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity s = new StringEntity(jsonObject.toString(), "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPost.setEntity(s);

        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        CloseableHttpResponse response = client.execute(httpPost);
        org.apache.http.HttpEntity entity = response.getEntity();
        if (entity != null) {
            body = EntityUtils.toString(entity, "UTF-8");
        }
        EntityUtils.consume(entity);
        response.close();
        return body;
    }

    public static String send(String url, JSONObject jsonObject, String Auth) throws ParseException, IOException {
        String body = "";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity s = new StringEntity(jsonObject.toString(), "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPost.setEntity(s);

        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        httpPost.setHeader("Authorization", Auth);

        CloseableHttpResponse response = client.execute(httpPost);
        org.apache.http.HttpEntity entity = response.getEntity();
        if (entity != null) {
            body = EntityUtils.toString(entity, "UTF-8");
        }
        EntityUtils.consume(entity);
        response.close();
        return body;
    }

    public static String sendDate(String url, JSONObject jsonObject, String Auth) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity s = new StringEntity(jsonObject.toString(), "utf-8");
        s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        httpPost.setEntity(s);
        return "";
    }

}

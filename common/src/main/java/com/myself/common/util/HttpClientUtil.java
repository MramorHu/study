package com.myself.common.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HttpClientUtil {

    public static String doPost(String url, Map<String,String> headerMap,String body){
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpPost httpPost=new HttpPost(url);
        if(headerMap!=null && !headerMap.isEmpty()){
            for (String key:headerMap.keySet()) {
                httpPost.setHeader(key,headerMap.get(key));
            }
        }
        CloseableHttpResponse httpResponse=null;
        String responseBody="";
        try {
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(new StringEntity(body));
            httpResponse=httpClient.execute(httpPost);
            responseBody= EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseBody;
    }

    public static String doGet(String url, Map<String,String> headerMap,Map<String,Object> requestMap){
        CloseableHttpClient httpClient=HttpClients.createDefault();
        CloseableHttpResponse httpResponse=null;
        String responseBody="";
        try{
            URIBuilder uriBuilder=new URIBuilder(url);
            if(requestMap!=null && !requestMap.isEmpty()){
                List<NameValuePair> nameValuePairs=new LinkedList<>();
                for (String key:requestMap.keySet()) {
                    nameValuePairs.add(new BasicNameValuePair(key,requestMap.get(key).toString()));
                }
                uriBuilder.setParameters(nameValuePairs);
            }
            HttpGet httpGet=new HttpGet(uriBuilder.build());
            httpGet.setHeader("Content-type", "application/json");
            if(headerMap!=null && !headerMap.isEmpty()){
                for (String key:headerMap.keySet()) {
                    httpGet.setHeader(key,headerMap.get(key));
                }
            }
            httpResponse=httpClient.execute(httpGet);
            responseBody=EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseBody;
    }

    public static void main(String[] args) {
        String a=doPost("http://192.168.10.157:8101/api/open/pump/report",new HashMap(){{
            put("appKey","aaaa");
            put("appSecret","1111qq");
        }}, JSONObject.toJSONString(1));

        System.out.println(a);
    }
}

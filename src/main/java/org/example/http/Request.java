package org.example.http;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.example.jenkins.HttpResponseObj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class Request {
    private static AuthCache loginBasicHttpAuth(URI uri,HttpHost host,String username, String password){
        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(host, basicAuth);
        return authCache;
    }
    public static HttpResponseObj getRequest(String urlString) throws IOException {
        HttpResponseObj responseObj = new HttpResponseObj();
        URI uri = URI.create(urlString);
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String result = EntityUtils.toString(response.getEntity());
        responseObj.setResult(result);
        responseObj.setHeaders(response.getAllHeaders());
        responseObj.setStatusCode(response.getStatusLine().getStatusCode());
        response.close();
        httpClient.close();
        return responseObj;
    }
    public static String uploadFile(String urlString, String username, String password, File file) throws IOException {
        URI uri = URI.create(urlString);
        HttpHost host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(uri.getHost(), uri.getPort()),
                new UsernamePasswordCredentials(username, password));
        EntityBuilder builder = EntityBuilder.create();
        //builder.setFile(file);
        FileInputStream fileInputStream = new FileInputStream(file);
       // builder.setBinary(fileInputStream.);
        AuthCache authCache = loginBasicHttpAuth(uri,host,username,  password);
        CloseableHttpClient httpClient =
                HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        HttpPut httpPut = new HttpPut(uri);
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);
        httpPut.setEntity(builder.build());
        HttpResponse response = httpClient.execute(host, httpPut, localContext);
        return EntityUtils.toString(response.getEntity());
    }
    private static void uploadFileTest() throws IOException {
        String urlString = "http://192.168.3.230:8621/repository/external-artifact/test1/test2/c1/v3/test4.txt";
        String username = "admin";
        String password = "grimmauld12";
        File file = new File("/tmp/glances-root.log");
        String result = uploadFile(urlString,username,password,file);
        System.out.println(result);
    }
    public static void main(String[] args) throws IOException {
        //HttpResponseObj responseObj = getRequest("http://127.0.0.1:8100/api/task/trigger/check/git-tag-test/v2.0.10/746556428ec31e3146a8e31443cb713");
        //System.out.println(responseObj.getResult());
        uploadFileTest();
    }
}

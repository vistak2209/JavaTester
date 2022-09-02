package org.example.jenkins;
import org.json.*;
import com.fasterxml.jackson.core.JsonParser;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;

public class JenkinsTrigger {
    //String JENKINS_URL = "http://user:gNouIkl2ca1t@54.226.181.123/job/RemoteTriggerExample/build?token=abc-123";
    public static void main(String args[]) throws IOException, InterruptedException {
        //String JENKINS_URL = "http://admin:1176d73f29c48b6337ef9a9a7c9af37225@192.168.3.191:8080/job/TagTest/buildWithParameters?token=AutoPacking&artifactFilePath=build/libs/git-tag-test-1.0.0.jar&artifactFileType=jar&componentVerson=1.0.6&buildTask=build&gradlewPath=./gradlew";
        //getRequest(JENKINS_URL);
        //System.out.println(scrape(JENKINS_URL,"admin","1176d73f29c48b6337ef9a9a7c9af37225"));
        trigger("admin","1176d73f29c48b6337ef9a9a7c9af37225");
    }
    public static void trigger(String username, String password) throws IOException, InterruptedException {
        String triggerUrl = "http://192.168.3.191:8080/job/TagTest/buildWithParameters?token=AutoPacking&artifactFilePath=build/libs/git-tag-test-1.0.0.jar&artifactFileType=jar&componentVerson=1.0.6&buildTask=build&gradlewPath=./gradlew";
        HttpResponseObj triggerResponseObj = scrape(triggerUrl,username,password);
        String queueUrl="";

        for (Header header : triggerResponseObj.getHeaders()) {
            if(header.getName().equals("Location")){
                queueUrl=header.getValue();
            }
            System.out.println("Key : " + header.getName()
                    + " ,Value : " + header.getValue());
        }
        queueUrl+="api/json";
        String executableUrl="";
        while (true){
            HttpResponseObj queueResponseObj = scrape(queueUrl,username,password);
            String result =queueResponseObj.getResult();
            System.out.println(result);
            JSONObject resultBbj = new JSONObject(result);
            System.out.println(resultBbj.toString());
            if (resultBbj.keySet().contains("executable")){
                executableUrl = resultBbj.getJSONObject("executable").getString("url");
                System.out.println(executableUrl);
                break;
            }
            Thread.sleep(500);

        }
        executableUrl+="api/json";

        while(true){
            HttpResponseObj taskInfoResponseObj = scrape(executableUrl,username,password);
            String result =taskInfoResponseObj.getResult();
            System.out.println(result);
            JSONObject resultBbj = new JSONObject(result);
            boolean isProgress = resultBbj.getBoolean("inProgress");
            if(!isProgress) break;
            Thread.sleep(1000);
        }
        System.out.println("Done");
        //JenkinsQueueInfo jenkinsQueueInfo = JsonUtils.getInstance().readValue(result,JenkinsQueueInfo.class);
        //JsonUtils.getInstance().re
        //System.out.println();
    }
    public static String getRequest(String url) throws IOException {
        String content= "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
                //FileUtils.writeStringToFile(new File("D:\\baidu.html"), content, "UTF-8");
                System.out.println(content);

                //System.out.println("内容长度："+content.length());
            }
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
            return content;
        }

    }
    public static HttpResponseObj scrape(String urlString, String username, String password)
            throws ClientProtocolException, IOException {
        HttpResponseObj responseObj = new HttpResponseObj();
        URI uri = URI.create(urlString);
        HttpHost host = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(new AuthScope(uri.getHost(), uri.getPort()),
                new UsernamePasswordCredentials(username, password));
        // Create AuthCache instance
        AuthCache authCache = new BasicAuthCache();
        // Generate BASIC scheme object and add it to the local auth cache
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(host, basicAuth);
        CloseableHttpClient httpClient =
                HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
        HttpGet httpGet = new HttpGet(uri);
        // Add AuthCache to the execution context
        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);

        CloseableHttpResponse response = httpClient.execute(host, httpGet, localContext);
        String result = EntityUtils.toString(response.getEntity());
        responseObj.setResult(result);
        responseObj.setHeaders(response.getAllHeaders());
        responseObj.setStatusCode(response.getStatusLine().getStatusCode());
        //for(Header header: response.getHeaders());
        //System.out.println("Location "+response.getHeaders("Location").);
        /*
        String queueUrl="";
        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            if(header.getName().equals("Location")){
                queueUrl=header.getValue();
            }
            System.out.println("Key : " + header.getName()
                    + " ,Value : " + header.getValue());
        }
        queueUrl+="api/json";
        */
        //System.out.println("result: "+result);
        response.close();
        httpClient.close();
        return responseObj;
    }
}

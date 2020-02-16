package com.example.exercise.security;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import javax.net.ssl.SSLContext;

import com.example.exercise.model.ProductDto;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserAuthIntegTests {

    @Value("${server.port}")
    private Resource port;

    private URI base;
    private RestTemplate restTemplate;
    
    @Value("${server.ssl.key-store}")
    private Resource p12Location;

    @Value("${server.ssl.key-store-password}")
    private String p12Password;

    @Before
    public void setUp() throws Exception {
        base = new URI("https://localhost:9000/admin/save");
    }

    @Test
    public void givenAdminUserInHeader_whenSendingAdminApiRequest_thenReturnStatus1() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("username", "admin");
        headers.add("password", "admin");

        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(p12Location.getFile(), p12Password.toCharArray()).build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        
        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        restTemplate = new RestTemplate(factory);

        ProductDto product = new ProductDto(20L,"testProduct","test", "small", 10, "USD", "red");
        HttpEntity<Object> request = new HttpEntity<Object>(product, headers); 

        Integer status = restTemplate.postForObject(base, request, int.class);
        assertThat(status.intValue()).isEqualTo(1);
    }

    @Test
    public void givenUserInHeader_whenSendingAdminApiRequest_thenReturnStatusDifferentThan1() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("username", "user");
        headers.add("password", "user");

        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(p12Location.getFile(), p12Password.toCharArray()).build();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        
        HttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        restTemplate = new RestTemplate(factory);

        ProductDto product = new ProductDto(20L,"testProduct","test", "small", 10, "USD", "red");
        HttpEntity<Object> request = new HttpEntity<Object>(product, headers); 

        Integer status = restTemplate.postForObject(base, request, int.class);
        assertThat(status.intValue()).isNotEqualTo(1);
    }
    
}
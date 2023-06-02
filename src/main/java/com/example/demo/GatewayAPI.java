package com.example.demo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class GatewayAPI {
    private static final String catalogueAdress = "http://localhost:1990";

    private static final String inventoryAdress = "http://localhost:1991";

    private static final String orderAdress = "http://localhost:1992";

    @RequestMapping(value = "/catalogue{path:.+}", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
    public ResponseEntity<String> catalogue(HttpServletRequest request) {
        return proxyRequest(request, catalogueAdress);
    }

    @RequestMapping(value = "/inventory{path:.+}", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
    public ResponseEntity<String> inventor(HttpServletRequest request) {
        return proxyRequest(request, inventoryAdress);
    }

    @RequestMapping(value = "/orders{path:.+}", method = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
    public ResponseEntity<String> order(HttpServletRequest request) {
        return proxyRequest(request, orderAdress);
    }

    private ResponseEntity<String> proxyRequest(HttpServletRequest request, String serviceUrl) {
        HttpMethod method = HttpMethod.valueOf(request.getMethod());

        String url = serviceUrl + request.getRequestURI();


        HttpHeaders headers = new HttpHeaders();

        Enumeration<String> headerNames = request.getHeaderNames();


        while (headerNames.hasMoreElements())
        {
            String headerName = headerNames.nextElement();

            if (!headerName.equalsIgnoreCase("Host"))
            {
                headers.set(headerName, request.getHeader(headerName));
            }
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);


        return restTemplate.exchange(url, method, httpEntity, String.class);
    }
}

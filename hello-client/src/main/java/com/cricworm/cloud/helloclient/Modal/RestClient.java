package com.cricworm.cloud.helloclient.Modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/client/test/")
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String hitServer() throws URISyntaxException {
        return restTemplate.getForObject(new URI("http://hello-server/server/test/"), String.class);
    }
}

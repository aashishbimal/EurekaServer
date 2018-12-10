package com.cricworm.cloud.helloserver.Modal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/server/test/")
public class RestServer {

    @GetMapping
    public String hitServer() throws URISyntaxException {
        return "Hello World";
    }
}

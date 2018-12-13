package com.cricworm.cloud.helloclient.Modal;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/rest/test/")
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    /*#https://github.com/Netflix/Hystrix/wiki/configuration
    https://www.programcreek.com/java-api-examples/?api=com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty

    #Default Value is 20 Which Means Minimum 20 Request is required to break the circuit.
    hystrix.command.default.circuitBreaker.requestVolumeThreshold=2

    #sleeping window time period sets the amount of time, after tripping the circuit, to reject requests before allowing
    #attempts again to determine if the circuit should again be closed.Its value is defaulted to 5000 milliSeconds
    hystrix.command.default.circuitBreaker.sleepWindowInMilliseconds=10000 */

    @HystrixCommand(fallbackMethod = "fallback", commandKey = "circuitBreakerKey", groupKey = "circuitBreakerKey",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "4"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
            })
    @GetMapping
    public String hitServer() throws URISyntaxException {
        return restTemplate.getForObject(new URI("http://hello-server/server/test/"), String.class);
    }

    public String fallback(Throwable hystrixCommand){
        return "Oops!! Seems Service Down. Please Get Back in A while";
    }
}

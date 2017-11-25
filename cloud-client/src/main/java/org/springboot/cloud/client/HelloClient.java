package org.springboot.cloud.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Eric Zhao
 * @date 2017/11/25
 */
@Service
public class HelloClient {
    private final Logger logger = LoggerFactory.getLogger(HelloClient.class);

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultHello")
    public String hello(String name) {
        String res = restTemplate.getForEntity("http://HELLO-SERVER/hello?name=" + name, String.class).getBody();
        logger.info("received {}", res);
        return res;
    }

    public String defaultHello(String name) {
        return "default hello " + name;
    }
}

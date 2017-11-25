package org.springboot.cloud.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HelloClient implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(HelloClient.class);

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void run(String... args) {
        String res = restTemplate.getForEntity("http://HELLO-SERVER/hello?name=test", String.class).getBody();
        logger.info("received {}", res);
    }
}

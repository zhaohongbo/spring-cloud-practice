package org.springboot.cloud.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Eric Zhao
 * @date 2017/11/25
 */
@Component
public class HelloCommand implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(HelloCommand.class);

    @Autowired
    HelloClient helloClient;

    @Autowired
    HelloService helloService;

    @Override
    public void run(String... args) {
       callHelloClient();
       callHelloService();
    }
    private void callHelloClient() {
        for (int i = 0; i < 3; i++) {
            String res = helloClient.hello("test");
            logger.info("client received {}", res);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                logger.warn("exception {}", e);
                Thread.currentThread().interrupt();
            }
        }
    }

    private void callHelloService() {
        for (int i = 0; i < 1000; i++) {
            String res = helloService.hello("test");
            logger.info("service received {}", res);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                logger.warn("exception {}", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}

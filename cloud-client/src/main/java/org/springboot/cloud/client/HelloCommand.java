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

    @Override
    public void run(String... args) {
        for (int i = 0; i < 1000; i++) {
            String res = helloClient.hello("test");
            logger.info("received {}", res);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                logger.warn("exception {}", e);
                Thread.currentThread().interrupt();
            }
        }
    }
}

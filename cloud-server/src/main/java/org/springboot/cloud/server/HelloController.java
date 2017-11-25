package org.springboot.cloud.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eric Zhao
 * @date 2017/11/25
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello(String name) {
        logger.info("received {}", name);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            logger.warn("exception {}", e);
            Thread.currentThread().interrupt();
        }
        return "hello " + name;
    }
}

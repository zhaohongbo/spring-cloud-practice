package org.springboot.cloud.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Eric Zhao
 * @date 2017/11/25
 */
@Component
public class HelloServiceFallbackImpl implements HelloService {
    @Override
    public String hello(@RequestParam("name") String name) {
        return "feign hello " + name;
    }
}

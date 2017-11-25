package org.springboot.cloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Eric Zhao
 * @date 2017/11/25
 */
@FeignClient(name="hello-server", fallback = HelloServiceFallbackImpl.class)
public interface HelloService {
    @RequestMapping(value = "/hello")
    String hello(@RequestParam("name") String name);
}

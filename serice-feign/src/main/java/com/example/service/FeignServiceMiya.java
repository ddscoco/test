package com.example.service;

import com.example.service.impl.FeignServiceMiyaImplFB;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-miya",fallback = FeignServiceMiyaImplFB.class)
public interface FeignServiceMiya {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String home(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/miya",method = RequestMethod.GET)
    String infoFromFeignClient();
}


package com.example.service;

import com.example.service.impl.FeignServiceHiImplFB;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = FeignServiceHiImplFB.class)
public interface FeignServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    String infoFromFeignClient();

    @RequestMapping(value = "/miya",method = RequestMethod.GET)
    String callHomeFromFeignService();
}


package com.example.service.impl;

import com.example.service.FeignServiceHi;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceHiImplFB implements FeignServiceHi {
//public class FeignServiceHiImpl {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public String infoFromFeignClient(){
        return "sorry,info method failed";
    }

    @Override
    public String callHomeFromFeignService(){
        return "sorry,miya method failed";
    }
}


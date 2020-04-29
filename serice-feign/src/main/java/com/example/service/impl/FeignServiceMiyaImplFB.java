package com.example.service.impl;

import com.example.service.FeignServiceMiya;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceMiyaImplFB implements FeignServiceMiya {
    @Override
    public String home(String name) {
        return "sorry,hi method failed "+name;
    }

    @Override
    public String infoFromFeignClient(){
        return "sorry,info method failed";
    }
}


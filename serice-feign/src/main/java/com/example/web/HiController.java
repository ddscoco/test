package com.example.web;

import com.example.service.FeignServiceHi;
import com.example.service.FeignServiceMiya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    private FeignServiceHi feignServiceHi;
    @Autowired
    private FeignServiceMiya feignServiceMiya;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name){

        return feignServiceHi.sayHiFromClientOne(name)+feignServiceMiya.home(name);
    }

    @RequestMapping(value = "/feign",method = RequestMethod.GET)
    public String info(){

        return feignServiceHi.infoFromFeignClient()+feignServiceMiya.infoFromFeignClient();
    }
}

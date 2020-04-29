package com.example;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {

        //该过滤器顺序要 > 5，才能得到 serviceid
        return FilterConstants.PRE_DECORATION_FILTER_ORDER+1;
    //    return 0;
    }

    @Override
    public boolean shouldFilter() {

        //对指定的serviceid过滤，如果要过滤所有服务，直接返回 true
        RequestContext ctx=RequestContext.getCurrentContext();
        String serviceId=(String)ctx.get(FilterConstants.SERVICE_ID_KEY);
         if("service-feign".equals(serviceId)){
             return false;
         }
        return true;

    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                //ctx.getResponse().getWriter().write("token is empty");
                ctx.setResponseBody("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}

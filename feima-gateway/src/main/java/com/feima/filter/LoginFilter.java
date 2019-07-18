/*
package com.feima.filter;

import com.alibaba.fastjson.JSON;
import com.feima.service.AuthService;
import com.google.common.collect.Maps;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

*/
/**
 * 身份校验过虑器
 *
 * @author Administrator
 * @version 1.0
 **//*


@Component
public class LoginFilter extends ZuulFilter {

    @Autowired
    private AuthService authService;

    //过虑器的类型
    @Override
    public String filterType() {
        */
/**
         pre：请求在被路由之前执行

         routing：在路由请求时调用

         post：在routing和errror过滤器之后调用

         error：处理请求时发生错误调用

         *//*

        return "pre";
    }

    //过虑器序号，越小越被优先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //返回true表示要执行此过虑器
        return true;
    }

    //过虑器的内容
    //测试的需求：过虑所有请求，判断头部信息是否有Authorization，如果没有则拒绝访问，否则转发到微服务。
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到request
        HttpServletRequest request = requestContext.getRequest();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //取cookie中的身份令牌
        String tokenFromCookie = authService.getTokenFromCookie(request);
        if (StringUtils.isEmpty(tokenFromCookie)) {
            //拒绝访问
            accessDenied();
            return null;
        }
        //从header中取jwt
        String jwtFromHeader = authService.getJwtFromHeader(request);
        if (StringUtils.isEmpty(jwtFromHeader)) {
            //拒绝访问
            accessDenied();
            return null;
        }
        //从redis取出jwt的过期时间
        long expire = authService.getExpire(tokenFromCookie);
        if (expire < 0) {
            //拒绝访问
            accessDenied();
            return null;
        }

        return null;
    }


    */
/**
     * 拒绝访问
     *//*

    private void accessDenied() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        //拒绝访问
        requestContext.setSendZuulResponse(false);
        //设置响应代码
        requestContext.setResponseStatusCode(200);
        //构建响应的信息
        Map<String, Object> responseResult = Maps.newHashMap();
        responseResult.put("success", false);
        responseResult.put("code", 10001);
        responseResult.put("message", "此操作需要登陆系统！");

        //转成json
        String jsonString = JSON.toJSONString(responseResult);
        requestContext.setResponseBody(jsonString);
        //转成json，设置contentType
        response.setContentType("application/json;charset=utf-8");
    }


}
*/

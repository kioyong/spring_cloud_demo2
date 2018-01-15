package com.yong.gateway.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * @acthor yong.a.liang
 * @date 2018/01/03
 */
public class UserInfoPreFilter extends ZuulFilter{

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        return null;
    }

//    private void setupUserInfo
}

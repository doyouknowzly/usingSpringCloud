package com.zly.springcloud.filter;

import com.netflix.zuul.ExecutionStatus;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class FirstZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //pre：路由之前
        //routing：路由之时
        //post： 路由之后
        //error：发送错误调用
        return "pre";
    }


    @Override
    public int filterOrder() {
        //filterOrder：过滤的顺序, 0优先度最高
        return 0;
    }

    public boolean shouldFilter() {
        //这里可以写逻辑判断，是否要过滤
        return true;
    }


    @Override
    public ZuulFilterResult runFilter() {
        //这里没有覆写父类的runFilter，因为父类已经定义了一些状态码的约定，并会调用interface里的run()的实现方法
        //所以，覆写下面的run()方法即可
        //run方法不抛异常就会返回success
        return super.runFilter();

    }

    public Object run() throws ZuulException {
        //核心的过滤逻辑

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //一般token是写header或body里，这里我本地测试就简单点用url参数了
        String token = request.getParameter("token");

        if(token != null && token.startsWith("user")){
            return null;
        }else {
            try {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(401);
                ctx.getResponse().getWriter().write("token invalid");
            } catch (IOException e) {
                return null;
            }
        }

        return new ZuulFilterResult(ExecutionStatus.FAILED);
    }
}

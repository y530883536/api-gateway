package com.ycf.blackWhiteList;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//这里要生效就要把@Componet打开让它注入组件，现在注释掉为了处理其他业务
//@Component
public class RequestOriginParserDefinition implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String serviceName = request.getParameter("serviceName");
        if(StringUtils.isEmpty(serviceName)) {
            throw new RuntimeException("serviceName is null");
        }
        return serviceName;
    }
}

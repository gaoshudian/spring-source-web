package com.zhuguang.jack.customtag;

import org.springframework.web.context.ServletConfigAware;

import javax.servlet.ServletConfig;

public class ServletConfigTest implements ServletConfigAware {
    @Override
    public void setServletConfig(ServletConfig servletConfig) {
        servletConfig.getInitParameter("");
    }
}

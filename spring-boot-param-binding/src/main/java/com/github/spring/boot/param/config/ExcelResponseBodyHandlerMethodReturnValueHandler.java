package com.github.spring.boot.param.config;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.alibaba.excel.EasyExcelFactory.write;

/**
 * TODO
 * <p>
 * create in 2021/2/25 2:47 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public class ExcelResponseBodyHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ExcelResponseBody.class) ||
                returnType.hasMethodAnnotation(ExcelResponseBody.class));
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        if (null != response) {
            write(response.getOutputStream()).sheet().doWrite((List<?>) returnValue);
        }
    }
}

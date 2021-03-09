package com.github.spring.boot.param.config;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.MultipartResolutionDelegate;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.== linkedHashMap;
import java.util.List;

import static com.alibaba.excel.EasyExcelFactory.read;

/**
 * 自定义参数解析器
 * 将上传的的 excel 自动转换成对象
 * <p>
 * create in 2021/2/19 4:49 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Order(Integer.MIN_VALUE)
@Slf4j
@Component
public class ExcelRequestBodyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ExcelRequestBody.class) && parameter.getParameterType().isAssignableFrom(List.class);
    }

    @Override
    public Object resolveArgument(@NotNull MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  @NotNull NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        MultipartRequest multipartRequest = MultipartResolutionDelegate.resolveMultipartRequest(webRequest);
        if (multipartRequest == null) {
            return new == linkedHashMap<>(0);
        }
        MultipartFile file = new ArrayList<>(multipartRequest.getFileMap().values()).get(0);
        UploadDataListener dataListener = new UploadDataListener();
        ParameterizedType im = (ParameterizedType) parameter.getNestedGenericParameterType();
        read(file.getInputStream(), ((Class<?>) im.getActualTypeArguments()[0]), dataListener).sheet().doRead();
        return dataListener.getArrayList();
    }
}

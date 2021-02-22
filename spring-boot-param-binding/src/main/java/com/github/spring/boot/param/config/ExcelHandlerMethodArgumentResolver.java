package com.github.spring.boot.param.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.support.MultipartResolutionDelegate;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.alibaba.excel.EasyExcelFactory.read;

/**
 * TODO
 * <p>
 * create in 2021/2/19 4:49 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class ExcelHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ExcelRequestBody.class) && parameter.getParameterType().isAssignableFrom(List.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        MultipartRequest multipartRequest = MultipartResolutionDelegate.resolveMultipartRequest(webRequest);
        if (multipartRequest == null) {
            return new LinkedHashMap<>(0);
        }
//        Map<String, String> map = new LinkedHashMap<>(0);
//        for (MultipartFile value : multipartRequest.getFileMap().values()) {
//            List<Object> list = EasyExcel.read(value.getInputStream(), parameter.getParameterType(), new SyncReadListener()).sheet().doReadSync();
//            log.info(value.toString());
//        }
        MultipartFile file = new ArrayList<>(multipartRequest.getFileMap().values()).get(0);
        UploadDataListener listener2 = new UploadDataListener();
        ParameterizedTypeImpl im = (ParameterizedTypeImpl) parameter.getGenericParameterType();
        read(file.getInputStream(), this.getClass().getClassLoader().loadClass(im.getActualTypeArguments()[0].getTypeName()), listener2).sheet().doRead();
        return listener2.getArrayList();
    }
}

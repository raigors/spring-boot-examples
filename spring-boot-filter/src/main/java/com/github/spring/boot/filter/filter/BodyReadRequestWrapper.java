package com.github.spring.boot.filter.filter;

import io.micrometer.core.instrument.util.IOUtils;
import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 创建时间为 下午6:44 2019/12/7
 * 项目名称 spring-boot-filter
 * </p>
 *
 * @author 石少东
 * @version 0.0.1
 * @since 0.0.1
 */

public class BodyReadRequestWrapper extends HttpServletRequestWrapper {

    @Getter
    private final String body;

    public BodyReadRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream inputStream = request.getInputStream();
        String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        inputStream.close();
        this.body = content;
    }

    @Override
    public ServletInputStream getInputStream() {
        return getServletInputStream(new ByteArrayInputStream(body.getBytes()));
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    @NotNull
    @Contract(value = "_ -> new", pure = true)
    private ServletInputStream getServletInputStream(ByteArrayInputStream byteArrayIns) {
        return new ServletInputStream() {

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() {
                return byteArrayIns.read();
            }
        };
    }

}

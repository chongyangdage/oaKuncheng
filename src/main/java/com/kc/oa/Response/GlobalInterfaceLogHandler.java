package com.kc.oa.Response;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
@ControllerAdvice
public class GlobalInterfaceLogHandler implements ResponseBodyAdvice<Object>, RequestBodyAdvice {

    private String bodyParams = "无";

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n请求访问地址：{}");
        sb.append("\n请求方式：{}");
        sb.append("\n请求body参数：{}");
        sb.append("\n操作人：{}");
        sb.append("\n返回结果：{}");

        String username = "获取服务当前用户信息";

        Gson gson = new Gson();

        log.info(sb.toString(),
                request.getURI(),
                request.getMethodValue(),
                getBodyParams(),
                username,
                gson.toJson(body));
        return body;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
        return inputMessage;
    }

    @SneakyThrows
    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        setBodyParams(body);
        return body;
    }

    @Override
    public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return body;
    }

    private void setBodyParams(Object body) throws IOException {
        this.bodyParams = "body转json字符串";
    }

    private String getBodyParams() {
        String bodyParams = "无";
        if (!bodyParams.equals(this.bodyParams)) {
            bodyParams = this.bodyParams;
            this.bodyParams = "无";
        }
        return bodyParams;
    }
}

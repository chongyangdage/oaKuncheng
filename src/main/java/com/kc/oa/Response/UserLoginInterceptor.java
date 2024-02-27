package com.kc.oa.Response;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 获取 http的header中获得 token信息
        String token=request.getHeader("token");
        // OPTIONS为预检请求，直接放行
        if ("OPTIONS".equals(request.getMethod().toUpperCase())) {
            return true;
        }
        //token不存在
        if (token == null || token.equals("")) {
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer=response.getWriter();
            Map map=new HashMap<>();
            map.put("code",700);
            map.put("msg","token缺失");
            // 初始化ObjectMapper对象
            ObjectMapper objectMapper = new ObjectMapper();
            ;writer.write(objectMapper.writeValueAsString(map));
            return false;
        }
        //验证token
        boolean sub = JwtUtil.checkToken(token);
        if (!sub) {

            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer=response.getWriter();
            Map map=new HashMap<>();
            map.put("code",700);
            map.put("msg","token失效或已过期");
            // 初始化ObjectMapper对象
            ObjectMapper objectMapper = new ObjectMapper();
            ;writer.write(objectMapper.writeValueAsString(map));
            return false;
        }
        //更新token有效时间 (如果需要更新其实就是产生一个新的token)
//        if (JWTUtils.isNeedUpdate(token)){
//            String newToken = JWTUtils.createToken(sub);
//            response.setHeader(JWTUtils.USER_LOGIN_TOKEN,newToken);
//        }
        return true;
    }
}


package com.kc.oa.Response;

import com.kc.oa.entity.User;
import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtil {

    /**
     * 定义过期时间
     */
    private static final long EXPIRATION_TIME = 8888888888886400000L;
    private static final String  SECRETKEY = "kcoa";
    /**
     * 生成token
     * @param user
     * @return
     */
    public static String generateToken(User user){ //secretKey 密钥
        return Jwts.builder()
                .setIssuedAt(new Date())  //设置JWT的发行时间为当前时间
                .claim("userName", user.getUserName())
                .claim("id", user.getId())
               .setExpiration(new Date(System.currentTimeMillis()+System.currentTimeMillis())) //设置JWT的过期时间为当前时间加上预定义的EXPIRATION_TIME
                .signWith(SignatureAlgorithm.HS512,SECRETKEY)  //使用HS512算法和传入的secretKey对JWT进行签名，以确保其安全性
                .compact();  //将JWT对象转换为紧凑的字符串表示形式
    }


    /**
     * 解析token,验证是否失效
     * @param token
     * @return
     */
    public static boolean checkToken(String token){


        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRETKEY)  //secretKey 密钥
                    .parseClaimsJws(token) //生成的token
                    .getBody();
        } catch (Exception e) {
         return false;
        }

        return true;


}

    /**
     * 解析token,获取用户名
     * @param token
     * @return
     */
    public static Object getSubjectFromTokenById(String token){

        Claims claims = Jwts.parser()
                .setSigningKey(SECRETKEY)  //secretKey 密钥
                .parseClaimsJws(token) //生成的token
                .getBody();

        return  claims.get("id");
    }

}
package com.kc.oa.controller;

import clojure.lang.Obj;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.kc.oa.Response.JwtUtil;
import com.kc.oa.Response.ResultUtil;
import com.kc.oa.entity.User;
import com.kc.oa.impl.UserServerImpl;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServerImpl userServerImpl;
    @Resource
    private RedisTemplate redisTemplate;
    // json处理的对象
    ObjectMapper mapper = new ObjectMapper();

/**new JdkSerializationRedisSerializer()
 * 用来处理请求地址映射的注解，可用于类或方法上。
 * 用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
 */
    @GetMapping("/login")
    public ResultUtil login( String userName,  String passWord) {

        ResultUtil resultUtil=userServerImpl.Login(userName,passWord);

       return resultUtil;


    }


    @GetMapping("/addUser")
    public ResultUtil addUser(User user) {
     
        ResultUtil resultUtil;
        int row=userServerImpl.insertUser(user);
        try {
//            String string = mapper.writeValueAsString(user);
            // 保存到缓存中

        }catch (Exception e){
            e.printStackTrace();
        }
        if(row==1){

//            String str=(String) redisTemplate.opsForValue().get("user01094950-df69-11ee-aa0f-ebc38c599576");
//           Object str1= JSONObject.parse(str);

            resultUtil=ResultUtil.success("添加成功", null);
        }else{
            resultUtil=ResultUtil.fail("添加失败",null);
        }
//        BoundValueOperations<String, String> boundValueOps = redisTemplate.boundValueOps("user"+user.getId());

        return resultUtil;


    }



    @GetMapping("/selectUser")
    public ResultUtil getUsersByCondition(String userName,int current,int size) {

        ResultUtil resultUtil;
         List <User> user=userServerImpl.getUsersByCondition(userName,current,size);
        int total=userServerImpl.selectListTotal(userName);
        if(user!=null){
            resultUtil=ResultUtil.successTotal("查询成功",user,total);
        }else{
            resultUtil=ResultUtil.fail("查询失败",user);
        }
        return resultUtil;


    }



    @GetMapping("/getUsersTotal")
    public ResultUtil getUsersTotal() {

        ResultUtil resultUtil;

        int total=userServerImpl.selectListTotal(null);
        if(total>=0){
            resultUtil=ResultUtil.successTotal("查询成功",null,total);
        }else{
            resultUtil=ResultUtil.fail("查询失败",null);
        }
        return resultUtil;


    }


    @GetMapping("/deleUser")
    public ResultUtil deleUser(User user) {

        ResultUtil resultUtil;
        int row=userServerImpl.deleUser(user);
        if(row==1){
            resultUtil=ResultUtil.success("删除成功",null);
        }else{
            resultUtil=ResultUtil.fail("删除失败",null);
        }
        return resultUtil;


    }


    @GetMapping("/editUser")
    public ResultUtil editUser(User user) {

        ResultUtil resultUtil;
        int row=userServerImpl.editUser(user);
        if(row==1){
            resultUtil=ResultUtil.success("修改成功",null);
        }else{
            resultUtil=ResultUtil.fail("修改失败",null);
        }
        return resultUtil;


    }

}

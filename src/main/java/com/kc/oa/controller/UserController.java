package com.kc.oa.controller;

import com.kc.oa.Response.JwtUtil;
import com.kc.oa.Response.ResultUtil;
import com.kc.oa.entity.User;
import com.kc.oa.impl.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServerImpl userServerImpl;

/**
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
        if(row==1){
            resultUtil=ResultUtil.success("添加成功",null);
        }else{
            resultUtil=ResultUtil.fail("添加失败",null);
        }
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

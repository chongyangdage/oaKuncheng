package com.kc.oa.impl;

import com.kc.oa.Response.JwtUtil;
import com.kc.oa.Response.ResultUtil;
import com.kc.oa.entity.User;
import com.kc.oa.mapper.UserMapper;
import com.kc.oa.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {
    @Autowired
    private UserMapper userMapper;


    @Override
    public ResultUtil Login(String userName, String passWord) {
        User user = userMapper.Login(userName,null);
        ResultUtil resultUtil;
        if(user==null){
            resultUtil=ResultUtil.fail("用户名不存在",user);
            return  resultUtil;
        }
        if(user.getPassWord().equals(passWord)){
            resultUtil=ResultUtil.success("登陆成功",user);
        }else{
            resultUtil=ResultUtil.fail("密码错误",user);
        }
        return  resultUtil;
    }

    @Override
    public int insertUser(User user) {
//        , String userToken
      String token= JwtUtil.generateToken(user);
      User userNow=user;
        user.setUserToken(token);
      int row= userMapper.insertUser(user);
      System.out.print(row);
        return row;

    }


    public int selectListTotal(String userName){


        return userMapper.selectListTotal(userName);
    }


    public List<User> getUsersByCondition(String userName,  int current, int size){
        int startIndex = (current - 1) * size;
        // 调用Mapper接口中定义好的方法进行查询操作

        return userMapper.selectList(userName,startIndex,size);
    }

    public int deleUser(User user){


        return userMapper.deleUser(user);
    }


    public int editUser(User user){


        return userMapper.editUser(user);
    }


}

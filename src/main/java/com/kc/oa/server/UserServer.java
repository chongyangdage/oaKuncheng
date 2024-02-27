package com.kc.oa.server;

import com.kc.oa.Response.ResultUtil;
import com.kc.oa.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserServer {
    //登录
    ResultUtil Login(String userName, String passWord);

    //添加人员

    int insertUser(User user);

//    分页查询
    List<User> getUsersByCondition(String userName,  int current, int size);

    //修改人员
    int editUser(User user);


    //删除人员
    int deleUser(User user);


}

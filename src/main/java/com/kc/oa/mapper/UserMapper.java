package com.kc.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.oa.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper  extends BaseMapper{
    //登录
   User Login(@Param("userName") String userName, @Param("passWord") String passWord);

   //添加人员
   int insertUser(User user);


   //查询人员
   List <User> selectUser(User user);

   //修改人员
   int editUser(User user);


   //删除人员
   int deleUser(User user);


   //    条件查询
   List<User> selectList(@Param("userName") String userName,@Param("current") int current,@Param("size") int size);


   int selectListTotal(@Param("userName") String userName);

}

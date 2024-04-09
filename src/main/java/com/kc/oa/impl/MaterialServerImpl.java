package com.kc.oa.impl;

import com.kc.oa.Response.JwtUtil;
import com.kc.oa.Response.ResultUtil;
import com.kc.oa.entity.Material;
import com.kc.oa.entity.User;
import com.kc.oa.mapper.MaterialMapper;
import com.kc.oa.mapper.UserMapper;
import com.kc.oa.server.MaterialServer;
import com.kc.oa.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServerImpl implements MaterialServer {
    @Autowired
    private MaterialMapper materialMapper;




    @Override
    public int insertMater(Material materiaL) {

      int row= materialMapper.insertMater(materiaL);
        return row;

    }

    public int selectListTotal(){


        return materialMapper.selectListTotal();
    }
    public int selectListTotal(String title){


        return materialMapper.selectListTotal(title);
    }


    public List<Material> getMaterByCondition(String title,  int current, int size){
        int startIndex = (current - 1) * size;
        // 调用Mapper接口中定义好的方法进行查询操作

        return materialMapper.selectList(title,startIndex,size);
    }

    public int deleMater(Material materiaL){


        return materialMapper.deleMater(materiaL);
    }


    public int editMater(Material materiaL){


        return materialMapper.editMater(materiaL);
    }


}

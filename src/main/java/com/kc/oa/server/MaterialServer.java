package com.kc.oa.server;

import com.kc.oa.entity.Material;

import java.util.List;

public interface MaterialServer {


    //添加材料

    int insertMater(Material material);

//    分页查询
    List<Material> getMaterByCondition(String title,  int current, int size);

    //修改材料
    int editMater(Material material);


    //删除材料
    int deleMater(Material material);

    //删除材料价格总数
    int selectListTotal();
}

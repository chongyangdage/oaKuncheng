package com.kc.oa.controller;

import com.kc.oa.Response.ResultUtil;
import com.kc.oa.entity.Material;
import com.kc.oa.entity.User;
import com.kc.oa.impl.MaterialServerImpl;
import com.kc.oa.impl.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaterialController {

    @Autowired
    private MaterialServerImpl materialServerImpl;

/**
 * 用来处理请求地址映射的注解，可用于类或方法上。
 * 用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。
 */



    @GetMapping("/addMaterial")
    public ResultUtil addMaterial(Material material) {
     
        ResultUtil resultUtil;
        int row=materialServerImpl.insertMater(material);
        if(row==1){
            resultUtil=ResultUtil.success("添加成功",null);
        }else{
            resultUtil=ResultUtil.fail("添加失败",null);
        }
        return resultUtil;


    }



    @GetMapping("/selectMaterial")
    public ResultUtil getMaterialByCondition(String title,int current,int size) {

        ResultUtil resultUtil;
         List <Material> material=materialServerImpl.getMaterByCondition(title,current,size);
        int total=materialServerImpl.selectListTotal(title);
        if(material!=null){
            resultUtil=ResultUtil.successTotal("查询成功",material,total);
        }else{
            resultUtil=ResultUtil.fail("查询失败",material);
        }
        return resultUtil;


    }



    @GetMapping("/deleMaterial")
    public ResultUtil deleUser(Material material) {

        ResultUtil resultUtil;
        int row=materialServerImpl.deleMater(material);
        if(row==1){
            resultUtil=ResultUtil.success("删除成功",null);
        }else{
            resultUtil=ResultUtil.fail("删除失败",null);
        }
        return resultUtil;


    }

//查询材料总价格
@GetMapping("/selectListTotal")
public ResultUtil selectListTotal() {

    ResultUtil resultUtil;
    int row=materialServerImpl.selectListTotal();
    if(row>=0){
        resultUtil=ResultUtil.success("查询成功",null);
        resultUtil.setTotal(row);
    }else{
        resultUtil=ResultUtil.fail("查询失败",null);
    }
    return resultUtil;


}

    @GetMapping("/editMaterial")
    public ResultUtil editMaterial(Material material) {

        ResultUtil resultUtil;
        int row=materialServerImpl.editMater(material);
        if(row==1){
            resultUtil=ResultUtil.success("修改成功",null);
        }else{
            resultUtil=ResultUtil.fail("修改失败",null);
        }
        return resultUtil;


    }

}

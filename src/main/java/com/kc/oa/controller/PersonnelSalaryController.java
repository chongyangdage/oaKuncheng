package com.kc.oa.controller;

import com.kc.oa.Response.ResultUtil;
import com.kc.oa.entity.PersonnelSalary;
import com.kc.oa.impl.PersonnelSalaryImpl;
import com.kc.oa.impl.UserServerImpl;
import com.kc.oa.server.PersonnelSalaryServer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PersonnelSalaryController {

    @Autowired
    private PersonnelSalaryServer personnelSalaryServer;



    @GetMapping("/addPay")
    public ResultUtil addPay(PersonnelSalary personnelSalary) {
       ResultUtil resultUtil;
       int personnelSalary1 =personnelSalaryServer.insertPay(personnelSalary);
        if(personnelSalary1==1){
            resultUtil= ResultUtil.success("添加成功",personnelSalary);
        }else{
            resultUtil=ResultUtil.fail("添加失败",personnelSalary);
        }
        return resultUtil;
    }


    @GetMapping("/selectPay")
    public ResultUtil selectPay(String userId, @DateTimeFormat(pattern = "yyyy-MM-dd") Date years) {
        ResultUtil resultUtil;
        List<PersonnelSalary> personnelSalary1 =personnelSalaryServer.selectPay(userId,years);
        if(personnelSalary1!=null){
            resultUtil= ResultUtil.success("查询成功",personnelSalary1);
        }else{
            resultUtil=ResultUtil.fail("查询失败",personnelSalary1);
        }
        return resultUtil;
    }



    @GetMapping("/editPay")
    public ResultUtil editPay(PersonnelSalary personnelSalary) {
        ResultUtil resultUtil;
        int personnelSalary1 =personnelSalaryServer.editPay(personnelSalary);
        if(personnelSalary1==1){
            resultUtil= ResultUtil.success("修改成功",personnelSalary1);
        }else{
            resultUtil=ResultUtil.fail("修改失败",personnelSalary1);
        }
        return resultUtil;
    }



    @GetMapping("/delePay")
    public ResultUtil delePay(int id) {
        ResultUtil resultUtil;
        int personnelSalary1 =personnelSalaryServer.delePay(id);
        if(personnelSalary1==1){
            resultUtil= ResultUtil.success("删除成功",personnelSalary1);
        }else{
            resultUtil=ResultUtil.fail("删除失败",personnelSalary1);
        }
        return resultUtil;
    }
}

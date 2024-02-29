package com.kc.oa.server;

import com.kc.oa.entity.Files;
import com.kc.oa.entity.PersonnelSalary;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface PersonnelSalaryServer {
    //添加人员工资
    int insertPay(PersonnelSalary personnelSalary);


    //查询工资
    List <PersonnelSalary> selectPay(String userId, @DateTimeFormat(pattern = "yyyy-MM-dd") Date years);


    //删除工资
    int delePay(int id);

    //修改工资
    int editPay(PersonnelSalary personnelSalary);


}

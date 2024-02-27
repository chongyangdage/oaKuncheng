package com.kc.oa.mapper;

import com.kc.oa.entity.PersonnelSalary;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface PersonnelSalaryMapper {
    //添加人员工资
    int insertPay(PersonnelSalary personnelSalary);


    //查询工资
    List <PersonnelSalary> selectPay(@Param("userId") int userId,@Param("years") @DateTimeFormat(pattern = "yyyy-MM-dd") Date years);


    //删除工资
    int delePay(int id);

    //修改工资
    int editPay(PersonnelSalary personnelSalary);


}

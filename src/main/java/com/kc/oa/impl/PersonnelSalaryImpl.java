package com.kc.oa.impl;

import com.kc.oa.entity.PersonnelSalary;
import com.kc.oa.mapper.PersonnelSalaryMapper;
import com.kc.oa.server.PersonnelSalaryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
@Service
public class PersonnelSalaryImpl implements PersonnelSalaryServer {

    @Autowired
    PersonnelSalaryMapper personnelSalaryMapper;


    @Override
    public int insertPay(PersonnelSalary personnelSalary) {
     int row=  personnelSalaryMapper.insertPay(personnelSalary);
        return row;
    }

    @Override
    public List<PersonnelSalary> selectPay(int userId, @DateTimeFormat(pattern = "yyyy-MM-dd") Date years) {
        List<PersonnelSalary> perList=  personnelSalaryMapper.selectPay(userId,years);
        return perList;
    }

    @Override
    public int delePay(int id) {
        int row=  personnelSalaryMapper.delePay(id);
        return row;
    }

    @Override
    public int editPay(PersonnelSalary personnelSalary) {
        int row=  personnelSalaryMapper.editPay(personnelSalary);
        return row;

    }
}

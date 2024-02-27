package com.kc.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.oa.entity.Files;

import java.util.List;

public interface FileMapper extends BaseMapper{


   //添加文件
   int insertFile(Files file);


   //查询文件
   List <Files> selectFile(String fileId);


   //删除文件
   int deleFile(String id);







}

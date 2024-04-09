package com.kc.oa.impl;

import com.kc.oa.entity.Files;
import com.kc.oa.mapper.FileMapper;
import com.kc.oa.server.FileServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServerImpl implements FileServer {
    @Autowired
    private FileMapper FileMapper;

    @Override
    public int insertFile(Files file) {
        int row= 0;
        try {
            row = FileMapper.insertFile(file);
        } catch (Exception e) {
            throw e;
        }
        return row;
    }

    @Override
    public List<Files> selectFile(String fileId) {

       return FileMapper.selectFile(fileId);

    }

    @Override
    public int deleFile(String id) {
      return FileMapper.deleFile(id);
    }
}

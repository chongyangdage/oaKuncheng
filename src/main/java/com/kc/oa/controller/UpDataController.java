package com.kc.oa.controller;

import com.kc.oa.Response.ResultUtil;
import com.kc.oa.entity.Files;
import com.kc.oa.entity.User;
import com.kc.oa.impl.FileServerImpl;
import com.kc.oa.impl.UserServerImpl;
import com.kc.oa.mapper.FileMapper;
import com.kc.oa.server.FileServer;

import cljs.tagged_literals.JSValue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class UpDataController {
    @Autowired
    private FileServerImpl fileServer;
    /**
     * 文件存储路径
     */
    @Value("${myapp.fileUrl}")
    private String path;

    @PostMapping("/uploadFile")
    public ResultUtil  uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("fileId") String fileId) throws IOException {
        ResultUtil result;
        File parentFile=new File(path);
        if (!parentFile.exists()) {
            //如果文件存储路径，则创建
            parentFile.mkdirs();
        }
        // 获取上传文件的原始文件名
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        // 生成新的文件名，以避免重复
        String newFilename = generateNewFilename(originalFilename);
        //MultipartFile会对上传的文件做一些封装，所以要获得源文件名要用file.getOriginalFilename()
        File myFile=new File(parentFile,newFilename);
        //下面就是java的一些基本东西了，创建文件，获取输入输出流，读写文件
        FileOutputStream out=null;
        InputStream in=null;
        try {
            myFile.createNewFile();
            out=new FileOutputStream(myFile);
            in=file.getInputStream();
            byte[] b=new byte[10*1024];
            int n;
            while ((n=in.read(b))!=-1){
                out.write(b,0,n);
                out.flush();
            }
            System.out.println(path+newFilename);
            Files newFie=new Files();
            newFie.setFileId(fileId);
            newFie.setOriginalName(originalFilename);
            newFie.setName(newFilename);
            newFie.setUrl(path);
            fileServer.insertFile(newFie);
        List<Files> files = fileServer.selectFile(fileId);
            result=ResultUtil.success("查询成功",files);
        } catch (IOException e) {
            e.printStackTrace();
            result= ResultUtil.fail("查询失败",null);
        }finally {
            //最后关闭输入输出流，避免造成内存泄漏
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        }
        return result;
    }


    private String generateNewFilename(String originalFilename) {
        // 可以根据需要自定义新的文件名生成逻辑，例如添加时间戳或随机字符串
        // 这里简单地将原始文件名前加上时间戳
        long timestamp = System.currentTimeMillis();
        return timestamp + "_" + originalFilename;
    }
        @PostMapping("/deleFile")

    public ResultUtil deleFile(String id){
        ResultUtil result;
      int row=  fileServer.deleFile(id);
      if(row==1){
          result= ResultUtil.success("删除成功");
      }else{
          result= ResultUtil.fail("删除失败");
      }
        return result;
    }




    @PostMapping("/selectFile")

    public ResultUtil selectFile(String fileId){
        ResultUtil result;
       List<Files> data=  fileServer.selectFile(fileId);
        if(data!=null){
            result= ResultUtil.success("查询成功",data);
        }else{
            result= ResultUtil.fail("查询失败");
        }
        return result;
    }
}

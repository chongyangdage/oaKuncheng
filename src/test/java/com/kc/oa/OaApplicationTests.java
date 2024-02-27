package com.kc.oa;


import com.kc.oa.Response.JwtUtil;
import com.kc.oa.entity.User;
import com.kc.oa.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OaApplicationTests {
@Resource
private UserMapper userMapper;

  @Test
  public void contextLoads() {
   Object a= JwtUtil.getSubjectFromTokenById("eyJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3MDcwNTUyNTEsInVzZXJOYW1lIjoi5YiY6YeN6ZizIiwiaWQiOiI3NzEyIiwiZXhwIjoxNzA3MTQxNjUxfQ.HiS1Ys3W6PfbXefQM2FzV1lPMjkeWmvMChC449rd2R6jy7jtfMMxNHdC2_dMmaGb4K3FUorDYwb10jmRm6aIZg");
   System.out.print(a);
    }

}

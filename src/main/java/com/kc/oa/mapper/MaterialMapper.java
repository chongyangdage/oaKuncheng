package com.kc.oa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kc.oa.entity.Material;
import com.kc.oa.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialMapper extends BaseMapper{


   //添加材料

   int insertMater(Material material);

   //    分页查询
   List<Material> getMaterByCondition(String title,  int current, int size);

   //修改材料
   int editMater(Material material);


   //删除材料
   int deleMater(Material material);
   //    条件查询
   List<Material> selectList(@Param("title") String title,@Param("current") int current,@Param("size") int size);


   int selectListTotal(@Param("title") String title);

//查询材料总价钱
   int selectListTotal();
}

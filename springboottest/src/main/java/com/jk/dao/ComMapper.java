package com.jk.dao;

import com.jk.model.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

@Mapper
public interface ComMapper {
    @Select("select * from t_gouhuo where 1=1 ${str}")
    public  List<Commodity> comList(@Param("str") String str);
    @Select("select * from t_gouhuo ")
    List<Commodity> jourList();
    
}

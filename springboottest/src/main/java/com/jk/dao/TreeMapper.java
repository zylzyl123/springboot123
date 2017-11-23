package com.jk.dao;

import com.jk.model.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 */
@Mapper
public interface TreeMapper {
    @Select("select * from t_menu where pid =#{id}")
    List<Menu> isExsitChildrenNode(Menu menu);

    @Select("select * from t_menu where pid is null ")
    List<Menu> getPowerRootNode(Menu menu);

    @Select("select * from t_menu ")
    List<Menu> getTreeList1(Menu menu);

    
}

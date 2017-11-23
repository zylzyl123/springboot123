package com.jk.service;

import com.jk.model.Menu;

import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 */
public interface TreeService {
    public List<Menu> getTreeList(Menu menu) throws Exception;
    List<Menu> getTreeList1(Menu menu) throws Exception;
    
}

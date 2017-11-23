package com.jk.service.impl;

import com.jk.dao.TreeMapper;
import com.jk.model.Menu;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/14.
 */
@Service
public class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeMapper treeMapper;
    @Override
    public List<Menu> getTreeList(Menu menu) throws Exception {
        List<Menu> powerRootNode = new ArrayList<Menu>();
        if (null != menu.getId()) {
//id有值取出所有字节点（用于点击事件展示子节点）
            powerRootNode = treeMapper.isExsitChildrenNode(menu);
        } else {
//id 没值(展示pid为空的根文件夹)
            powerRootNode = treeMapper.getPowerRootNode(menu);
        }
        List<Menu> powerList = new ArrayList<Menu>();
        for (Menu power2 : powerRootNode) {
//当前节点有子节点
            if (isExsitChildrenNode(power2)) {
//设置为父文件夹
                power2.setIsParent("true");
            }
            powerList.add(power2);
        }
        return powerList;
    }

    @Override
    public List<Menu> getTreeList1(Menu menu) throws Exception {
       return treeMapper.getTreeList1(menu);
    }

    public boolean isExsitChildrenNode(Menu ztree) throws Exception {
        boolean flag = false;
//返回子节点
        List<Menu> exsitChildrenNode = treeMapper.isExsitChildrenNode(ztree);
        if (exsitChildrenNode!=null) {
            flag = true;
        }
        return flag;
    }

}

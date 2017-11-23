package com.jk.controller;

import com.jk.model.Menu;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.alibaba.fastjson.JSON;

/**
 * Created by Administrator on 2017/11/14.
 */
@RestController
public class TreeController extends BaseController{
    @Autowired
    private TreeService treeService;
  @RequestMapping("/treeList")
    public void getTree(HttpServletRequest request, String callback,Menu menu,HttpServletResponse response) throws Exception {
       List<Menu>  list= treeService.getTreeList1(menu);
       String json = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss");

       //加上返回参数
       json=callback+"("+json+")";
       super.outString(json, response);

   }
}

package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.model.Commodity;
import com.jk.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/15.
 */
@RestController
public class ComController extends BaseController{
        @Autowired
        private ComService comService;

   @RequestMapping("/comList")
    public void comList(HttpServletRequest request,String callback,HttpServletResponse response,Commodity com){

       List<Commodity> list=comService.comList(com);
        String json = JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss");

        json=callback+"("+json+")";
       super.outString(json, response);

    }
    @RequestMapping("/findP")
    public void pageList(Integer page,Integer rows,String callback,HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println(page);

        List<Commodity> jourList = comService.jourList();
        Map result = new HashMap();

        Integer s = page;
        Integer e = page + rows;
        if(e > jourList.size()){
            e = jourList.size();
        }
        result.put("rows", jourList.subList(s, e));
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String json = JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss");
        String jsonStr = "callback(" + json + ")";
        try {
            response.getWriter().print(jsonStr);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}

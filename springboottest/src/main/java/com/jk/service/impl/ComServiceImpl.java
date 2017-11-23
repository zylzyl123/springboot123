package com.jk.service.impl;

import com.jk.dao.ComMapper;
import com.jk.model.Commodity;
import com.jk.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */
@Service
public class ComServiceImpl implements ComService {

    @Autowired
    private ComMapper comMapper;
    @Override
    public List<Commodity> jourList() {
        return comMapper.jourList();
    }

    @Override
    public List<Commodity> comList(Commodity com) {
        String str="";
        if(com.getState()!=null &&!"".equals(com.getState())){
            str += " and state = " + com.getState();
        }
        if(com.getDengji()!=null &&!"".equals(com.getDengji())){
            str +=" and dengji = "+ com.getDengji();
        }
        if(com.getStart()!=null &&!"".equals(com.getStart())){
            str +=" and date > " + com.getStart();
        }
        if(com.getEnd()!=null&&!"".equals(com.getEnd())){
            str += " and date < " + com.getEnd();
        }
        str += " limit " + com.getPage() + "," + com.getRows()+"";

        return comMapper.comList(str);
    }



}

package com.jk.service;

import com.jk.model.Commodity;

import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */
public interface ComService {
 List<Commodity> comList(Commodity com);
 List<Commodity> jourList();
}

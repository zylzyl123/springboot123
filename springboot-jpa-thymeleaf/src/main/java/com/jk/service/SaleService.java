package com.jk.service;

import com.jk.model.Sale;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */
public interface SaleService {
   public Page<Sale> getSale(Integer page, Integer size, Sale sale);
}

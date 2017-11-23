package com.jk.controller;

import com.jk.model.Sale;
import com.jk.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */
@Controller
public class SaleController {
    @Autowired
    private SaleService saleService;

    @RequestMapping("/getSale")
    public String getSale(Model model,@RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "size", defaultValue = "5") Integer size, Sale sale){

        Page<Sale> list=saleService.getSale(page,size,sale);
        model.addAttribute("datas", list);
        return "sale/list";
    }

    @RequestMapping("/toadd")
    public String toadd() {
        return "sale/addsale";
    }

}

package com.jk.service.impl;

import com.jk.dao.SaleRepository;
import com.jk.model.Sale;
import com.jk.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Page<Sale> getSale(Integer page, Integer size, final Sale sale) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        Page<Sale> salePage=saleRepository.findAll(new Specification<Sale>(){
            @Override
            public Predicate toPredicate(Root<Sale> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();

                if(null!=sale.getCustom()&&!"".equals(sale.getCustom())){
                    list.add(criteriaBuilder.equal(root.get("custom").as(String.class), sale.getCustom()));
                }
                if(null!=sale.getShenhe()&&!"".equals(sale.getShenhe())){
                    list.add(criteriaBuilder.equal(root.get("shenhe").as(String.class),sale.getShenhe()));
                }
                if(null!=sale.getDengji()&&!"".equals(sale.getDengji())){
                    list.add(criteriaBuilder.equal(root.get("dengji").as(String.class), sale.getDengji()));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));

            }
        },pageable);

        return salePage;
    }
}

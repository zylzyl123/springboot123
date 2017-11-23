package com.jk.dao;

import com.jk.model.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/11/16.
 */
public interface SaleRepository  extends JpaRepository<Sale, Long> {
    Page<Sale> findAll(Specification<Sale> specification, Pageable pageable);
    
}

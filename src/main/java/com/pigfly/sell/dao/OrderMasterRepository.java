package com.pigfly.sell.dao;

import com.pigfly.sell.entity.OrderMaster;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenId(String buyerOpenId, Pageable pageable);
}

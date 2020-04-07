package com.exp.springcloud.dao;

import com.exp.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ylzhao
 * @create 2020/4/5-14:14
 */
@Mapper
public interface PaymentDao {

    public  int add(Payment payment);

    public  Payment getPaymentById(@Param("id")Long id);

}

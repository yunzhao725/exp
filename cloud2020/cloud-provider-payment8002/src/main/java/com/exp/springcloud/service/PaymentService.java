package com.exp.springcloud.service;

import com.exp.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author ylzhao
 * @create 2020/4/5-14:34
 */
public interface PaymentService {
    public  int add(Payment payment);

    public  Payment getPaymentById(@Param("id")Long id);


}

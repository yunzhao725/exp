package com.exp.springcloud.service.impl;

import com.exp.springcloud.dao.PaymentDao;
import com.exp.springcloud.entities.Payment;
import com.exp.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ylzhao
 * @create 2020/4/5-14:34
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    @Resource
    private PaymentDao paymentDao;

    @Override
    public int add(Payment payment) {

        return paymentDao.add(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

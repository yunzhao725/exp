package com.exp.springcloud.controller;

import com.exp.springcloud.entities.CommonResult;
import com.exp.springcloud.entities.Payment;
import com.exp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author ylzhao
 * @create 2020/4/5-14:40
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    /**
     * 新增
     * @param payment
     * @return
     */
    @PostMapping(value = "/payment/add")
    public CommonResult add(@RequestBody Payment payment){

        int result = paymentService.add(payment);

        log.info(serverPort+"***插入结果"+result);

        if(result>0){
            return  new CommonResult(200,serverPort+"插入成功",result);
        }else{
            return  new CommonResult(444,serverPort+"插入失败",null);
        }
    }

    @GetMapping(value ="/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info(serverPort+"***查询参数:"+id);
        Payment vo = paymentService.getPaymentById(id);
        log.info(serverPort+"***查询结果"+vo);
        log.info("bbb");
        if(vo != null){
            return  new CommonResult(200,serverPort+"查询成功",vo);
        }else{
            return  new CommonResult(444,serverPort+"查询无结果",null);
        }
    }
}

package com.exp.springcloud.controller;

import com.exp.springcloud.entities.CommonResult;
import com.exp.springcloud.entities.Payment;
import com.exp.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
     * 获取服务服务信息
     */
    @Resource
    private DiscoveryClient discoveryClient;


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

    @GetMapping("/payment/discovery")
    public  Object discovery() {
        List<String> services = discoveryClient.getServices();

        for (String eleme : services) {
            log.info("***所有服务:" + eleme);
        }

        List<ServiceInstance> insts = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");


        for (ServiceInstance instance : insts) {
            log.info("***getHost:" + instance.getHost());
            log.info("***getServiceId:" + instance.getServiceId());
            log.info("***getUri:" + instance.getUri());
            log.info("***getPort:" + instance.getPort());
            log.info("***getScheme:" + instance.getScheme());


        }

        return this.discoveryClient;
    }



}

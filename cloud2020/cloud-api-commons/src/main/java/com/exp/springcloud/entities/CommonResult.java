package com.exp.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ylzhao
 * @create 2020/4/5-14:09
 */
@Data //get set
@AllArgsConstructor //全参数构造方法
@NoArgsConstructor  //空参数构造方法
public class CommonResult<T> {


    private Integer code;
    private String  message;
    private T   data;



    public CommonResult(Integer code, String message){
        this(code,message,null);
    }



}

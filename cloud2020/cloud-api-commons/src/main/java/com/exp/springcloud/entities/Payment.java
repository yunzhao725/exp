package com.exp.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ylzhao
 * @create 2020/4/5-17:11
 */
@Data //get set
@AllArgsConstructor //全参数
@NoArgsConstructor  //空参数
public class Payment implements Serializable {
    private Long id;
    private String serial;
}

package com.example.beandemo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author:
 * @Description:
 * @Date: Create in 21:18 2022/9/5
 **/
@Component("tea01")
@Scope(value = "prototype")
public class Tea {
    @Value("tea-01")
    private String name;

    @Override
    public String toString() {
        return "Tea{" +
                "name='" + name + '\'' +
                '}';
    }
}

package com.example.beandemo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author:
 * @Description:
 * @Date: Create in 21:17 2022/9/5
 **/
@Component("CoffeeTest")
public class Coffee {

    @Value("coffee")
    private String name;

    @Override
    public String toString() {
        return "Coffee{" +
                "name='" + name + '\'' +
                '}';
    }
}

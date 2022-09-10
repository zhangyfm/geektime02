package com.example.beandemo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author:
 * @Description:
 * @Date: Create in 21:21 2022/9/5
 **/
//@Repository("co")
@Component
public class Coco {

    @Value("zhangsan de coco")
    private String name;

    @Override
    public String toString() {
        return "Coco{" +
                "name='" + name + '\'' +
                '}';
    }
}

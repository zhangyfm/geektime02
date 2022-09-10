package com.example.beandemo;

import javax.annotation.Resource;
import javax.inject.Inject;

import com.example.beandemo.bean.Coco;
import com.example.beandemo.bean.Coffee;
import com.example.beandemo.bean.Tea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BeanDemoApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(BeanDemoApplication.class, args);
	}

	//默认按Type
	//@Autowired
	//@Resource(name="tea")
	@Autowired
	@Qualifier(value="tea01")//指定name
	private Tea tea;

	@Resource
	private Coffee coffee;

	private Coffee coffeeBySet;

	private Tea tea01;

	@Inject
	private Tea tea02;

	private Tea tea03;

	private Coco coco;


	//set注入
	@Autowired
	public void setCoffeeBySet(Coffee coffeeBySet) {
		this.coffeeBySet = coffeeBySet;
	}

	//普通方法注入
	@Autowired
	public void createTea(Tea tea01){
		this.tea01=tea01;
	}

	//构造函数
	@Autowired
	public BeanDemoApplication(Tea tea03,Coco coco) {
		this.tea03 = tea03;
		this.coco = coco;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("Find Tea: {}"+tea);
		log.info("Find tea01: {}"+tea01);//普通方法注入
		log.info("Find one tea: {}"+(tea01==tea));//多例创建实例对象
		log.info("Find tea02: {}"+tea02);//Inject
		log.info("Find tea03: {}"+tea03);//构造函数

		log.info("Find coffee: {}"+coffee);//@Resource
		log.info("Find coffeeBySet: {}"+coffeeBySet);
		log.info("Find coco: {}"+coco);//构造函数
	}
}

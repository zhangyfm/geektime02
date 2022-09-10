package geektime.spring.springbucks.customer;

import java.util.*;

import geektime.spring.springbucks.customer.Utils.CoffeeByXML;
import geektime.spring.springbucks.customer.model.Coffee;
import geektime.spring.springbucks.customer.model.CoffeeOrder;
import geektime.spring.springbucks.customer.model.NewOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class CustomerRunner implements ApplicationRunner {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        getJSONById();
        getXMLByName();
        //getJSONById();
       // readMenu();
        //Long id = orderCoffee();
       // queryOrder(id);
    }

    //访问查询返回单个coffee JSON格式数据
    private void getJSONById() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/coffee/json/{id}");
        Map<String,Object> param =new HashMap<>();
        param.put("id",1);
        builder.uriVariables(param);
        ParameterizedTypeReference<Coffee> ptr =new ParameterizedTypeReference<Coffee>() { };
        ResponseEntity<Coffee> list = restTemplate.exchange(builder.build().toString(), HttpMethod.GET, null, ptr);
        log.info("Coffee: {}", list.getBody());

    }

    /**
     * 返回xml格式
     */
    private void getXMLByName() {

       List<MediaType> acceptableMediaTypes =new ArrayList<>();
        acceptableMediaTypes.add(MediaType.APPLICATION_XML);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(acceptableMediaTypes);
        HttpEntity httpEntity = new HttpEntity(null, headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/coffee/");

        builder.queryParam("name","espresso");

        ResponseEntity<CoffeeByXML> response = restTemplate.exchange(builder.build().toString(),HttpMethod.GET, httpEntity,CoffeeByXML.class);
        log.info("get Coffee by name : {}", response.getBody());


    }

    private void readMenu() {
        ParameterizedTypeReference<List<Coffee>> ptr =
                new ParameterizedTypeReference<List<Coffee>>() {
                };
        ResponseEntity<List<Coffee>> list = restTemplate
                .exchange("http://localhost:8080/coffee/", HttpMethod.GET, null, ptr);
        list.getBody().forEach(c -> log.info("Coffee: {}", c));
    }

    private Long orderCoffee() {
        NewOrderRequest orderRequest = NewOrderRequest.builder()
                .customer("Li Lei")
                .items(Arrays.asList("capuccino"))
                .build();
        RequestEntity<NewOrderRequest> request = RequestEntity
                .post(UriComponentsBuilder.fromUriString("http://localhost:8080/order/").build().toUri())
                .body(orderRequest);
        ResponseEntity<CoffeeOrder> response = restTemplate.exchange(request, CoffeeOrder.class);
        log.info("Order Request Status Code: {}", response.getStatusCode());
        Long id = response.getBody().getId();
        log.info("Order ID: {}", id);
        return id;
    }

    private void queryOrder(Long id) {
        CoffeeOrder order = restTemplate
                .getForObject("http://localhost:8080/order/{id}", CoffeeOrder.class, id);
        log.info("Order: {}", order);
    }
}

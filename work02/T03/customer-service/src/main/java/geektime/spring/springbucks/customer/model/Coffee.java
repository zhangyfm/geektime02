package geektime.spring.springbucks.customer.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {

    private Long id;
    private String name;
    private Money price;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")//设置返回日期参数时的格式
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//设置接收日期参数时的格式
    private Date createTime;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")//设置返回日期参数时的格式
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//设置接收日期参数时的格式
    private Date updateTime;


}

package geektime.spring.springbucks.customer.Utils;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.joda.money.Money;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Author: zhangyufang
 * @Description:
 * @Date: Create in 21:44 2022/9/6
 **/
@XmlRootElement(name = "Coffee") //开始读取的根节点
public class CoffeeByXML implements Serializable {

    @XmlElement(name="id")
    private Long id;

    @XmlElement(name="createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date createTime;

    @XmlElement(name="updateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @XmlJavaTypeAdapter(DateAdapter.class)//日期转换
    private Date updateTime;

    @XmlElement(name="price")
    @XmlJavaTypeAdapter(MoneyAdapter.class)//金额转换
    private Money price;

    @XmlElement(name="name")
    private String name;


    @Override
    public String toString() {
        return "CoffeeByXML{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}

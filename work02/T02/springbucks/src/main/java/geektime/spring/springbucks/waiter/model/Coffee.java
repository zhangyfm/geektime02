package geektime.spring.springbucks.waiter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

@Entity
@Table(name = "T_COFFEE")
@Builder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Coffee") //开始读取的根节点
public class Coffee extends BaseEntity implements Serializable {
    @XmlElement(name="name")
    private String name;
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
            parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;
}

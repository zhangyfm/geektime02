package geektime.spring.springbucks.customer.Utils;

import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * @Author: zhangyufang
 * @Description:
 * @Date: Create in 12:45 2022/9/10
 **/
public class MoneyAdapter extends XmlAdapter<BigDecimal, Money> {

    @Override
    public Money unmarshal(BigDecimal v) throws Exception {
        return Money.of(CurrencyUnit.of("CNY"), v);
    }

    @Override
    public BigDecimal marshal(Money v) throws Exception {
        return v.getAmount();
    }
}

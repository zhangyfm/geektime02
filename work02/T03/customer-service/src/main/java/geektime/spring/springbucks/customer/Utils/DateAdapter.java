package geektime.spring.springbucks.customer.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @Author: zhangyufang
 * @Description:
 * @Date: Create in 12:42 2022/9/10
 **/
public class DateAdapter extends XmlAdapter<String, Date> {

    private SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date unmarshal(String v) throws Exception {
        return yyyyMMddHHmmss.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return yyyyMMddHHmmss.format(v);
    }
}

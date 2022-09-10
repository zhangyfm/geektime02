package geektime.spring.springbucks.customer.support;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class DateDeserializer extends StdDeserializer<Date> {
    protected DateDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        System.out.println("日期解析---");
        System.out.println("日期解析---"+p.getCurrentName());
        System.out.println("日期解析---"+p.getText());
        Date date=new Date();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dat=sp.format(date);
        System.out.println("日期解析---"+dat);
        return date;
    }
}

package geektime.spring.springbucks.customer.support;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class DateSerializer extends StdSerializer<Date> {
    protected DateSerializer() {
        super(Date.class);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dat=sp.format(date);
        jsonGenerator.writeNumber(dat);
    }
}

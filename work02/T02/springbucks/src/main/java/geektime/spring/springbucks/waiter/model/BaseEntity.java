package geektime.spring.springbucks.waiter.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
// 增加了jackson-datatype-hibernate5就不需要这个Ignore了
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    @CreationTimestamp
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")//设置返回日期参数时的格式
    private Date createTime;
    @UpdateTimestamp
    @JsonFormat(shape= JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")//设置返回日期参数时的格式
    private Date updateTime;
}

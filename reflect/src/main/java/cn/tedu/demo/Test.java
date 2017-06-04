package cn.tedu.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//RetentionPolicy.RUNTIME 表示这个注解有效范围保留到软件运行期间，如果不写默认情况是编辑就擦除。
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

}

package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MySQL 配置注解，只需要给 MySQLConfig 类配置注解就可以不再写 username、password 等配置项。
 * 在后续维护中，直接在 MySQLConfig 配置类中修改配置项，不再需要一个个地修改其他的 Servlet。
 *
 * @author zhengrenfu
 * @version 1.0
 * @since 1.5
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseConfig {
  String name();

  String value();
}

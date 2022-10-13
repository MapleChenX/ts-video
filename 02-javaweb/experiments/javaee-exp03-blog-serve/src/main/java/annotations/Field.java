package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 给实体类注入与数据库表格对应的字段，这是因为字段的名称与驼峰命名法存在冲突。
 * 使用此注解能够很好地解决该问题。
 *
 * @author zhengrenfu
 * @version 1.0
 * @since 1.5
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
  String value();
}

package annotations;

import java.lang.annotation.*;

/**
 * 给实体类注入与数据库表格对应的名称，这是因为表格名称与驼峰命名法存在冲突。
 * 使用此注解能够很好地解决该问题。
 *
 * @author zhengrenfu
 * @version 1.0
 * @since 1.5
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
  String name();
}
package utils;

import annotations.DatabaseConfig;
import annotations.Table;
import com.alibaba.fastjson2.JSON;
import configs.MySQLConfig;
import lombok.Getter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 简化 JDBC 操作，甚至只需要一行代码就可以完成增删改查操作。
 * 而你只需要提供一个实体类给对应的增删改查方法，而不需要写重复的代码。
 *
 * @author zhengrenfu
 * @version 1.0
 * @since 1.5
 */
@Getter
public class JdbcOperation<T> {

  private MySQLConfig config;
  private Connection connection;
  private PreparedStatement preparedStatement;
  private ResultSet resultSet;
  private int executedCode;
  private final String tableName;
  private final Field[] objectFields;
  private final ArrayList<String> tableFieldsName = new ArrayList<>();
  private final ArrayList<Object> tableFieldsValue = new ArrayList<>();
  private final Class<?> entityClz;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public JdbcOperation(Class<?> configClz, Class<?> entityClz) {
    this.entityClz = entityClz;
    tableName = entityClz.getAnnotation(Table.class).name();
    objectFields = entityClz.getDeclaredFields();
    try {
      config = (MySQLConfig) configClz.getDeclaredConstructor().newInstance();
      Field[] configFields = configClz.getDeclaredFields();
      for (Field configField : configFields) {
        configField.setAccessible(true);
        configField.set(config, configField.getAnnotation(DatabaseConfig.class).value());
      }
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  public JdbcOperation<T> load(T entity) {
    tableFieldsName.clear();
    tableFieldsValue.clear();
    for (Field objField : objectFields) {
      objField.setAccessible(true);
      try {
        if (objField.get(entity) != null) {
          tableFieldsName.add(objField.getAnnotation(annotations.Field.class).value());
          tableFieldsValue.add(objField.get(entity));
        }
      } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
      }
    }
    try {
      connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return this;
  }

  public JdbcOperation<T> insert() {
    StringBuilder sql = new StringBuilder();
    sql.append("insert into ").append(tableName).append("(");
    for (String tableField : tableFieldsName) { // 1
      sql.append(tableField).append(",");
    }
    sql.deleteCharAt(sql.length() - 1);
    sql.append(") values(");
    for (Object fieldValue : tableFieldsValue) { // 1
      sql.append("'").append(fieldValue).append("',");
    }
    sql.deleteCharAt(sql.length() - 1);
    sql.append(")");
    execute(String.valueOf(sql), true);
    return this;
  }

  public JdbcOperation<T> delete() {
    StringBuilder sql = new StringBuilder();
    sql.append("delete from ").append(tableName).append(" where ");
    int idFieldIndex = 0;
    boolean isIdField = false;
    for (int index = 0; index < tableFieldsName.size(); index++) {
      if (tableFieldsName.get(index).equals("id")) {
        sql.append(tableFieldsName.get(index)).append("=");
        idFieldIndex = index;
        isIdField = true;
      }
    }
    if (!isIdField) {
      try {
        throw new Exception("你没有给实体类设置 ID 字段，delete 语句不完整！");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    sql.append("'").append(tableFieldsValue.get(idFieldIndex)).append("'");
    execute(String.valueOf(sql), true);
    return this;
  }

  public JdbcOperation<T> update() {
    StringBuilder sql = new StringBuilder();
    sql.append("update ").append(tableName);
    int idFieldIndex = 0;
    boolean isIdField = false;
    sql.append(" set ");
    for (int index = 0; index < tableFieldsName.size(); index++) {
      if (tableFieldsName.get(index).equals("id")) {
        idFieldIndex = index;
        isIdField = true;
      } else {
        sql.append(tableFieldsName.get(index)).append("='").append(tableFieldsValue.get(index)).append("',");
      }
    }
    if (!isIdField) {
      try {
        throw new Exception("你没有给实体类设置 ID 字段，update 语句不完整！");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    sql.deleteCharAt(sql.length() - 1);
    sql.append(" where id='").append(tableFieldsValue.get(idFieldIndex)).append("'");
    execute(String.valueOf(sql), true);
    return this;
  }

  public JdbcOperation<T> select(boolean isAll, String where) {
    StringBuilder sql = new StringBuilder();
    if (isAll) {
      sql.append("select * from ").append(tableName);
    } else {
      sql.append("select ");
      for (String tableField : tableFieldsName) {
        sql.append("`").append(tableField).append("`").append(",");
      }
      sql.deleteCharAt(sql.length() - 1);
      sql.append(" from ").append(tableName);
    }
    if (where != null) {
      sql.append(" where ").append(where);
    }
    execute(String.valueOf(sql), false);
    return this;
  }

  public String getJson() {
    String json = JSON.toJSONString(getObject());
    close();
    return json;
  }

  public List<T> getObject() {
    List<T> list = new ArrayList<>();
    if (resultSet == null) try {
      throw new Exception("ResultSet 为空。数据查询是否成功或 select() 函数是否被使用？");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    try {
      while (resultSet.next()) {
        T rebirth = (T) entityClz.getDeclaredConstructor().newInstance();
        for (Field objField : objectFields) {
          if (objField.getType().getName().equals(String.class.getName())) {
            objField.set(rebirth, resultSet.getString(objField.getAnnotation(annotations.Field.class).value()));
          } else if (objField.getType().getName().equals(int.class.getName())) {
            objField.set(rebirth, resultSet.getInt(objField.getAnnotation(annotations.Field.class).value()));
          } else if (objField.getType().getName().equals(java.util.Date.class.getName())) {
            objField.set(rebirth, resultSet.getDate(objField.getAnnotation(annotations.Field.class).value()));
          }
        }
        list.add(rebirth);
      }
    } catch (SQLException | InstantiationException | IllegalAccessException | NoSuchMethodException |
             InvocationTargetException e) {
      throw new RuntimeException(e);
    }
    close();
    return list;
  }

  /**
   * insert、delete、update、select 语句完成拼接之后使用该函数执行。
   *
   * @param sql  SQL 语句
   * @param type executeUpdate：true；executeQuery：false
   */
  private void execute(String sql, boolean type) {
    try {
      preparedStatement = connection.prepareStatement(sql);
      if (type) executedCode = preparedStatement.executeUpdate();
      else resultSet = preparedStatement.executeQuery();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void close() {
    try {
      if (connection != null) connection.close();
      if (preparedStatement != null) preparedStatement.close();
      if (resultSet != null) resultSet.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}

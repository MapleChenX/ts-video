package stage03;


import stage02.LoadConfig;
import stage02.configs.Config;
import stage02.configs.MySQLConfig;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Simple<T> {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private final Config config;

    public Simple(Config config) {
        this.config = config;
    }

    private List<T> inject(ResultSet rs, Class<T> clz) {
        List<T> list = new ArrayList<>();
        try {
            while (rs.next()) {
                T t = clz.getDeclaredConstructor().newInstance();
                for (Field field : clz.getDeclaredFields()) {
                    field.setAccessible(true);
                    if (field.getType().getName().equals(String.class.getName())) {
                        field.set(t, rs.getString(field.getName()));
                    } else if (field.getType().getName().equals(int.class.getName())) {
                        field.set(t, rs.getInt(field.getName()));
                    } else if (field.getType().getName().equals(java.util.Date.class.getName())) {
                        field.set(t, rs.getDate(field.getName()));
                    }
                }
                list.add(t);
            }
        } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<T> selectAll(Class<T> clz) {
        List<T> list;
        try {
            Connection connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
            PreparedStatement statement = connection.prepareStatement("select * from users");
            list = inject(statement.executeQuery(), clz);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}

class Main {
    public static void main(String[] args) {
        MySQLConfig config = new LoadConfig<>(MySQLConfig.class).getConfig();
        List<User> users = new Simple<User>(config).selectAll(User.class);
        System.out.println(Arrays.toString(users.toArray()));
    }
}
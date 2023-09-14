package connectors;

/**
 * @description:
 * @package: connectors
 * @author: zheng
 * @date: 2023/9/13
 */
public class MySqlConnector implements JdbcConnector {

    @Override
    public void connect() {
        System.out.println("连接 MySql 数据库...");
    }

}

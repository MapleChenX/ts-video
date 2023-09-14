package connectors;

/**
 * @description:
 * @package: connectors
 * @author: zheng
 * @date: 2023/9/13
 */
public class SqlServerConnector implements JdbcConnector {

    @Override
    public void connect() {
        System.out.println("连接 SqlServer 数据库...");
    }

}

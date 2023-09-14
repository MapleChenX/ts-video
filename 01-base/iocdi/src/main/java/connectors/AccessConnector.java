package connectors;

/**
 * @description:
 * @package: connectors
 * @author: zheng
 * @date: 2023/9/13
 */
public class AccessConnector implements JdbcConnector {

    @Override
    public void connect() {
        System.out.println("连接 Access 数据库...");
    }

}

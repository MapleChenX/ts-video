package connectors;

/**
 * @description:
 * @package: connectors
 * @author: zheng
 * @date: 2023/9/13
 */
public class OracleConnector implements JdbcConnector {

    @Override
    public void connect() {
        System.out.println("连接 Oracle 数据库...");
    }

}

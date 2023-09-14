package service;

import connectors.JdbcConnector;

/**
 * @description:
 * @package: service
 * @author: zheng
 * @date: 2023/9/13
 */
public class OrderService {

    private final JdbcConnector connector;

    public OrderService(JdbcConnector connector) {
        this.connector = connector;
    }

    public void getOrder() {
        // 1. 连接数据库
        connector.connect();
        // 2. 操作数据库获取数据
        // ...

        System.out.println("获取到了订单信息！");
    }

}

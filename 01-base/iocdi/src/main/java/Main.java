import connectors.MySqlConnector;
import service.OrderService;

/**
 * @description: 客户端，调用者
 * @package:
 * @author: zheng
 * @date: 2023/9/13
 */
public class Main {

    public static void main(String[] args) {
        OrderService orderService = new OrderService(new MySqlConnector());
        orderService.getOrder();
    }

}

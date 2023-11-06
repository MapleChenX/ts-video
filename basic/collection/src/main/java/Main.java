import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @package: PACKAGE_NAME
 * @author: zheng
 * @date: 2023/11/6
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        final List<Integer> synchronizedList = Collections.synchronizedList(arrayList);

        Runnable addTask = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronizedList.add(i);
            }
        };

        Runnable removeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                if (!synchronizedList.isEmpty()) {
                    synchronizedList.remove(synchronizedList.size() - 1);
                }
            }
        };

        Thread thread1 = new Thread(addTask);
        Thread thread2 = new Thread(removeTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.fillInStackTrace();
        }

        System.out.println("ArrayList size: " + synchronizedList.size());
    }

}
import com.yfk.yfwork.common.CommonApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName:CommonTest
 * Author:yufukang
 * Version:1.0
 * Time:2022/8/17 14:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonApplication.class)
public class CommonTest {
    @Test
    public void test() throws InterruptedException {
        Thread thread = new Thread(() ->
        {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("wake up*********");
                throw new RuntimeException(e);
            }
            System.out.println("wake up---------------");
        });
        System.out.println("main");
        Thread.sleep(500);
        thread.interrupt();
        thread.join();
    }

}

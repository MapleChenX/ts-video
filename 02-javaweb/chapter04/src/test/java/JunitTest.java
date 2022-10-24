import org.junit.*;

public class JunitTest {

  @Test
  public void test01() {
    System.out.println("normal test:01");
  }

  @Test
  public void test02() {
    System.out.println("normal test:02");
  }

  @Before
  public void test03() {
    System.out.println("before test");
  }

  @After
  public void test04() {
    System.out.println("after test");
  }

  @BeforeClass
  public static void test05() {
    System.out.println("before class test");
  }

  @AfterClass
  public static void test06() {
    System.out.println("after class test");
  }

}

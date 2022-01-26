import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SavingsAccountTest {
    SavingsAccount sut;
    private static long suiteStartTime;
    private long testStartTime;
    @BeforeAll
    public static void initSuite() {
        System.out.println("Running SavingsAccountTest");
        suiteStartTime = System.nanoTime();
    }
    @AfterAll
    public static void completeSuite() {
        System.out.println("SavingsAccountTest complete: " + (System.nanoTime() - suiteStartTime));
    }
    @BeforeEach
    public void initTest() {
        System.out.println("\nStarting new test");
        testStartTime = System.nanoTime();
    }
    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime));
    }

    @Test
    public void given2Classes_whenOneInheritsFromOther_thenCorrect(){
        // проверить что SavingsAccount класс является подклассом Account
        assertThat(SavingsAccount.class,typeCompatibleWith(Account.class));
    }

    @Test
    public void testConstructor() {
        // given:
        double money = 100;
        String name = "Сберегательный счет";
        double expected = 100;

        // when:
        sut = new SavingsAccount(money, name);

        // then:
        assertThat(sut, hasProperty("name", equalTo(name)));
        assertThat(sut, hasProperty("amount", equalTo(expected)));

    }
    @Test
    public void testConstructorMinus() {
        // given:
        double moneyMinus = -100;
        String name = "Сберегательный счет";
        double expected = 100;

        // when:
        sut = new SavingsAccount(moneyMinus, name);

        // then:
        assertThat(sut, hasProperty("name", equalTo(name)));
        assertThat(sut, hasProperty("amount", equalTo(expected)));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-50, 0, 50})
    public void testPay(double argument) {
        // given:
        sut = new SavingsAccount(100, "Сберегательный счет");
        boolean expected;

        // when:
        expected = sut.pay(argument);

        // then:
        Assertions.assertFalse(expected);
    }

    @Test
    public void testAddMoney() {
        // given:
        double money = 100;
        double amount = 50;
        String name = "Сберегательный счет";
        sut = new SavingsAccount(money, name);
        double expected = 150;

        // when:
        boolean result = sut.addMoney(amount);

        // then:
        Assertions.assertEquals(expected, sut.getAmount());
        Assertions.assertTrue(result);
    }
    @Test
    public void testAddMoneyMinus() {
        // given:
        double money = 100;
        double amount = -50;
        String name = "Сберегательный счет";
        double expected = 100;
        sut = new SavingsAccount(money, name);

        // when:
        boolean result = sut.addMoney(amount);

        // then:
        Assertions.assertEquals(expected, sut.getAmount());
        Assertions.assertFalse(result);
    }
}

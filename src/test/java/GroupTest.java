import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupTest {
    private static long suiteStartTime;
    private long testStartTime;

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running GroupTest");
        suiteStartTime = System.nanoTime();
    }
    @AfterAll
    public static void completeSuite() {
        System.out.println("GroupTest complete: " + (System.nanoTime() - suiteStartTime));
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
    
    @ParameterizedTest
    @EnumSource(value = Group.class, names = { "FRIENDS", "FAMILY", "WORK" })
    void testWithEnumSourceInclude(Group unit) {
        assertTrue(EnumSet.of(Group.FRIENDS, Group.FAMILY, Group.WORK).contains(unit));
    }
}

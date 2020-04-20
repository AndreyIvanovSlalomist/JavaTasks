package task1;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestTask_1_1 {
    @Test
    public void testCheckInputStringIs1MustBeTrue() {
        assertTrue("1 must be true", Task_1_1.checkInputString("1"));
    }

    @Test
    public void testCheckInputStringIs0MustBeFalse() {
        assertFalse("0 must be false", Task_1_1.checkInputString("0"));
    }

    @Test
    public void testCheckInputStringIsAAMustBeFalse() {
        assertFalse("AA must be false", Task_1_1.checkInputString("AA"));
    }

    @Test
    public void testPrintResultIs1MustBe1() {
        assertEquals("1 must be 1", "1", Task_1_1.printResult(1));
    }

    @Test
    public void testPrintResultIs2MustBe2() {
        assertEquals("2 must be 2", "2", Task_1_1.printResult(2));
    }

    @Test
    public void testPrintResultIs3MustBeFoo() {
        assertEquals("3 must be Foo", "Foo", Task_1_1.printResult(3));
    }

    @Test
    public void testPrintResultIs5MustBeBar() {
        assertEquals("5 must be Bar", "Bar", Task_1_1.printResult(5));
    }

    @Test
    public void testPrintResultIs15MustBeFooBar() {
        assertEquals("15 must be FooBar", "FooBar", Task_1_1.printResult(15));
    }
}

package task2;


import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestIncrementor {
    @Test
    public void testIncrementFileis1MustBe1() {
        String fileName = "test.txt";
        Utils.writerToFile(fileName, "0");
        Runnable runnable = new Incrementor(fileName, 1);
        runnable.run();
        assertEquals("1 must be 1", "1", Utils.readFromFile(fileName));
    }
    @Test
    public void testIncrementFileis1MustBe2() {
        String fileName = "test.txt";
        Utils.writerToFile(fileName, "0");
        Runnable runnable = new Incrementor(fileName, 1);
        runnable.run();
        Assert.assertNotEquals("1 must be not 2", "2", Utils.readFromFile(fileName));
    }
}

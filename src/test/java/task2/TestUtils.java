package task2;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestUtils {

    @Test
    public void testCheckInputStringIs1MustBeFalse(){
        assertFalse("1 must be false", Utils.checkInputString("1"));
    }
    @Test
    public void testCheckInputStringIs0MustBeFalse(){
        assertFalse("0 must be false", Utils.checkInputString("0"));
    }

    @Test
    public void testCheckInputStringIsAAMustBeFalse(){
        assertFalse("AA must be false", Utils.checkInputString("AA"));
    }
    @Test
    public void testCheckInputStringIs2MustBeTrue(){
        assertTrue("2 must be true", Utils.checkInputString("2"));
    }
    @Test
    public void testCheckInputStringIs8MustBeTrue(){
        assertTrue("8 must be true", Utils.checkInputString("8"));
    }
    @Test
    public void testWriterToFileIs8MustBereadFromFileIs8(){
        Utils.writerToFile("test.txt", "8");
        assertEquals("8 must be 8", "8", Utils.readFromFile("test.txt"));
    }
    @Test
    public void testWriterToFileIs8MustBereadFromFileIsNot10(){
        Utils.writerToFile("test.txt", "8");
       Assert.assertNotEquals("8 must be not 10", "10", Utils.readFromFile("test.txt"));
    }
}

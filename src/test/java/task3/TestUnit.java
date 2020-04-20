package task3;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestUnit {
    @Test
    public void testDoubleToStringFormat(){
        assertEquals("0,01", "0,01", Unit.doubleToStringFormat(0.01));
    }

}

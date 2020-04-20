package task3;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static task3.UnitConversionList.stringToArray;

public class TestUnitConversionList {
    @Test
    public void testStringToArrayFirst(){
        String inputString = "a V = b W";
        String[] strings = stringToArray(inputString);
        assertEquals("a must be a", "a",strings[0]);
    }
    @Test
    public void testStringToArrayLengthMustBe5(){
        String inputString = "a V = b W";
        String[] strings = stringToArray(inputString);
        assertEquals("length must be 5",  5, strings.length);
    }

    @Test
    public void testStringToArrayAdd(){
        UnitConversionList unitConversionList = new UnitConversionList();
        String inputString = "1 V = 2 W";
        unitConversionList.add(inputString);
        assertEquals("length must be 2",  2, unitConversionList.getUnitMap().size());
    }

    @Test
    public void testStringToArrayConversionTrue(){
        UnitConversionList unitConversionList = new UnitConversionList();
        String inputString = "1 V = 2 W";
        unitConversionList.add(inputString);
        inputString = "1 W = 3 X";
        unitConversionList.add(inputString);
        assertEquals("must be 1 v = 6.0 x",  "1 v = 6 x", unitConversionList.conversion("1 V = ? X"));
    }
    @Test
    public void testStringToArrayConversionFalse(){
        UnitConversionList unitConversionList = new UnitConversionList();
        String inputString = "1 V = 2 W";
        unitConversionList.add(inputString);
        inputString = "1 W = 3 X";
        unitConversionList.add(inputString);
        assertEquals("must be Conversion not possible.",  "Conversion not possible.", unitConversionList.conversion("1 V = ? H"));
    }
}

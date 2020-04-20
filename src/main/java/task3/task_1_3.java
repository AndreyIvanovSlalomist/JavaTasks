package task3;

import java.util.Arrays;

public class task_1_3 {
    public static void main(String[] args) {
        String[] s = {"1024 byte = 1 kilobyte",
                "2 bar = 12 ring",
                "16.8 ring = 2 pyramid",
                "4 hare = 1 cat",
                "5 cat = 0.5 giraffe",
                "1 byte = 8 bit",
                "15 ring = 2.5 bar"};

        String[] sTest = {"1 pyramid = ? bar ",
                "1 giraffe = ? hare",
                "0.5 byte = ? cat ",
                "2 kilobyte = ? bit"};

        UnitConversionList unitConversionList = new UnitConversionList();
        Arrays.stream(s).forEach(unitConversionList::add);


        Arrays.stream(sTest).forEach((p) -> System.out.println(unitConversionList.conversion(p)));
    }
}

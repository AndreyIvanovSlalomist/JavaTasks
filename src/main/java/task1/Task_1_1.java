package task1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Task_1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Целое число больше 0:");
        String inString = scanner.nextLine();
        if (!checkInputString(inString)){
            System.out.println("Это не целое число больше 0");
            System.exit(1);
        }
        int inInt = Integer.parseInt(inString);

/*        for (int i = 0; i <= inInt; i++) {
            printResult(i);
        }*/
        Stream.iterate(1, n -> n + 1).limit(inInt).forEach((p)-> System.out.println(printResult(p)));

    }
    static String printResult(int inInt){
        String result="";
        if (inInt%3 == 0){
            result = result.concat("Foo");
        }
        if (inInt % 5  == 0){
            result = result.concat("Bar");
        }
        if (result.length() == 0){
            result = String.valueOf(inInt);
        }
        return result;
    }

    static boolean checkInputString(String inString){
        int inInt;
        try {
            inInt = Integer.parseInt(inString);
            if (inInt <= 0)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            return false;
        }
      return true;
    }

}

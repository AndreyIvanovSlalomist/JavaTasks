package task2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Utils {
    private Utils() {
    }

    static int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Целое число больше 0, кратное 2:");
        String inString = scanner.nextLine();
        if (!checkInputString(inString)) {
            System.out.println("Это не целое число больше 0, кратное 2");
            return 0;
        }
        return Integer.parseInt(inString);
    }

    static boolean checkInputString(String inString) {
        int inInt;
        try {
            inInt = Integer.parseInt(inString);
            if (inInt <= 0 || inInt % 2 != 0)
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    static boolean writerToFile(String fileName, String stringLine) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(stringLine);
            fileWriter.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    static String readFromFile(String fileName) {

        try (Scanner fileScanner = new Scanner(new FileReader(fileName))) {
            if (fileScanner.hasNext()) {
                return fileScanner.next();
            }
            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

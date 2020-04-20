package task2;

public class Task_1_2 {


    public static void main(String[] args) {
        String fileName = "out.txt";
       int inInt = Utils.getInt();
       if (inInt == 0)
           System.exit(1);

        Utils.writerToFile(fileName, "0");

        MainExecutors mainExecutors = new MainExecutors(new Incrementor(fileName, inInt));

        if (mainExecutors.shutdownAndAwaitTermination()) {
            System.out.println(Utils.readFromFile(fileName));
        }
    }

}

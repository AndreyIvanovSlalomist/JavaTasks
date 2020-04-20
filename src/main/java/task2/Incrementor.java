package task2;

public class Incrementor implements Runnable {
    private String fileName;
    private int inInt;

    Incrementor(String fileName, int inInt) {
        this.fileName = fileName;
        this.inInt = inInt;
    }

    private synchronized boolean incrementFile() {

        int fileValue;
        String value = Utils.readFromFile(fileName);
        if (value.equals(""))
            return false;
        fileValue = Integer.parseInt(value);

        if (fileValue < inInt) {
            fileValue++;
            System.out.println(fileValue - 1 + " " + fileValue + " " + Thread.currentThread().getName());
            return Utils.writerToFile(fileName, String.valueOf(fileValue));
        } else {
            return false;
        }

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (!incrementFile()){
                Thread.currentThread().interrupt();
            }
        }
    }
}

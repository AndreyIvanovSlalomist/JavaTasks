package task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MainExecutors {
    private ExecutorService pool = Executors.newFixedThreadPool(2);

    MainExecutors(Runnable incrementor) {
        pool.execute(incrementor);
        pool.execute(incrementor);
    }

    boolean shutdownAndAwaitTermination() {
        pool.shutdown();
        try {
            while (true) {
                if (pool.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.out.println("Закончили");
                    return true;
                }
            }

        } catch (InterruptedException ie) {
            pool.shutdownNow();
            return false;
        }
    }

}

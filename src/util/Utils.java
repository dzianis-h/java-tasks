package util;

public class Utils {
    public static long timer(Runnable task, String taskName) {
        System.out.printf("Running task '%s'.\n", taskName);
        long startTime = System.currentTimeMillis();
        task.run();
        long endTime = System.currentTimeMillis();
        System.out.printf("Task '%s' took %d ms.\n\n", taskName, endTime - startTime);
        return endTime - startTime;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}

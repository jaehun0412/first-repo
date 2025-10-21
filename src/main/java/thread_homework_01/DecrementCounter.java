package thread_homework_01;

public class DecrementCounter implements Runnable {

    @Override
    public void run() {
        for (int i = 100; i >= 1; i--) {
            System.out.println("Decrement: {" + i + "}");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

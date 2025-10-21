package thread_homework_02;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderTask implements Runnable {

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader
                ("../homework-jaehun0412/src/main/java/thread_homework_02/input.txt"))) {

            while (br.ready()) {
                System.out.println(br.readLine());
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

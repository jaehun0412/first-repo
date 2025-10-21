package thread_homework_02;

import java.io.*;

public class FileWriterTask implements Runnable {

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter
                     ("../homework-jaehun0412/src/main/java/thread_homework_02/output.txt"))) {

            while (true) {
                String line = br.readLine();
                if ("exit".equalsIgnoreCase(line)) break;

                bw.write(line);
                bw.newLine();
                bw.flush();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

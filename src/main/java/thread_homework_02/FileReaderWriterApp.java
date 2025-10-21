package thread_homework_02;

public class FileReaderWriterApp {

    public static void main(String[] args) {
        Thread readerTask = new Thread(new FileReaderTask());
        Thread writerTask = new Thread(new FileWriterTask());

        readerTask.start();
        writerTask.start();
    }
}

package miniproject01.common.generator;

public class BookIdGenerator {

    private static Long bookId = 1L;

    public static Long generateBookId() {
        return bookId++;
    }
}

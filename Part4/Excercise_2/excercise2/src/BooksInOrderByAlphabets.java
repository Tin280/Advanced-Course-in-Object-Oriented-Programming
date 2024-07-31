
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class BooksInOrderByAlphabets implements Comparable<BooksInOrderByAlphabets> {
    private String title;

    public BooksInOrderByAlphabets(Path title) {
        this.title = String.valueOf(title);
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(BooksInOrderByAlphabets other) {
        return this.title.compareTo(other.title);
    }

    public static void main(String[] args) {
        BooksInOrderByAlphabets[] books = {
                new BooksInOrderByAlphabets(Path.of("Harry Potter and the Philosopher's Stone")),
                new BooksInOrderByAlphabets(Path.of("To Kill a Mockingbird")),
                new BooksInOrderByAlphabets(Path.of("The Great Gatsby")),
        };

        Arrays.sort(books);

        for (BooksInOrderByAlphabets book : books) {
            System.out.println(book.getTitle());
        }
    }
}

class TestZipper2 extends Zipper {
    BooksInOrderByAlphabets[] books = new BooksInOrderByAlphabets[100];
    int idx = 0;

    TestZipper2(String zipFile) throws IOException {
        super(zipFile);
    }

    @Override
    public void run() throws IOException {
        super.run();

        System.out.printf("""


                Processed %d records.
                Now we could do a little sport

                        """, idx);
    }

    @Override
    protected Handler createHandler(Path file) {
        return new Handler(file) {
            @Override
            public void handle() {
                books[idx++] = new BooksInOrderByAlphabets(file);
            }
        };
    }
}
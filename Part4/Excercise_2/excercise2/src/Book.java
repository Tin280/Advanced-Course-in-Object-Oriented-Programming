import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Book implements Comparable<Book> {
    private String filePath;
    private String name;
    private int lineCount;
    private int uniqueWordCount;

    public Book(String filePath) {
        this.filePath = filePath;
        this.name = readName();
        this.lineCount = countLines();
        this.uniqueWordCount = countUniqueWords();
    }

    private String readName() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        } catch (IOException e) {
            return "File not found or error reading file";
        }
    }

    private int countLines() {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lines++;
            }
        } catch (IOException e) {
            return 0;
        }
        return lines;
    }

    private int countUniqueWords() {
        Set<String> uniqueWords = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                uniqueWords.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            return 0;
        }
        return uniqueWords.size();
    }

    public String getName() {
        return name;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getUniqueWordCount() {
        return uniqueWordCount;
    }

    @Override
    public int compareTo(Book other) {
        return this.name.compareTo(other.name);
    }

    public static void main(String[] args) {
        // Example usage with a list of books
        List<Book> books = new ArrayList<>();
        books.add(new Book("mobydick.txt")); // Assuming there is a file named 'mobydick.txt'
        books.add(new Book("prideandprejudice.txt")); // Assuming there is a file named 'prideandprejudice.txt'
        books.add(new Book("dracula.txt")); // Assuming there is a file named 'dracula.txt'

        // Comparator for the fourth order: primary by name, secondary by line count
        Comparator<Book> fourthOrderComparator = new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                int nameComparison = b1.getName().compareTo(b2.getName());
                if (nameComparison != 0) {
                    return nameComparison;
                } else {
                    return Integer.compare(b1.getLineCount(), b2.getLineCount());
                }
            }
        };

        // Sorting by the fourth order
        Collections.sort(books, fourthOrderComparator);

        System.out.println("Books sorted by name (primary) and line count (secondary):");
        for (Book book : books) {
            System.out.println("Book Name: " + book.getName());
            System.out.println("Number of Lines: " + book.getLineCount());
            System.out.println("Unique Words: " + book.getUniqueWordCount());
            System.out.println();
        }
    }
}

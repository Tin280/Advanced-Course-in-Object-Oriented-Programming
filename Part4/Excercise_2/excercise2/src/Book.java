
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Book {
    private Path filePath;
    private int lineCount;
    private String title;

    public Book(Path filePath) {
        this.filePath = filePath;
        this.title = extractTitle(filePath);
        this.lineCount = countLines(filePath);
    }

    public Path getFilePath() {
        return filePath;
    }

    public int getLineCount() {
        return lineCount;
    }

    public String getTitle() {
        return title;
    }

    private String extractTitle(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            if (!lines.isEmpty()) {
                return lines.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Book is unknown";
    }

    private int countLines(Path filePath) {
        try {
            return (int) Files.lines(filePath).count();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

class FileStatisticsServiceImplTest {

    String book1Path;
    @BeforeEach
    void setUp() {

       // book1Path = "C:/Projects/my-projects/java-projects/WordCountMultiThread/books/book1.txt";
        book1Path = "books/HelloWorld.txt";

    }

    @Test
    void itShouldGetFileStream() throws URISyntaxException, IOException {
        // Given
        Path urlPath = Paths.get(getClass().getClassLoader().getResource(book1Path).toURI());
        // When
        Stream<String> lines = Files.lines(urlPath);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        // Then
        //assertThat(lines).isNotEmpty();
        assertThat(data).contains("HelloWorld");
    }
}
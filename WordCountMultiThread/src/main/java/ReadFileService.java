import java.io.IOException;
import java.net.URISyntaxException;


public interface ReadFileService<T> {

    T readFile(String path) throws IOException, URISyntaxException;
}

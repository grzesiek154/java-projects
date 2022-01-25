import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadTxtFileServiceImpl implements ReadFileService {


    @Override
    public List<String> readFile(String path) throws IOException, URISyntaxException {
        Path urlPath = Paths.get(getClass().getClassLoader().getResource(path).toURI());
        Stream<String> lines = Files.lines(urlPath);
        // how to split convert returned array in to list
        List<String> wordsList = lines.map(line -> List.of(line.split("\\W+"))).flatMap(Collection::stream).collect(Collectors.toList());

        return wordsList;
    }
}

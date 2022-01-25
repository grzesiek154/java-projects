import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;

public interface FileStatisticsService {

   String getLongestWord(List<String> words);
   String getMostPopularWord(List<String> words);
   String getMostUniqueWord(List<String> words);
   String getShortestWord(List<String> words);
   String getAverageWordLength(List<String> words);
}

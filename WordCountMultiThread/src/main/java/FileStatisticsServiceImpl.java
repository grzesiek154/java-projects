import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileStatisticsServiceImpl implements FileStatisticsService {

    @Override
    public String getLongestWord(List<String> words){
        Comparator<String> compareLength = Comparator.comparingInt(String::length);
        String longestWord = words.stream().max(compareLength).get();
        return longestWord;
    }

    @Override
    public String getMostPopularWord(List<String> words) {
        String mostPopularWord = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()).get().getKey();

        return mostPopularWord;
    }


    @Override
    public String getMostUniqueWord(List<String> words) {

        String mostUniqueWord = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue()).get().getKey();

        return mostUniqueWord;
    }

    @Override
    public String getShortestWord(List<String> words) {
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        String shortestWord = words.stream().min(comparator).filter(word -> word.length() > 0).get();
        return shortestWord;
    }

    @Override
    public String getAverageWordLength(List<String> words) {
        return null;
    }
}

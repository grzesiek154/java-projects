import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class Practice1Test {

    List<List<String>> collection;
    List<String> expected;
    List<Integer> numbers;
    Person sara = new Person("Sara", 4, "Norwegian");
    Person viktor = new Person("Viktor", 40, "Serbian");
    Person eva = new Person("Eva", 42, "Norwegian");
    Person anna = new Person("Anna", 5, "Poland");
    List<Person> people = new ArrayList<>();
    @BeforeEach
    void setUp() {
         numbers = asList(1, 2, 3, 4, 5);
         expected = asList("Viktor", "Farcic", "John", "Doe", "Third");
         people = Arrays.asList(sara, eva, viktor, anna);
    }

    @Test
    void itShouldTransform() {
        List<String> newCollection = new ArrayList<>();
        newCollection = collection.stream().flatMap(Collection::stream).collect(Collectors.toList());
        assertThat(newCollection).hasSameElementsAs(expected);

    }

    @Test
    void itShouldCalculate() {
        int total = 0;
        total = numbers.stream().reduce((val, acc) -> acc+=val).get();
        assertThat(total).isEqualTo(1 + 2 + 3 + 4 + 5);
    }

    @Test
    void itShouldPartitionAdults() {
        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        map = people.stream().collect(Collectors.partitioningBy(person -> person.getAge() >= 18));


        assertThat(map.get(true)).hasSameElementsAs(asList(viktor, eva));
        assertThat(map.get(false)).hasSameElementsAs(asList(sara, anna));

    }

    @Test
    void itShouldGrupPeopleByNationality() {
        Map<String, List<Person>> map = new HashMap<>();
        map = people.stream().collect(Collectors.groupingBy(person -> person.getNationality()));

        assertThat(map.get("Norwegian")).hasSameElementsAs(asList(sara,eva));
        assertThat(map.get("Poland")).hasSameElementsAs(asList(anna));
    }
}
package stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("Collectors")
class CollectorsTest {

    @Test
    void shouldCollectByFiltering() {
        // given
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // when
        List<Integer> result = stream
                .collect(Collectors.filtering(
                        it -> it % 2 == 0,
                        Collectors.toList()
                ));
        // then
        Assertions.assertEquals(List.of(2, 4, 6, 8, 10), result);
    }

    @Test
    void shouldCollectByFlatMapping() {
        // given
        Stream<List<Integer>> stream = Stream.of(List.of(1, 2, 3, 4, 5), List.of(6, 7, 8, 9, 10));
        // when
        List<Integer> result = stream
                .collect(Collectors.flatMapping(
                        Collection::stream,
                        Collectors.toList()
                ));
        // then
        Assertions.assertEquals(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), result);
    }
}

package java10.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collectors")
class CollectorsTest {

    @Nested
    @DisplayName("toUnmodifiableList")
    class ToUnmodifiableList {

        @Test
        void shouldCollectToUnmodifiableList() {
            // given
            Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
            // when
            List<Integer> result = stream.collect(Collectors.toUnmodifiableList());
            // then
            assertEquals(List.of(1, 2, 3, 4, 5), result);
        }
    }

    @Nested
    @DisplayName("toUnmodifiableSet")
    class ToUnmodifiableSet {

        @Test
        void shouldCollectToUnmodifiableSet() {
            // given
            Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
            // when
            Set<Integer> result = stream.collect(Collectors.toUnmodifiableSet());
            // then
            assertEquals(Set.of(1, 2, 3, 4, 5), result);
        }
    }


    @Nested
    @DisplayName("toUnmodifiableMap")
    class ToUnmodifiableMap {

        @Test
        void shouldCollectToUnmodifiableMap() {
            // given
            Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
            // when
            Map<String, List<Integer>> result = stream
                    .collect(Collectors.toUnmodifiableMap(
                            it -> (it % 2 == 0) ? "even" : "odd",
                            List::of,
                            this::mergeLists
                    ));
            // then
            assertEquals(Map.ofEntries(
                    Map.entry("even", List.of(2, 4)),
                    Map.entry("odd", List.of(1, 3, 5))
            ), result);
        }

        private List<Integer> mergeLists(List<Integer> oldList, List<Integer> newList) {
            return List.of(oldList, newList).stream().flatMap(List::stream).collect(Collectors.toList());
        }
    }
}

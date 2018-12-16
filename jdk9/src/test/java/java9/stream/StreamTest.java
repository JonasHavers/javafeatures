package java9.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("Stream")
class StreamTest {

  @Test
  void shouldTakeWhile() {
    // given
    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // when
    Stream<Integer> result = stream.takeWhile(it -> it <= 5);
    // then
    Assertions.assertEquals(List.of(1, 2, 3, 4, 5), result.collect(Collectors.toList()));
  }

  @Test
  void shouldDropWhile() {
    // given
    Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    // when
    Stream<Integer> result = stream.dropWhile(it -> it <= 5);
    // then
    Assertions.assertEquals(List.of(6, 7, 8, 9, 10), result.collect(Collectors.toList()));
  }

  @Test
  void shouldIterate() {
    // when
    Stream<Integer> stream = Stream.iterate(0, it -> it <= 5, it -> it + 1);
    // then
    Assertions.assertEquals(List.of(0, 1, 2, 3, 4, 5), stream.collect(Collectors.toList()));
  }

  @Test
  void shouldCreateAStreamWithOneElement() {
    // when
    Stream<Integer> stream = Stream.ofNullable(5);
    // then
    Assertions.assertEquals(List.of(5), stream.collect(Collectors.toList()));
  }

  @Test
  void shouldCreateAnEmptyStream() {
    // when
    Stream<Integer> stream = Stream.ofNullable(null);
    // then
    Assertions.assertEquals(List.of(), stream.collect(Collectors.toList()));
  }
}

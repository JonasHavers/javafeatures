package optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayName("Optional")
class OptionalTest {

    @Test
    void shouldReturnTheNotEmptyOptional() {
        // when
        Optional<Object> optional = Optional
                .empty()
                .or(() -> Optional.of("Value"));
        // then
        Assertions.assertEquals("Value", optional.get());
    }

    @Test
    void shouldExecuteOneOfTheActions() {
        // given
        Optional<String> optional = Optional.empty();
        // expect
        optional.ifPresentOrElse(
                it -> Assertions.fail("present"),
                () -> {
                }
        );
    }

    @Test
    void shouldConvertAnOptionalToAStream() {
        // given
        Stream<Optional<Integer>> stream = Stream.of(
                Optional.of(42),
                Optional.empty(),
                Optional.of(23)
        );
        // when
        Stream<Integer> result = stream.flatMap(Optional::stream);
        // then
        Assertions.assertEquals(List.of(42, 23), result.collect(Collectors.toList()));
    }
}

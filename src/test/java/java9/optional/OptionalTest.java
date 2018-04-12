package java9.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Optional")
class OptionalTest {

    @Nested
    @DisplayName("or")
    class Or {

        @Test
        void shouldReturnTheNotEmptyOptional() {
            // when
            Optional<Object> optional = Optional
                    .empty()
                    .or(() -> Optional.of("Value"));
            // then
            assertEquals("Value", optional.get());
        }
    }

    @Nested
    @DisplayName("ifPresentOrElse")
    class IfPresentOrElse {

        @Test
        void shouldExecuteOneOfTheActions() {
            // given
            Optional<String> optional = Optional.empty();
            // expect
            optional.ifPresentOrElse(
                    it -> fail("present"),
                    () -> {
                    }
            );
        }
    }

    @Nested
    @DisplayName("stream")
    class Streaming {

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
            assertEquals(List.of(42, 23), result.collect(Collectors.toList()));
        }
    }
}

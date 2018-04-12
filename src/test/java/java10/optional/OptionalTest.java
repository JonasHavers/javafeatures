package java10.optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Optional")
class OptionalTest {

    @Nested
    @DisplayName("orElseThrow")
    class OrElseThrow {

        @Test
        void shouldThrowANoSuchElementException() {
            // given
            Optional<Object> optional = Optional.empty();
            // expect
            assertThrows(NoSuchElementException.class, optional::orElseThrow);
        }
    }
}

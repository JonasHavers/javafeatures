package java10.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("List")
class ListTest {

    @Nested
    @DisplayName("copyOf")
    class CopyOf {

        @Test
        void shouldCreateAnImmutableCopyOfAList() {
            // given
            List<String> list = new ArrayList<>();
            list.add("Java");
            list.add("Kotlin");
            list.add("Groovy");
            // when
            List<String> result = List.copyOf(list);
            // expect
            assertThrows(UnsupportedOperationException.class, () -> result.add("PHP"));
        }
    }
}

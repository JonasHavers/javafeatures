package java10.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Set")
class SetTest {
    @Test
    void shouldCreateAnImmutableCopyOfASet() {
        // given
        Set<String> set = new HashSet<>();
        set.add("Java");
        set.add("Kotlin");
        set.add("Groovy");
        // when
        Set<String> result = Set.copyOf(set);
        // expect
        assertThrows(UnsupportedOperationException.class, () -> result.add("PHP"));
    }
}

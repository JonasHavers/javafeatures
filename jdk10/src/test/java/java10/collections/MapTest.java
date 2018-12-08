package java10.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Map")
class MapTest {
    @Test
    void shouldCreateAnImmutableCopyOfAMap() {
        // given
        Map<String, String> map = new HashMap<>();
        map.put("Java", "Expert");
        map.put("Kotlin", "Intermediate");
        map.put("Groovy", "Beginner");
        // when
        Map<String, String> result = Map.copyOf(map);
        // expect
        assertThrows(UnsupportedOperationException.class, () -> result.put("PHP", "Master"));
    }
}

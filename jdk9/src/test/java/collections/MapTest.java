package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Map;

@DisplayName("Map")
class MapTest {

    @Test
    void shouldCreateAnImmutableMap() {
        // when
        Map<String, String> map = Map.of();
        // then
        Assertions.assertThrows(UnsupportedOperationException.class, () -> map.put("Key", "Value"));
    }

    @Test
    void shouldCreateAMapOfTypeImmutableCollections$Map0() {
        // when
        Map map = Map.of();
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$MapN", map.getClass().getName());
    }

    @Test
    void shouldCreateAMapOfTypeImmutableCollections$Map1() {
        // when
        Map<String, String> map = Map.of("Key1", "Value1");
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$Map1", map.getClass().getName());
    }

    @Test
    void shouldThrowAnExceptionWhenPassedNullKey() {
        // expect
        Assertions.assertThrows(NullPointerException.class, () -> Map.of(null, "Value"));
    }

    @Test
    void shouldThrowAnExceptionWhenPassedNullValue() {
        // expect
        Assertions.assertThrows(NullPointerException.class, () -> Map.of("Key", null));
    }

    @Test
    void shouldCreateAMapOfTypeImmutableCollections$MapN() {
        // when
        Map<String, String> map = Map.of(
                "Key1", "Value1",
                "Key2", "Value2",
                "Key3", "Value3",
                "Key4", "Value4",
                "Key5", "Value5",
                "Key6", "Value6",
                "Key7", "Value7",
                "Key8", "Value8",
                "Key9", "Value9",
                "Key10", "Value10"
        );
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$MapN", map.getClass().getName());
    }
}

@Nested
@DisplayName("ofEntries")
class OfEntries {

    @Test
    void shouldCreateAMapOfTypeImmutableCollections$MapN() {
        // when
        Map<String, String> map = Map.ofEntries(
                Map.entry("Key1", "Value1"),
                Map.entry("Key2", "Value2"),
                Map.entry("Key3", "Value3"),
                Map.entry("Key4", "Value4"),
                Map.entry("Key5", "Value5"),
                Map.entry("Key6", "Value6"),
                Map.entry("Key7", "Value7"),
                Map.entry("Key8", "Value8"),
                Map.entry("Key9", "Value9"),
                Map.entry("Key10", "Value10"),
                Map.entry("Key11", "Value11")
        );
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$MapN", map.getClass().getName());
    }
}

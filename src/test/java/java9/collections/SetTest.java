package java9.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Set")
class SetTest {

    @Nested
    @DisplayName("of")
    class Of {

        @Test
        void shouldCreateAnImmutableSet() {
            // given
            Set<String> set = Set.of();
            // expect
            assertThrows(UnsupportedOperationException.class, () -> set.add("Value"));
        }

        @Test
        void shouldThrowANullPointerExceptionWhenPassedNull() {
            // expect
            assertThrows(NullPointerException.class, () -> Set.of((String) null));
        }

        @Test
        void shouldCreateAnEmptySetOfTypeImmutableCollections$Set0() {
            // when
            Set set = Set.of();
            // then
            assertEquals("java.util.ImmutableCollections$Set0", set.getClass().getName());
        }

        @Test
        void shouldCreateASetOfTypeImmutableCollections$Set1() {
            // when
            Set<String> set = Set.of("Value1");
            // then
            assertEquals("java.util.ImmutableCollections$Set1", set.getClass().getName());
        }

        @Test
        void shouldCreateASetOfTypeImmutableCollections$Set2() {
            // when
            Set<String> set = Set.of(
                    "Value1",
                    "Value2"
            );
            // then
            assertEquals("java.util.ImmutableCollections$Set2", set.getClass().getName());
        }

        @Test
        void shouldCreateASetOfTypeImmutableCollections$SetN() {
            // when
            Set<String> set = Set.of(
                    "Value1",
                    "Value2",
                    "Value3"
            );
            // then
            assertEquals("java.util.ImmutableCollections$SetN", set.getClass().getName());
        }
    }
}

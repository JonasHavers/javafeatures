package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

@DisplayName("Set")
class SetTest {

    @Test
    void shouldCreateAnImmutableSet() {
        // given
        Set<String> set = Set.of();
        // expect
        Assertions.assertThrows(UnsupportedOperationException.class, () -> set.add("Value"));
    }

    @Test
    void shouldThrowANullPointerExceptionWhenPassedNull() {
        // expect
        Assertions.assertThrows(NullPointerException.class, () -> Set.of((String) null));
    }

    @Test
    void shouldCreateAnEmptySetOfTypeImmutableCollections$Set0() {
        // when
        Set set = Set.of();
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$SetN", set.getClass().getName());
    }

    @Test
    void shouldCreateASetOfTypeImmutableCollections$Set1() {
        // when
        Set<String> set = Set.of("Value1");
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$Set12", set.getClass().getName());
    }

    @Test
    void shouldCreateASetOfTypeImmutableCollections$Set2() {
        // when
        Set<String> set = Set.of(
                "Value1",
                "Value2"
        );
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$Set12", set.getClass().getName());
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
        Assertions.assertEquals("java.util.ImmutableCollections$SetN", set.getClass().getName());
    }
}

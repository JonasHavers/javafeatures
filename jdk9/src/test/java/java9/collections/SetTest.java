package java9.collections;

import org.junit.jupiter.api.Assertions;
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
      Assertions.assertThrows(UnsupportedOperationException.class, () -> set.add("Value"));
    }

    @Test
    void shouldThrowANullPointerExceptionWhenPassedNull() {
      // expect
      assertThrows(NullPointerException.class, () -> Set.of((String) null));
    }

    @Test
    void shouldCreateAnEmptySetOfTypeImmutableCollections$SetNWhenPassedNoParameters() {
      // when
      Set set = Set.of();
      // then
      assertEquals("java.util.ImmutableCollections$SetN", set.getClass().getName());
    }

    @Test
    void shouldCreateASetOfTypeImmutableCollections$Set12() {
      // when
      Set<String> set = Set.of("Value1");
      // then
      assertEquals("java.util.ImmutableCollections$Set12", set.getClass().getName());
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

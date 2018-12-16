package java9.collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("List")
class ListTest {

  @Nested
  @DisplayName("of")
  class Of {

    @Test
    void shouldCreateAnImmutableList() {
      // given
      List<String> list = List.of();
      // expect
      assertThrows(UnsupportedOperationException.class, () -> list.add("Value"));
    }

    @Test
    void shouldThrowANullPointerExceptionWhenPassedNull() {
      // expect
      assertThrows(NullPointerException.class, () -> List.of((String) null));
    }

    @Test
    void shouldCreateAnEmptyListOfTypeImmutableCollections$ListNWhenPassedNoParameters() {
      // when
      List list = List.of();
      // then
      assertEquals("java.util.ImmutableCollections$ListN", list.getClass().getName());
    }

    @Test
    void shouldCreateAListOfTypeImmutableCollections$List12() {
      // when
      List<String> list = List.of("Value1");
      // then
      assertEquals("java.util.ImmutableCollections$List12", list.getClass().getName());
    }

    @Test
    void shouldCreateAListOfTypeImmutableCollections$ListN() {
      // when
      List<String> list = List.of(
        "Value1",
        "Value2",
        "Value3"
      );
      // then
      assertEquals("java.util.ImmutableCollections$ListN", list.getClass().getName());
    }
  }
}

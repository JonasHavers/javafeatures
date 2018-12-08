package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("List")
class ListTest {

    @Test
    void shouldCreateAnImmutableList() {
        // given
        List<String> list = List.of();
        // expect
        Assertions.assertThrows(UnsupportedOperationException.class, () -> list.add("Value"));
    }

    @Test
    void shouldThrowANullPointerExceptionWhenPassedNull() {
        // expect
        Assertions.assertThrows(NullPointerException.class, () -> List.of((String) null));
    }

    @Test
    void shouldCreateAnEmptyListOfTypeImmutableCollections$List0() {
        // when
        List list = List.of();
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$ListN", list.getClass().getName());
    }

    @Test
    void shouldCreateAListOfTypeImmutableCollections$List1() {
        // when
        List<String> list = List.of("Value1");
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$List12", list.getClass().getName());
    }

    @Test
    void shouldCreateAListOfTypeImmutableCollections$List2() {
        // when
        List<String> list = List.of(
                "Value1",
                "Value2"
        );
        // then
        Assertions.assertEquals("java.util.ImmutableCollections$List12", list.getClass().getName());
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
        Assertions.assertEquals("java.util.ImmutableCollections$ListN", list.getClass().getName());
    }
}

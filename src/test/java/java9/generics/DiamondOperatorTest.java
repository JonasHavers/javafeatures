package java9.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("DiamondOperator")
class DiamondOperatorTest {

    @Test
    void shouldBeUsableWithAnonymousInnerClasses() {
        // when
        List<Integer> list1 = new ArrayList<>() {
            {
                add(42);
            }
        };
        // and
        List<? extends Integer> list2 = new ArrayList<>() {
            {
                add(42);
            }
        };
        // and
        List<?> list3 = new ArrayList<>() {
            {
                add(42);
            }
        };
        // then
        assertEquals((Integer) 42, list1.get(0));
        assertEquals((Integer) 42, list2.get(0));
        assertEquals(42, list3.get(0));
    }
}

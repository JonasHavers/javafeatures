package java10.var;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("var")
class VarTest {

    @Test
    void shouldBeNoReservedKeywordForVariableNames() {
        var var = 42;
    }

    @Test
    void shouldInferLocalVariableTypeToImmutableListOfStrings() {
        // when
        var list = List.of("Value1", "Value2");
        // then
        assertEquals("java.util.ImmutableCollections$List2", list.getClass().getName());
        // and
        String firstItem = list.get(0);
        assertEquals("Value1", firstItem);
    }

    @Test
    void shouldInferLocalVariableTypeToArrayListOfObjects() {
        // when
        var list = new ArrayList<>();
        list.add("Value1");
        // then
        assertEquals("java.util.ArrayList", list.getClass().getName());
        // and
        Object firstItem = list.get(0);
        assertEquals("Value1", firstItem);
    }

    @Test
    void shouldInferLocalVariableTypeToArrayListOfStrings() {
        // when
        var list = new ArrayList<String>();
        list.add("Value1");
        // then
        assertEquals("java.util.ArrayList", list.getClass().getName());
        // and
        String firstItem = list.get(0);
        assertEquals("Value1", firstItem);
    }

    @Test
    void shouldRequireAnExplicitTypeCastForLambdas() {
        // when
        var lambda = (Function<String, String>) (String it) -> it;
        // then
        assertEquals("not recommended", lambda.apply("not recommended"));
    }

    @Test
    void shouldRequireAnExplicitTypeCastForMethodReferences() {
        // when
        var methodRef = (Comparator<Integer>) Integer::compare;
        // then
        assertEquals(1, methodRef.compare(42, 21));
    }
}

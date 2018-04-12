package java10.var;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("var")
class VarTest {

    @Test
    void shouldInferLocalVariableTypeToListOfStrings() {
        // when
        var list = List.of("Value1", "Value2");
        // then
        String firstItem = list.get(0);
        assertEquals("Value1", firstItem);
    }
}

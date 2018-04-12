package java9.interfaces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Interface")
class InterfaceTest {

    @Test
    void shouldCompileWithPrivateMethods() {
        // given
        WithPrivateMethod withPrivateMethod = new WithPrivateMethod() {
        };
        // when
        String result = withPrivateMethod.toPublic();
        // then
        assertEquals("private", result);
    }

    interface WithPrivateMethod {
        default String toPublic() {
            return fromPrivate();
        }

        private String fromPrivate() {
            return "private";
        }
    }
}

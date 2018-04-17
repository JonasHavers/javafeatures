package java9.process;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Process")
class ProcessTest {

    @Nested
    @DisplayName("current")
    class Current {

        @Test
        void shouldProvideACurrentProcessRepresentation() {
            // given
            ProcessHandle process = ProcessHandle.current();
            // expect
            assertNotNull(process);
            // and
            assertTrue(process.isAlive());
            assertTrue(process.supportsNormalTermination());
            assertTrue(process.pid() > 0);
        }

        @Nested
        @DisplayName("info")
        class Info {

            @Test
            void shouldProvideDetailsAboutTheCurrentProcess() {
                // given
                ProcessHandle process = ProcessHandle.current();
                // when
                ProcessHandle.Info processInfo = process.info();
                // then
                assertNotNull(processInfo);
                // and
                assertTrue(processInfo.arguments().isPresent());
                assertTrue(processInfo.command().isPresent());
                assertTrue(processInfo.commandLine().isPresent());
                assertTrue(processInfo.startInstant().isPresent());
                assertTrue(processInfo.totalCpuDuration().isPresent());
                assertTrue(processInfo.user().isPresent());
            }
        }
    }
}

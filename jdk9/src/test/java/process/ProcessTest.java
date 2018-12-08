package process;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Process")
class ProcessTest {

    @Test
    void shouldProvideACurrentProcessRepresentation() {
        // given
        ProcessHandle process = ProcessHandle.current();
        // expect
        assertNotNull(process);
        // and
        assertTrue(process.isAlive());
        assertTrue(process.pid() > 0);
    }

    @Test
    void shouldProvideDetailsAboutTheCurrentProcess() {
        // given
        ProcessHandle process = ProcessHandle.current();
        // when
        ProcessHandle.Info processInfo = process.info();
        // then
        assertNotNull(processInfo);
        // and
        assertTrue(processInfo.command().isPresent());
        assertTrue(processInfo.startInstant().isPresent());
        assertTrue(processInfo.totalCpuDuration().isPresent());
        assertTrue(processInfo.user().isPresent());
    }
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CsvReaderTest {

    @Test
    public void shouldThrowException() {

        assertThrows(IOException.class, () -> CsvReader.read("noname.csv"));

    }

    @Test
    public void checkMessage() {
        Throwable exception = assertThrows(IOException.class, () -> CsvReader.read("noname.csv"));
        assertEquals("noname.csv (No such file or directory)", exception.getMessage());
    }
}

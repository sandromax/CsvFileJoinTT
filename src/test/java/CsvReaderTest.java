import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderTest {

    public static List<String[]> expected = new ArrayList<>() {{
        add(new String[]{"id", "name"});
        add(new String[]{"1", "Marketing"});
        add(new String[]{"2", "Management"});
        add(new String[]{"3", "Finance"});
        add(new String[]{"4", "Production"});
    }};

    @Test
    public void shouldThrowIOException() {

        assertThrows(IOException.class, () -> CsvReader.read("noname.csv"));

    }

    @Test
    public void shouldReadTextFromFile() {

        List<String[]> actual = new ArrayList<>();

        try {
            actual = CsvReader.read("src/main/resources/Test_Task.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < actual.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }


    }


}

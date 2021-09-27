import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        Printer.print(new ArrayList<>() {
            {
                add(new String[]{"id", "name", "surname", "department"});
                add(new String[]{"1", "Lee", "Alen", "Finance"});
                add(new String[]{"3", "David", "Bowie", "Management"});
            }
        });

        String expected = "id name surname department \n" +
                "1 Lee Alen Finance \n" +
                "3 David Bowie Management";

        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}

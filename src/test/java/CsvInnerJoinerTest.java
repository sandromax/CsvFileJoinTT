import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CsvInnerJoinerTest {

    public static List<String[]> left = new ArrayList<>() {{
        add(new String[]{"id", "name", "surname", "department"});
        add(new String[]{"1", "Lee", "Alen", "1"});
        add(new String[]{"3", "David", "Bowie", "7"});
    }};

    public static List<String[]> right = new ArrayList<>() {{
        add(new String[]{"id", "name"});
        add(new String[]{"1", "Finance"});
        add(new String[]{"7", "Management"});
    }};

    @Test
    public void loopJoinTest() {

        List<String[]> expected = new ArrayList<>() {
            {
                add(new String[]{"id", "name", "surname", "department"});
                add(new String[]{"1", "Lee", "Alen", "Finance"});
                add(new String[]{"3", "David", "Bowie", "Management"});
            }
        };

        List<String[]> actual = CsvInnerJoiner.loopJoin(left, right);

        for (int i = 0; i < actual.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }

    }

    @Test
    public void hashJoinTest() {

        List<String[]> expected = new ArrayList<>() {
            {
                add(new String[]{"id", "name", "surname", "department"});
                add(new String[]{"1", "Lee", "Alen", "Finance"});
                add(new String[]{"3", "David", "Bowie", "Management"});
            }
        };

        List<String[]> actual = CsvInnerJoiner.hashJoin(left, right);

        for (int i = 0; i < actual.size(); i++) {
            assertArrayEquals(expected.get(i), actual.get(i));
        }

    }

}

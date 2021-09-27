import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvInnerJoiner {

    public static List<String[]> loopJoin(List<String[]> left, List<String[]> right) {

        for (String[] lineData1 : left) {
            for (String[] lineData2 : right) {
                if (lineData1[3].equals(lineData2[0])) {
                    lineData1[3] = lineData2[1];
                }
            }
        }

        return left;

    }

    public static List<String[]> hashJoin (List<String[]> left, List<String[]> right) {

        Map<String, String> rightAsMap = new HashMap<>();

        for (String[] line : right) {
            rightAsMap.put(line[0], line[1]);
        }

        for (String[] row : left) {
            if (rightAsMap.containsKey(row[3]))
                row[3] = rightAsMap.get(row[3]);
        }

        return left;

    }

    public List<String[]> mergeJoin (List<String[]> left, List<String[]> right) {
        

        return left;
    }


    }

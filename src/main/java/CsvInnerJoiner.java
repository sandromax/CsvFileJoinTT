import java.util.List;

public class CsvInnerJoiner {

    public List<String[]> loopJoin(List<String[]> data1, List<String[]> data2) {

        for (String[] lineData1 : data1) {
            for (String[] lineData2 : data2) {
                if (lineData1[3].equals(lineData2[0])) {
                    lineData1[3] = lineData2[1];
                }
            }
        }

        return data1;

    }

}

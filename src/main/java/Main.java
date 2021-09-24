import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CsvReader reader = new CsvReader();

        List<String[]> data1 = new ArrayList<>();
        List<String[]> data2 = new ArrayList<>();

        try {
            data1 = reader.read("src/main/resources/Test Task.csv");
            data2 = reader.read("src/main/resources/Test_Task.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        CsvInnerJoiner joiner = new CsvInnerJoiner();

        for (String[] line : joiner.loopJoin(data1, data2)) {

            for (String str : line) {
                System.out.print(str + " ");
            }

            System.out.println();
        }

    }

}

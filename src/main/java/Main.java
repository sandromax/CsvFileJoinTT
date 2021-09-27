import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String[]> employees = new ArrayList<>();
        List<String[]> departments = new ArrayList<>();

        try {
            employees = CsvReader.read("src/main/resources/Test Task.csv");
            departments = CsvReader.read("src/main/resources/Test_Task.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Printer.print(CsvInnerJoiner.loopJoin(employees, departments));

    }

}

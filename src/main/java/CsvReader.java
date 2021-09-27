import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<String[]> read(String path) throws IOException {

        File csvFile = new File(path);
        List<String[]> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line.split(";"));
            }
        }

        return lines;

    }

}

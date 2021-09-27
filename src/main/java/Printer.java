import java.util.List;

public class Printer {

    public static void print(List<String[]> text) {
        for (String[] line : text) {

            for (String str : line) {
                System.out.print(str + " ");
            }

            System.out.println();
        }
    }
}

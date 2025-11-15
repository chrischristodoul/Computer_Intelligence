import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomPointsGenerator {

    public static void main(String[] args) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter("points.csv"));
            file.println("x1,x2"); // header

            // Δημιουργία σημείων ανά τετράγωνο
            generatePoints(file, 0.75, 1.25, 0.75, 1.25, 150); // 1
            generatePoints(file, 0, 0.5, 0, 0.5, 150);         // 2
            generatePoints(file, 0, 0.5, 1.5, 2, 150);         // 3
            generatePoints(file, 1.5, 2, 0, 0.5, 150);         // 4
            generatePoints(file, 1.5, 2, 1.5, 2, 150);         // 5
            generatePoints(file, 0.6, 0.8, 0, 0.4, 75);       // 6
            generatePoints(file, 0.6, 0.8, 1.6, 2, 75);       // 7
            generatePoints(file, 1.2, 1.4, 0, 0.4, 75);       // 8
            generatePoints(file, 1.2, 1.4, 1.6, 2, 75);       // 9
            generatePoints(file, 0, 2, 0, 2, 150);            // 10

            file.close();
            System.out.println("Τα σημεία δημιουργήθηκαν στο points.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Μέθοδος για δημιουργία τυχαίων σημείων σε τετράγωνο
    public static void generatePoints(PrintWriter file, double xMin, double xMax, double yMin, double yMax, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            double x = xMin + (xMax - xMin) * rand.nextDouble();
            double y = yMin + (yMax - yMin) * rand.nextDouble();
            file.println(x + "," + y);
        }
    }
}


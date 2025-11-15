import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Sdt {

    public static void main(String[] args) {
        int trainSize = 4000;
        int testSize = 4000;

        Random rand = new Random();

        try {
            PrintWriter trainFile = new PrintWriter(new FileWriter("train.csv"));
            PrintWriter testFile = new PrintWriter(new FileWriter("test.csv"));

            // Προσθήκη header (προαιρετικά)
            trainFile.println("x1,x2,category");
            testFile.println("x1,x2,category");

            // Δημιουργία train set
            for (int i = 0; i < trainSize; i++) {
                double x1 = rand.nextDouble() * 2;
                double x2 = rand.nextDouble() * 2;

                String category = classify(x1, x2);

                trainFile.println(x1 + "," + x2 + "," + category);
            }

            // Δημιουργία test set
            for (int i = 0; i < testSize; i++) {
                double x1 = rand.nextDouble() * 2;
                double x2 = rand.nextDouble() * 2;

                String category = classify(x1, x2);

                testFile.println(x1 + "," + x2 + "," + category);
            }

            trainFile.close();
            testFile.close();

            System.out.println("Δεδομένα γράφτηκαν στα αρχεία train.csv και test.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String classify(double x1, double x2) {
        double result1 = Math.pow(x1 - 0.5, 2) + Math.pow(x2 - 0.5, 2);
        double result2 = Math.pow(x1 - 1.5, 2) + Math.pow(x2 - 0.5, 2);
        double result3 = Math.pow(x1 - 0.5, 2) + Math.pow(x2 - 1.5, 2);
        double result4 = Math.pow(x1 - 1.5, 2) + Math.pow(x2 - 1.5, 2);

        // Έλεγχος για τα 4 κέντρα
        if (result1 < 0.2) {
            if (x1 > 0.5 && x2 > 0.5) return "C1";
            else if (x1 < 0.5 && x2 > 0.5) return "C2";
            else if (x1 > 0.5 && x2 < 0.5) return "C2";
            else return "C1";
        } else if (result2 < 0.2) {
            if (x1 > 1.5 && x2 > 0.5) return "C1";
            else if (x1 < 1.5 && x2 > 0.5) return "C2";
            else if (x1 > 1.5 && x2 < 0.5) return "C2";
            else return "C1";
        } else if (result3 < 0.2) {
            if (x1 > 0.5 && x2 > 1.5) return "C1";
            else if (x1 < 0.5 && x2 > 1.5) return "C2";
            else if (x1 > 0.5 && x2 < 1.5) return "C2";
            else return "C1";
        } else if (result4 < 0.2) {
            if (x1 > 1.5 && x2 > 1.5) return "C1";
            else if (x1 < 1.5 && x2 > 1.5) return "C2";
            else if (x1 > 1.5 && x2 < 1.5) return "C2";
            else return "C1";
        }

        // Κατηγορίες C3 και C4
        if ((x1 - 1) * (x2 - 1) > 0) {
            return "C3";
        } else if ((x1 - 1) * (x2 - 1) < 0) {
            return "C4";
        } else {
            return "None"; // πάνω στις γραμμές x1=1 ή x2=1
        }
    }
}

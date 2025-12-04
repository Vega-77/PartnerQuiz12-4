//Alexander Vega & Jacob Grim 12/4/2025
import java.io.*;
import java.util.ArrayList;
public class PartnerGitQuiz{
    // Hardcode your file paths here:
    private static final String FILE1 = "C:\\Users\\10020137\\Desktop\\GitUnit\\Grimms_Fairy_Tales.txt";
    private static final String FILE2 = "C:\\Users\\10020137\\Desktop\\GitUnit\\War_and_Peace.txt";
    static ArrayList<Character> chars = new ArrayList<>();
	public static void main(String[]args){
        long startTime = System.nanoTime();

        try {
            processFile(FILE1);
            processFile(FILE2);
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        long elapsedMs = (endTime - startTime) / 1_000_000;

        System.out.println("\nTotal time: " + elapsedMs + " ms");
    }

    private static void processFile(String filePath) throws IOException {
        System.out.println("Processing file: " + filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int c;
            while ((c = br.read()) != -1) {
                char upper = Character.toUpperCase((char) c);
                chars.add(upper);
            }
        }
    }
}
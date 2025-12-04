//Alexander Vega & Jacob Grim 12/4/2025
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.*;
public class PartnerGitQuiz{
    private static final String FILE1 = "C:\\Users\\10020268\\Documents\\GitHubThings\\GitKraken\\PartnerQuiz12-4\\Grimms_Fairy_Tales.txt";
    private static final String FILE2 = "C:\\Users\\10020268\\Documents\\GitHubThings\\GitKraken\\PartnerQuiz12-4\\War_and_Peace.txt";
	public static void main(String[]args){
		long startTime = System.nanoTime();

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Prepare tasks
        Callable<ArrayList<Character>> task1 = () -> processFile(FILE1);
        Callable<ArrayList<Character>> task2 = () -> processFile(FILE1);

        try {
            Future<ArrayList<Character>> result1 = executor.submit(task1);
            Future<ArrayList<Character>> result2 = executor.submit(task2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        System.out.println("Time taken: "+(System.nanoTime()-startTime)/1_000_000+" ms");
	}

    private static ArrayList<Character> processFile(String filePath) throws IOException {
        System.out.println("Processing file: " + filePath);
    	ArrayList<Character> chars = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int c;
            while ((c = br.read()) != -1) {
                char upper = Character.toUpperCase((char) c);
                chars.add(upper);
            }
        }
        return chars;
    }
}
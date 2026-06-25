import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCountProgram {

    public static void main(String[] args) {

        HashMap<String, Integer> wordCount = new HashMap<>();

        try {

            File file = new File("/Users/jywoods/Desktop/SampleText.txt");

            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNext()) {

                String word = fileScanner.next();

                word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

                if (!word.isEmpty()) {

                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }

            fileScanner.close();

            int totalWords = 0;

            for (int count : wordCount.values()) {
                totalWords += count;
            }

            System.out.println("Total number of words: " + totalWords);

            List<Map.Entry<String, Integer>> list =
                    new ArrayList<>(wordCount.entrySet());

            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("\nTop 5 most common words:");

            for (int i = 0; i < 5; i++) {
                System.out.println(
                        list.get(i).getKey() + " : " + list.get(i).getValue());
            }

            Scanner input = new Scanner(System.in);

            System.out.print("\nEnter a word to search: ");

            String searchWord = input.nextLine().toLowerCase();

            if (wordCount.containsKey(searchWord)) {

                System.out.println(searchWord + " appears "
                        + wordCount.get(searchWord) + " times.");

            } else {

                System.out.println("The word was not found.");
            }

            input.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found.");
        }
    }
}
// Git assignment

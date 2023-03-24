import java.io.*;
import java.util.*;

public class Syllable2 {

    private static HashMap<String, Integer> hm = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try {
            // Source of txt file = http://www.delphiforfun.org/programs/Syllables.htm
            File f = new File("./Syllables.txt");
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String[] words = sc.nextLine().split("=");
                hm.put(words[0], words[1].split("-").length);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String word = scan.next();
            if (hm.containsKey(word)) {
                System.out.println(hm.get(word));
            } else {
                System.err.println("Word not found");
            }
        }
    }
}

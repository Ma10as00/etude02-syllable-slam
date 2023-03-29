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
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String word = scan.next();
            if (hm.containsKey(word)) {
                System.out.println(hm.get(word));
            } else {
                System.out.println(countSyllables(word));
            }
        }
        scan.close();
    }

    /**
     * Counts the number of syllables in a word.
     * Iterates through each letter to see if the prior letter was a vowel, if there were 2 in a row the second is not counted. The third is.
     * @param word the word to be counted
     * @return the number of syllables in the word
     */
    public static int countSyllables(String word){
        int syllables = 0;
        for(int i = 0; i < word.length(); i++){
            // Counting a vowel for syllables if there are three in a row (this ends up counting the three vowels as two syllables)
            try{
                if (isVowel(word.charAt(i)) && isVowel(word.charAt(i-1)) && isVowel(word.charAt(i-2))){
                    countSyl(i);
                    syllables++;
                    continue;
                }
            } catch(StringIndexOutOfBoundsException e){
                System.err.println("String Index out of bounds error on the letter at position: " + i + ", " + word.charAt(i));
            }


            // Not counting a letter if it is preceded by only 1  vowel
            try{
                if (isVowel(word.charAt(i)) && isVowel(word.charAt(i-1))) continue;
            } catch(StringIndexOutOfBoundsException e){
                System.err.println("String Index out of bounds error on the letter at position: " + i + ", " + word.charAt(i));
                countSyl(i);
                syllables++;
            }
            if (isVowel(word.charAt(i)) && i > 0) {
                countSyl(i);
                syllables++;
            }
        }
        return syllables;
    }

    public static void countSyl(int index){
        //System.out.println("Counted a syllable at character: "+ index);
    }

    public static boolean isVowel(char c){
        return "aeiouy".indexOf(c) != -1;
    }
}

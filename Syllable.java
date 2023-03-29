import java.util.*;
import java.io.*;

public class Syllable {
    private static int two = 0;
    private static int three = 0;
    private static int four = 0;
    private static int five = 0;

    public static int SyllableCount(String s) {
        
        int count = 0;
        s = s.toLowerCase(); 
        boolean isPrevVowel = false;
    
        for (int j = 0; j < s.length(); j++) {
            if (s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") || s.contains("u")) {
                if (isVowel(s.charAt(j)) && !((s.charAt(j) == 'e') && (j == s.length()-1))) {
                    if (isPrevVowel == false) {
                        count++;
                        isPrevVowel = true;
                    }
                } else {
                    isPrevVowel = false;
                }
            } else {
                count++;
                break;
            }
        }
        if(count == 2){
            two++;
        }else if(count == 3){
            three++;
        }else if(count == 4){
            four++;
        }else if(count == 5){
            five++;
        }
        return count;
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String []args) throws FileNotFoundException{
        File file = new File("textFiles/4Syllables.txt");
        try (Scanner sc = new Scanner(file)) {
            System.out.println("Test1");
            while(sc.hasNextLine()){
                
                String n = sc.nextLine();
                System.out.println(SyllableCount(n));         
                }

                System.out.println("2 Syllables: " + two);
                System.out.println("3 Syllables: " + three);
                System.out.println("4 Syllables: " + four);
                System.out.println("5 Syllables: " + five);  
        }
    }
}

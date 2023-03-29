import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class tester {
    
    static int numSyllables[];
    static int syl, total = 0, currentSyllable = 0;
    static ArrayList<Double> accuracies = new ArrayList<Double>();

    // Files for syllables gotten from: https://github.com/gautesolheim/25000-syllabified-words-list (Only first 300 words of each file)
    static String files[] = 
    {"textFiles/1Syllables.txt", 
    "textFiles/2Syllables.txt",
    "textFiles/3Syllables.txt",
    "textFiles/4Syllables.txt",
    "textFiles/5Syllables.txt",
    "textFiles/6Syllables.txt",
    "textFiles/7Syllables.txt",
    "textFiles/8Syllables.txt"
    };
    
    public static void main(String[] args){

        for(String file : files){
            resetSyllables();

            Syllable2 s = new Syllable2();
            String syllableFile = "./Syllables.txt";
            s.loadFile(syllableFile);
            Scanner scan;
            try{
                scan = new Scanner(new File(file));
            } catch(FileNotFoundException e){
                System.err.println("File not found: " + file);
                System.out.println(file + " " + files[files.length-1] + " " + file.equals(files[files.length-1]) + " " + accuracies.size());
                if(file.equals(files[files.length-1])){
                    printAccuracies();
                } continue;
            }
            while (scan.hasNext()) {
                String word = scan.next().toLowerCase();
                if (s.hm.containsKey(word)) {
                    syl = s.hm.get(word);
                    numSyllables[syl-1]++;
                    total++;
                } else {
                    syl = s.countSyllables(word);
                    if(syl == 0);
                    else{
                        numSyllables[syl-1]++;
                        total++;
                    }
                }
            }
            scan.close();
            accuracies.add((double)numSyllables[currentSyllable]/total*100);

            for(int i = 0; i < numSyllables.length; i++){
                System.out.println("Number of words with " + (i+1) + " syllables: " + numSyllables[i]);
            } System.out.println("\nTotal number of words: " + total);
            currentSyllable++;
        }

        printAccuracies();
        
    }

    public static void printAccuracies(){
        //Printing out the accuracy of the program for each set of syllables
        for(int i = 0; i < accuracies.size(); i++){
            System.out.printf("\nAccuracy for %s syllables: %.2f%%", (i+1), accuracies.get(i));
        } System.out.print("\n");
    }

    public static void resetSyllables(){
        numSyllables = new int[8];
        total = 0;
    }
}

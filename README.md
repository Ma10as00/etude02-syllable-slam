# Etude02-Syllable-slam

## Compiling the program
To begin, this program and repo will require you to have the following installed:
- [Git](https://git-scm.com/downloads) (If you plan to clone the repository, alternatively you can just download it.)
- [Java](https://www.java.com/en/download/) (This program was written in Java 16, but should work with any version of Java 16 or higher.)

Once you have the above installed, you can either clone the repository or download the zip file. 

If you choose to clone the repository, you can do so by running the following command in your terminal (provided you have access to clone it):

```git clone https://altitude.otago.ac.nz/cosc326-four-functioneers/etude02-syllable-slam ```

With the repository cloned, you can compile the program by running the following command in the terminal:  
```javac *.java```

## Running the program
To run the program, you can run the following command in the terminal:  
```java SyllableCounter.java```

This will run the program, and it will read from the terminal for input. 
You can also run the program with a file as input by running the following command:  
```java SyllableCounter.java < input_file```,
where ```input_file``` is the path to the file you want to read from.

The program will then read the file line by line.

## How It Works
So, the first thing that the program does is make a hashmap full of words taken from the word library found from ```http://www.delphiforfun.org/programs/Syllables.htm```. The library consists of over 40,000 words and every line is formatted such that "word"="syllable 1"-"syllable 2"-"final syllable". So we simply made the hashmap's key prpoperty be the word string itself, and their value be the number of syllables on the other side of the equal sign. Sadly, this will have the Big O notation of the number of lines there are in the text file itself although, if the word you're looking for is in the text file, then it will give you the number of syllables in Big O of 1.

If a word is not found in the 40,000 word : syllables text file, then we go to our syllable pattern finder. Our syllable pattern finder revolves mostly around vowels. To check if a part of the word is a syllable, we check every letter and see if it has been preceded by vowels. 

## Testing the program and benchmarking
For testing our syllable counting algorithm, we have created a java file called Tester.java which uses files full of words with the same number of syllables to give to the syllable counter. These syllable testing files were taken from ```https://github.com/gautesolheim/25000-syllabified-words-list``` (Only first 300 words of each file).
The file is located in the ```textFiles/``` folder.  
To run the tester, you can run the following command in the terminal:  
```java Testing.java```

This will read from the 8 files currently stored in the ```textFiles/``` folder. (1Syllables.txt to 8Syllables.txt)  
The program can only handle files with a maximum of 8 syllables.  
The tester will output the number of syllables counted for each word in the file, and the accuracy of the program for each file.

What we found is testing using these files, our accuracy without the word : syllables text file is:  
Accuracy for 1 syllables: 74.67%  
Accuracy for 2 syllables: 75.00%  
Accuracy for 3 syllables: 77.33%  
Accuracy for 4 syllables: 78.67%  
Accuracy for 5 syllables: 69.67%  
Accuracy for 6 syllables: 60.78%  
Accuracy for 7 syllables: 47.50%  
Accuracy for 8 syllables: 50.00%  

Although what we found if we did use the word : syllable text file is that our accuracy jumps to:  
Accuracy for 1 syllables: 98.67%  
Accuracy for 2 syllables: 98.67%  
Accuracy for 3 syllables: 99.33%  
Accuracy for 4 syllables: 99.33%  
Accuracy for 5 syllables: 85.33%  
Accuracy for 6 syllables: 69.96%  
Accuracy for 7 syllables: 55.00%  
Accuracy for 8 syllables: 50.00%  
  
What this indicates is that we don't have the most accurate synonym counter program. It starts falling off steeply at 6 syllable words. If we had a larger word : synonym text file, or if we had a better synonym pattern finder, we could be more accurate. Although, what we found is that programmatically, there is no real "best" way to find the synonym patterns because there are too many exceptions to the rules you can think of for words in the English language without accounting for them directly.  There are many word : synonym pattern finders in the internet using much more complex ways of finding synonyms like phenome recognition but we think there is no 100% accurate way of doing this.
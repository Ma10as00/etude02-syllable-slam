# Etude02-Syllable-slam

## Compiling the program
To begin, this program and repo will require you to have the following installed:
- [Git](https://git-scm.com/downloads) (If you plan to clone the repository, alternatively you can just download it.)
- [Java](https://www.java.com/en/download/) (This program was written in Java 16, but should work with any version of Java 16 or higher.)

Once you have the above installed, you can either clone the repository or download the zip file. 

If you choose to clone the repository, you can do so by running the following command in your terminal (provided you have access to clone it):

```git clone https://altitude.otago.ac.nz/cosc326-four-functioneers/etude02-syllable-slam ```

With the repository cloned, you can compile the program by running the following command in the terminal:  
```javac -d bin src/*.java```

## Running the program
To run the program, you can run the following command in the terminal:  
```java src/SyllableCounter.java```

This will run the program, and it will read from the terminal for input. 
You can also run the program with a file as input by running the following command:  
```java src/SyllableCounter.java < input_file```,
where ```input_file``` is the path to the file you want to read from.

The program will then read the file line by line.

## How It Works
So, the first thing that the program does is make a hashmap full of words taken from the word library found from ```http://www.delphiforfun.org/programs/Syllables.htm```. The library consists of over 40,000 words and every line is formatted such that "word"="syllable 1"-"syllable 2"-"final syllable". So we simply made the hashmap's key prpoperty be the word string itself, and their value be the number of syllables on the other side of the equal sign. Sadly, this will have the Big O notation of the number of lines there are in the text file itself although, if the word you're looking for is in the text file, then it will give you the number of syllables in Big O of 1.

If a word is not found in the 40,000 word : syllables text file, then we go to our syllable pattern finder. Our syllable pattern finder revolves mostly around vowels. To check if a part of the word is a syllable, we check if the 

## Testing the program and benchmarking
For testing our syllable counting algorithm, we have created a java file called Tester.java which uses files full of words with the same number of syllables to give to the syllable counter. These syllable testing files were taken from ```https://github.com/gautesolheim/25000-syllabified-words-list``` (Only first 300 words of each file).
The file is located in the ```src/textFiles/``` folder.  
To run the tester, you can run the following command in the terminal:  
```java src/Testing.java```

This will read from the 8 files currently stored in the ```src/textFiles/``` folder. (1Syllables.txt to 8Syllables.txt)  
The program can only handle files with a maximum of 8 syllables.  
The tester will output the number of syllables counted for each word in the file, and the accuracy of the program for each file.

What we found is with these files, our accuracy is 
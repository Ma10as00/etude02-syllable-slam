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

## Testing the program
For testing our syllable counting algorithm, we have created a java file called Tester.java which uses files full of words with the same number of syllables to give to the syllable counter.  
The file is located in the ```textFiles/``` folder.  
To run the tester, you can run the following command in the terminal:  
```java Tester.java```

This will read from the 8 files currently stored in the ```textFiles/``` folder. (1Syllables.txt to 8Syllables.txt)  
The program can only handle files with a maximum of 8 syllables.  
The tester will output the number of syllables counted for each word in the file, and the accuracy of the program for each file.

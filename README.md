# COMP20290 Algorithms Portfolio
This repository contains all of my code for the practicals throughout the semester. It also includes an analysis of the algorithms for
each of the practicals (where this is applicable i.e. Trie and Compression practicals did not include this). These analyses are provided 
as excel files, where each of the excel files contain a table which shows how long (in nanoseconds) the algorithms take to compute for 
different values of N. The practicals are divided into separate packages but practicals 4, 5 and 6 are in the same package as they are all for sorting algorithms. The repository also contains the code for the Huffman Compression Assignment. On top of this, it contains
the compressed and decompressed files for Task 3 of the Huffman Assignment. You will find the Huffman Compression Assignment in a separate source folder called "compression-assignment". In this source folder there are two packages - one which contains all of the data (i.e. original files, compressed files and decompressed files) and the other contains all of the code. The answer to task 2 for the assignment is found in the class "HuffmanAlgorithm". The answers to task 1 (if you wish to view the images for task 1 in full size, they are also found in the folder called "Huffman-Task1") and analyses for task 3 are in the pdf called HuffmanAssignment.pdf, which is found at the root of this project.

## Getting Started
To get a copy of this project on your local machine, open your IDE and choose to import a project from github. Then, use the URL
https://github.com/CompAlgorithms/algorithm-portfolio-20290-iva-mechkarova to import the repository. For example, on eclipse 
go to File > Import > Git > Projects from git (with smart import) > Clone URL and enter the URL.

## Running The Algorithms
When you have imported the project, you should see a class called Main. Here, you will be able to run any of the algorithms from 
any of the practicals. When you click to run this method, you will be prompted to enter the number which corresponds to the algorithm
that you wish to run. However, bare in mind that for the ThreeSumA and ThreeSumB algorithms you must enter the file that you wish to
run them with (e.g. 4Kints.txt) in the program arguments. In eclipse, this can be done by clicking on "run configurations" and entering
the name of the file in program arguments. E.g. enter "practical2/4Kints.txt" as program argument to use 4Kints.txt. If you are running
the files on command line, then you must enter the name of the file as a command line argument e.g. "java ThreeSumA 4Kints.txt". All
of the classes from each of the practicals also include a main method so if you prefer, you can also run the algorithms from the main
method in their class file. 

## Analysing The Algorithms
I have set up Fibonacci and Sorting to be run with various different inputs and the time taken is calculated in nanoseconds after they 
run with each value of N - the value of N and time in nanoseconds is printed to the console. For sorting, you can change the value of
"typeSort" in order to select which sort to use. For Hanoi and RussianPeasant algorithms you may enter different parameter values to 
test the speed of the algorithms - this is how the analyses was obtained for them. For the search string practical, you may test the
speed of the algorithms by editing bruteForce.txt and KMPSearch.txt - I have made both txt files to contain the same text, in order to 
compare the algorithms. Each line of the text files is longer than the previous one, in order to test how the algorithms perform with
strings of different length. The time taken for each algorithm to run will be printed to the console in nanoseconds after each algorithm has run.

## Built With
* [Eclipse Version 2019-12 (4.14.0)](https://www.eclipse.org/downloads/packages/release/2019-12) - The IDE used

## Authors
* [Iva Mechkarova](https://github.com/iva-mechkarova)

## Acknowledgements
* [Starter Code](https://github.com/CompAlgorithms/comp20290-algorithms)

package org.example.ModuleTwo;

import java.nio.file.*;
import java.io.*;

public class WordLengths {

    // Method to count the word lengths
    public void countWordLengths(String filePath, int[] counts) {
        try {
            // Read the content of the file
            String message = new String(Files.readAllBytes(Paths.get(filePath)));
            int length = 0;

            // Iterate through each character in the file
            for (int i = 0; i < message.length(); i++) {
                char currentChar = message.charAt(i);

                if (Character.isLetter(currentChar)) {
                    // If it's a letter, count it as part of the word
                    length++;
                } else {
                    // If the length is greater than 0, we need to record the word length
                    if (length > 0) {
                        // Check if the next character is a letter or we are at the end of the file
                        if (i + 1 < message.length() && Character.isLetter(message.charAt(i + 1)) && message.charAt(i) != ' ') {
                            // If the next character is a letter, we keep counting the length
                            length++;
                        } else {
                            // Record the word length and reset length
                            if (length >= counts.length) {
                                counts[counts.length - 1]++;
                            } else {
                                counts[length]++;
                            }
                            length = 0;  // Reset the length for the next word
                        }
                    }
                }
            }

            // Handle last word if file ends with a letter
            if (length > 0) {
                if (length >= counts.length) {
                    counts[counts.length - 1]++;
                } else {
                    counts[length]++;
                }
            }

            // Print results
            for (int j = 1; j < counts.length; j++) {
                if (counts[j] > 0) {
                    System.out.println(counts[j] + " words of length " + j);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private int indexOfMax(int[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void testCountWordLengths(){
        String filePath = "/Users/gkats/Java Programming-Arrays-Lists-StructuredData/wordLength.txt"; // Replace with your file path
        int[] counts = new int[31];
        countWordLengths(filePath, counts);
        System.out.println("Index of max is :" + indexOfMax(counts));

    }
}



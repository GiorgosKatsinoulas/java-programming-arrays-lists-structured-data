package org.example;

import org.example.ModuleTwo.CaesarBreaker;
import org.example.ModuleTwo.CaesarCipher;
import org.example.ModuleTwo.WordLengths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Caesar Cipher Testing
//        CaesarCipher cv = new CaesarCipher();
//        System.out.println(cv.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
//        cv.testCaesar();
//        System.out.println(cv.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",20));
    //Word Length Testing
//        String filePath = "/Users/gkats/Java Programming-Arrays-Lists-StructuredData/wordLength.txt"; // Replace with your file path
//        WordLengths wl = new WordLengths();
//        int[] counts = new int[31];
//        wl.countWordLengths(filePath,counts);
//        WordLengths wl = new WordLengths();
//        wl.testCountWordLengths();

        //Caesar Breaker Testing
        CaesarBreaker cb = new CaesarBreaker();
//        cb.testDecrypt();
        cb.testDecryptTwoKeys();

    }
}
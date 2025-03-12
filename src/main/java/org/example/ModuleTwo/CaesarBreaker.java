package org.example.ModuleTwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CaesarBreaker {

    public String decrypt(String encrypted,int key){
        CaesarCipher cipher = new CaesarCipher ();

        // Step 1: Count letter frequencies
        int[] freq = countLetter(encrypted);

//        for (int i = 0; i < freq.length; i++) {
//            System.out.println(freq[i]);
//        }

        // Step 2: Find the index of the most frequent letter
        int maxDex = maxIndex(freq);


//        System.out.println("Max Index: " + maxDex);
        // Step 3: Assume 'e' (index 4) was the most common letter in original text
        int dKey = maxDex - 4;
        if (maxDex < 4) {
            dKey = 26 - (4 - maxDex);
        }

        //Optional:Loop until you find the key with which was encrypted.(maybe show for now all )
//        for (int j = 1; j <= 26; j++) {
//        System.out.println("Key " + j + ": " + cipher.encrypt(encrypted, 26 - j));
//        }
//        System.out.println("Decryption Key Found: " + dKey);

        // Step 4: Decrypt using the calculated key
        String decrypted = cipher.encrypt(encrypted, 26 - dKey);

        return decrypted;
    }


    public String decryptTwoKeys(String encrypted){
        String s1 = halfOfString(encrypted,0);
        String s2 = halfOfString(encrypted,1);
        int key1 = getKey(s1);
        int key2 = getKey(s2);

        System.out.println("Key1: " + key1 + " Key2: " + key2);
        CaesarCipher cipher = new CaesarCipher();
        String decrypted  = cipher.encryptTwoKeys(encrypted, 26 - key1, 26 - key2);
        return decrypted;

    }
//    public int getKey(String s) {
//        int[] counts = countLetters(s);
//        int maxIdx = maxIndex(counts);
//        int dkey = maxIdx - 4; // 'e' is at index 4
//        if (dkey < 0) {
//            dkey += 26;
//        }
//        return dkey;
//    }
    public int getKey(String s){
        int[] freq = countLetter(s);
        int maxDex = maxIndex(freq);

        // Assume the most common letter in English is 'e' (index 4)
        int assumedEIndex = 4;

        // Compute decryption key
        int dKey = maxDex - assumedEIndex;
        if (maxDex < assumedEIndex) {
            dKey = 26 - (assumedEIndex - maxDex);
        }

        return dKey;
    }

    public String halfOfString(String input, int start){
        StringBuilder halfStr = new StringBuilder();

        for (int i = start; i < input.length(); i+=2) {
            halfStr.append(input.charAt(i));
        }

        return halfStr.toString();
    }

    public int[] countLetter(String message){
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counters = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if(index != -1){
                counters[index]++;
            }
        }
        return counters;
    }
    public int maxIndex(int[] array){
        int maxIndex = 0;
        for(int i=1; i < array.length; i++){
            if(array[i] > array[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void testDecryptTwoKeys() {
        String filePath = "/Users/gkats/Java Programming-Arrays-Lists-StructuredData/encrypted.txt"; // Replace with your file path
        try {
            String encrypted = new String(Files.readAllBytes(Paths.get(filePath)));
            String decrypted = decryptTwoKeys(encrypted);
            System.out.println("Decrypted message: " + decrypted);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

    }

    public void testDecrypt() {
        String original = "Just a test string with lots of eeeeeeeeeeeeeeeees";
        int key = 23;
        CaesarCipher cipher = new CaesarCipher();
        String encrypted = cipher.encrypt(original, key);
        String decrypted = decrypt(encrypted, key);
        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }

}



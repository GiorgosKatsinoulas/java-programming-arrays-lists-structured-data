package org.example.ModuleTwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CaesarCipher {

    public String encrypt(String input, int key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        String result = "";

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean isLowerCase = Character.isLowerCase(c);
                char upperChar = Character.toUpperCase(c);
                int idx = alphabet.indexOf(upperChar);

                if (idx != -1) {
                    char shiftedChar = shiftedAlphabet.charAt(idx);
                    result += isLowerCase ? Character.toLowerCase(shiftedChar) : shiftedChar;
                } else {
                    result += c;
                }
            } else {
                result += c;
            }
        }
// NOTE Second implementation
//        for(int i= 0; i < input.length(); i++){
//           char c = input.charAt(i);
//
//           if(Character.isUpperCase(c)){
//               int idx = alphabet.indexOf(c);
//               if(idx != -1){
//                   result += shiftedAlphabet.charAt(idx);
//               }else{
//                   result += c;
//               }
//           }else if(Character.isLowerCase(c)){
//               char upperChar = Character.toUpperCase(c);
//               int idx = alphabet.indexOf(upperChar);
//               if(idx != -1){
//                   result += Character.toLowerCase(shiftedAlphabet.charAt(idx));
//               }else{
//                   result += c;
//               }
//           }else{
//               result += c;
//           }
//        }
        return result;
    }


    public String encryptTwoKeys(String input, int key1, int key2){
        String result = "";

        for(int i=0; i < input.length(); i++){
            char c = input.charAt(i);
            if(i % 2 == 0){
               result +=  encrypt(Character.toString(c),key1);
            }else{
                result +=  encrypt(Character.toString(c),key2);
            }
        }
        return result;
//Second Implementation
//        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        String result = "";
//
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            int key = (i % 2 == 0) ? key1 : key2;
//
//            if (Character.isLetter(c)) {
//                boolean isLower = Character.isLowerCase(c);
//                char upperC = Character.toUpperCase(c);
//                int idx = alphabet.indexOf(upperC);
//                int shiftedIdx = (idx + key) % 26;
//                char shiftedChar = alphabet.charAt(shiftedIdx);
//                result += isLower ? Character.toLowerCase(shiftedChar) : shiftedChar;
//            } else {
//                result += c; // Keep spaces, punctuation, etc.
//            }
//        }
//        return result;
    }

    public void testCaesar() {
        String filePath = "/Users/gkats/Java Programming-Arrays-Lists-StructuredData/message.txt"; // Replace with your file path
        try {
            String message = new String(Files.readAllBytes(Paths.get(filePath)));
            int key = 20; // Example key
            String encrypted = encrypt(message, key);
            System.out.println("Key is " + key + "\n" + encrypted);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

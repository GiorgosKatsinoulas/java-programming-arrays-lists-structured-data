package org.example.ModuleTwo;

public class WordPlay {

    public static boolean isVowel(char ch) {
        return "aeiou".indexOf(Character.toLowerCase(ch)) >= 0;
    }
    public String replaceVowels(String phrase, char ch) {
        String result = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (isVowel(phrase.charAt(i))) {
                result += ch;
            } else {
                result += phrase.charAt(i);
            }
        }
        return result;
    }
    public String emphasize(String phrase, char ch) {
        String result = "";
        char target = Character.toLowerCase(ch);

        for (int i = 0; i < phrase.length(); i++) {
            char currentChar = phrase.charAt(i);
            if (Character.toLowerCase(currentChar) == target) {
                if (i % 2 == 0) {
                    result += "*";
                } else {
                    result += "+";
                }
            } else {
                result += currentChar;
            }
        }
        return result;
    }
}

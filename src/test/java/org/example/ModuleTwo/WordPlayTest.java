package org.example.ModuleTwo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordPlayTest {

    @Test
    public void testIsVowel_LowercaseVowels() {
        assertTrue(WordPlay.isVowel('a'));
        assertTrue(WordPlay.isVowel('e'));
        assertTrue(WordPlay.isVowel('i'));
        assertTrue(WordPlay.isVowel('o'));
        assertTrue(WordPlay.isVowel('u'));
    }

    @Test
    public void testIsVowel_UppercaseVowels() {
        assertTrue(WordPlay.isVowel('A'));
        assertTrue(WordPlay.isVowel('E'));
        assertTrue(WordPlay.isVowel('I'));
        assertTrue(WordPlay.isVowel('O'));
        assertTrue(WordPlay.isVowel('U'));
    }

    @Test
    public void testIsVowel_NonVowelCharacters() {
        assertFalse(WordPlay.isVowel('b'));
        assertFalse(WordPlay.isVowel('Z'));
        assertFalse(WordPlay.isVowel('F'));
        assertFalse(WordPlay.isVowel('!'));
        assertFalse(WordPlay.isVowel('5'));
        assertFalse(WordPlay.isVowel(' '));
    }

    @Test
    public void testReplaceVowels_AllVowels() {
        WordPlay wp = new WordPlay();
        String result = wp.replaceVowels("aeiouAEIOU", '*');
        assertEquals("**********", result);
    }

    @Test
    public void testReplaceVowels_MixedCharacters() {
        WordPlay wp = new WordPlay();
        String result = wp.replaceVowels("Hello World!", '*');
        assertEquals("H*ll* W*rld!", result);
    }

    @Test
    public void testReplaceVowels_NoVowels() {
        WordPlay wp = new WordPlay();
        String result = wp.replaceVowels("Rhythm", '*');
        assertEquals("Rhythm", result);
    }

    @Test
    public void testReplaceVowels_EmptyString() {
        WordPlay wp = new WordPlay();
        String result = wp.replaceVowels("", '*');
        assertEquals("", result);
    }

    @Test
    public void testReplaceVowels_NumbersAndSymbols() {
        WordPlay wp = new WordPlay();
        String result = wp.replaceVowels("123!@#", '*');
        assertEquals("123!@#", result);
    }

    @Test
    public void testEmphasize_ExampleOne() {
        WordPlay wp = new WordPlay();
        String result = wp.emphasize("dna ctgaaactga", 'a');
        assertEquals("dn* ctg+*+ctg+", result);
    }

    @Test
    public void testEmphasize_ExampleTwo() {
        WordPlay wp = new WordPlay();
        String result = wp.emphasize("Mary Bella Abracadabra", 'a');
        assertEquals("M+ry Bell+ +br*c*d*br+", result);
    }

    @Test
    public void testEmphasize_UpperCaseTarget() {
        WordPlay wp = new WordPlay();
        String result = wp.emphasize("AaAa", 'A');
        assertEquals("*+*+", result);
    }

    @Test
    public void testEmphasize_NoMatches() {
        WordPlay wp = new WordPlay();
        String result = wp.emphasize("Hello World!", 'x');
        assertEquals("Hello World!", result);
    }

    @Test
    public void testEmphasize_EmptyString() {
        WordPlay wp = new WordPlay();
        String result = wp.emphasize("", 'a');
        assertEquals("", result);
    }

}
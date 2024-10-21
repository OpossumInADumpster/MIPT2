package com.example.mipt2;

public class TextCounter {
    public static int countSymbols(String phrase){
        return phrase.length();
    }

    public static int countWords(String phrase){
        if (phrase == null || phrase.isEmpty()) {
            return 0;
        }
        String[] words = phrase.trim().split("\\s+");
        return words.length;
    }
}


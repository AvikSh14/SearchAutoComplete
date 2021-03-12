package com.avik.SearchAutoCompleteSuggestion.utilities;

import static com.avik.SearchAutoCompleteSuggestion.utilities.Constants.ASCII_VALUE_COUNT;

public class Trie {

    Trie[] children;// = new Trie[CHAR_COUNT];
    boolean isCompleted;
    Trie(){
        children = new Trie[ASCII_VALUE_COUNT];
        for(int i=0; i<ASCII_VALUE_COUNT; i++){
            children[i] = null;
        }
        isCompleted = false;
    }
}

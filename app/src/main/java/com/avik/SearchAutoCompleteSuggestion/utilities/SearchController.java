package com.avik.SearchAutoCompleteSuggestion.utilities;

import java.util.*;
public class SearchController {
    public static List<String> getSuggestedWordsFromList(List<String> words, String typedWord){
        Trie trie = new Trie();
        AutoCompleteSearch autoCompleteSearch = new AutoCompleteSearch(trie);
        for(String word : words){
            autoCompleteSearch.insert(word);
        }
        Set<String> wordSet = new HashSet<>(words);
        return autoCompleteSearch.findWordsWithPrefix(typedWord, wordSet);
    }
}

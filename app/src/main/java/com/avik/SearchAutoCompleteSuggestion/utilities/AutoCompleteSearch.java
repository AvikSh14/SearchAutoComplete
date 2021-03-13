package com.avik.SearchAutoCompleteSuggestion.utilities;

import java.util.*;

import static com.avik.SearchAutoCompleteSuggestion.utilities.Constants.ASCII_VALUE_COUNT;

public class AutoCompleteSearch {
    Trie root;

    public AutoCompleteSearch(Trie root) {
        this.root = root;
    }

    void insert(String word){
        Trie curNode = root;
        for(char ch : word.toCharArray()){
            int index = (int) ch;
            if(curNode.children[index]==null){
                curNode.children[index] = new Trie();
            }
            curNode = curNode.children[index];
        }
        curNode.isCompleted = true;
    }

    public List<String> findWordsWithPrefix(String prefix, Set<String> set){
        Trie cur = root;
        List<String> suggestions = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : prefix.toCharArray()){
            int index = (int) ch;
            if(cur.children[index]==null){
                System.out.println("No words found");
                return suggestions;
            }
            sb.append(ch);
            cur = cur.children[index];
        }
        int matchedPrefixCount = 0;
        for(int i=0; i<ASCII_VALUE_COUNT; i++){
            if(cur.children[i]!=null) matchedPrefixCount++;
        }
        System.out.println(matchedPrefixCount);

        getWords(cur, suggestions, set, sb);
        for(String val : suggestions){
            System.out.println(val);
        }

        return suggestions;
    }

    void getWords(Trie curNode, List<String> suggestions,
                  Set<String> set, StringBuilder sb){
        if(curNode.isCompleted && set.contains(sb.toString())){
            suggestions.add(sb.toString());
        }

        for(int i=0; i<ASCII_VALUE_COUNT; i++){
            if(curNode.children[i]!=null){
                Trie temp = curNode.children[i];
                sb.append((char) (i));
                getWords(temp, suggestions, set, sb);
                sb.setLength(sb.length()-1);
            }
        }
    }
}

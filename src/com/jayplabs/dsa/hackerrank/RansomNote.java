package com.jayplabs.dsa.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Chandra Gopalaiah on 11/7/16.
 */
public class RansomNote {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        String[] magazineWords = magazine.split(" ");
        for (String word : magazineWords) {
            if (magazineMap.containsKey(word)) {
                magazineMap.put(word, magazineMap.get(word)+1);
            } else {
                magazineMap.put(word, 1);
            }
        }

        String[] noteWords = note.split(" ");
        for (String word : noteWords) {
            if (noteMap.containsKey(word)) {
                noteMap.put(word, noteMap.get(word)+1);
            } else {
                noteMap.put(word, 1);
            }
        }
    }

    public boolean solve() {
        Set<String> noteWords = noteMap.keySet();

        for (String word : noteWords) {
            if (!magazineMap.containsKey(word)) return false;
            if (magazineMap.get(word) < noteMap.get(word)) return false;

            magazineMap.put(word, magazineMap.get(word) - noteMap.get(word));
        }

        return true;
    }

    public static void main(String[] args) {
        String magazine = "give me one grand today night";
        String note = "give one grand today";

        RansomNote rn = new RansomNote(magazine, note);
        boolean answer = rn.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
    }


}

package LaiOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuehu on 7/1/20.
 * Q: Find all anagrams of string s in string l, return all the starting indices.
 * Assumption: s, l are not null, s is not empty
 *
 */
public class AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new ArrayList<Integer>();
        if (l.length() == 0) {
            return result;
        }
        // when s is longer than l, there is no way any of the substring of l
        // could be an anagram of s.
        if (s.length() > l.length()) {
            return result;
        }
        // This map records for each of the distinct characters is s,
        // how many characters are needed.
        // eg. s = "abbc", map = {'a': 1, 'b': 2, 'c': 1}
        // when we get an in stance of 'a' in l, we let count of 'a' decremented by 1.
        // and only when the count is from 1 to 0, we have 'a' totally matched.
        Map<Character, Integer> map = countMap(s);
        int match = 0;
        for (int i = 0; i < l.length(); i++) {
            // handle the new added character(rightmost) at the current sliding window.
            char tmp = l.charAt(i);
            Integer count = map.get(tmp);
            if (count != null) {
                map.put(tmp, count - 1);
                if (count == 1) {
                    match++;
                }
            }
            // handle the leftmost character at the previous sliding window.
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                count = map.get(tmp);
                if (count != null) {
                    map.put(tmp, count+1);
                    if (count == 0) {
                        match--;
                    }
                }
            }
            if (match == map.size()) {
                result.add(i - s.length() + 1);
            }
        }
        return result;
    }


    private Map<Character,Integer> countMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch: s.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        AllAnagrams a = new AllAnagrams();
        String s = "aabc";
        String l = "zzzzcdebcaabcyywwww";
        System.out.println(a.allAnagrams(s, l));
    }

}

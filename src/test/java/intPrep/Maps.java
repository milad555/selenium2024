package intPrep;

import java.util.HashMap;
import java.util.Map;

public class Maps {
    public Map<String, String> mapBully(Map<String, String> map) {
        if (map.get("a") != null) {
            map.put("b", map.get("a"));
            map.put("a", "");
        }
        return map;
    }


    //Given an array of non-empty strings,
// return a Map<String, String> with a key for every different first character seen,
// with the value of all the strings starting with that character appended together in the order they appear in the array.
    public static Map<String, String> firstChar(String[] strings) {
        Map<String, String> result = new HashMap<>();

        for (String str : strings) {
            String firstChar = str.substring(0, 1); // Extract the first character as a key
            result.put(firstChar, result.getOrDefault(firstChar, "") + str); // Append the string to the key's value
        }

        return result;
    }


    public static void main(String[] args) {
        String[] strings = {"apple", "banana", "apricot", "blueberry", "avocado", "berry"};

        firstChar(strings);
    }

    public String mergeAlternately(String word1, String word2) {
        //shoul not be empty strings
//word1 = "abc", word2 = "pqr"
        //word1 = "abczxp", word2 = "pqr"
        StringBuilder sb = new StringBuilder();

        int len1 = word1.length()-1;
        int len2 = word2.length()-1;
        int idx = 0;
        String res = "";
        while(idx <=len1 && idx <=len2){
            res += word1.charAt(idx) + word2.charAt(idx);
            idx++;
        }
        res += word1.substring(idx,len1 ) + word2.substring(idx,len2);
        return res;

    }
}

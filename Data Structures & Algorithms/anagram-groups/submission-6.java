public class Solution {

    /**
    For each string, I sort its characters to create an anagram key. Sorting takes O(K log K), and I do this for N strings, so the overall time complexity is O(NK log K). The HashMap stores the strings and their sorted keys, requiring O(NK) space.
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String key = Arrays.toString(charArray);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
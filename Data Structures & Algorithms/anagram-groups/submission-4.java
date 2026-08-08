public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            res.putIfAbsent(Arrays.toString(charArray), new ArrayList<>());
            res.get(Arrays.toString(charArray)).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
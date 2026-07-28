public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            int[] count = new int[26];
            for(int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder sb  = new StringBuilder();
            for(int j = 0; j < count.length; j++) {
                sb.append("#");
                sb.append(count[j]);
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
}
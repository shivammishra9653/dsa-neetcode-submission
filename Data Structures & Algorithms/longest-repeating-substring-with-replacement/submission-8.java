class Solution {
    public int characterReplacement(String s, int k) {
        if(k==s.length()) {
            return k;
        }

        int res = 0;
        int maxFreq = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                maxFreq = Math.max(maxFreq, map.get(c));
                if(j - i + 1 - maxFreq <= k) {
                    res = Math.max(res, j-i+1);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}

class Solution {
    public int characterReplacement(String s, int k) {
        if(k==s.length()) {
            return k;
        }

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0; 
        int r = 0;
        int maxFreq = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            while((r-l+1-maxFreq) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}

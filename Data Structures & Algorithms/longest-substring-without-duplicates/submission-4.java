class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}

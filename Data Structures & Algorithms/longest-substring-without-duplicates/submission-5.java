class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            if(map.containsKey(s.charAt(r))) {
                // we are doing Math.max because whenever we are updating
                //  value of l we ae not removing the characters which exist between
                //  the current index of l and after jumping next to the duplicate character index
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}

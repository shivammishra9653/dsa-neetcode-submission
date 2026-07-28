class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(String.valueOf(s.charAt(i)));
            for(int j = i+1; j < s.length(); j++) {
                if(sb.indexOf(String.valueOf(s.charAt(j))) == -1) {
                    sb.append(s.charAt(j));
                } else {
                    break;
                }
            }
            res = Math.max(res, sb.length());
        }
        return res;
    }
}

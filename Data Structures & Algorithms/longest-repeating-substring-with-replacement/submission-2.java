class Solution {
    public int characterReplacement(String s, int k) {
        if(k==s.length()) {
            return k;
        }
        int res = 1;
        for(int i = 0; i < s.length()-1; i++) {
            int count = k;
            int j = i+1;
            while(j < s.length()) {
                if(s.charAt(i) != s.charAt(j)) {
                    if(count > 0) {
                        count--;
                    } else {
                        break;
                    }
                }
                j++;
            }
            if(count > 0 && j-i < s.length()) {
                res = Math.max(res, j-i + Math.min(s.length()-(j-i), count));
            } else {
                res = Math.max(res, j-i);
            }
        }
        return res;
    }
}

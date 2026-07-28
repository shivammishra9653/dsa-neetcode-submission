class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] f1 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = s1.length();
        while(r <= s2.length()) {
            int[] f2 = new int[26];
            for(int i = l; i < r; i++) {
                f2[s2.charAt(i) - 'a']++;
            }
            boolean isPerm = true;
            for(int j = 0; j < 26; j++) {
                if(f1[j] != f2[j]) {
                    isPerm = false;
                    break;
                }
            }
            if(isPerm) {
                return true;
            }
            l++; r++;
        }
        return false;
    }
}

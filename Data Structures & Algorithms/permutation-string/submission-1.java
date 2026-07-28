class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        int l = 0; 
        int r = s1.length();
        while(r <= s2.length()) {
            char[] ch2 = s2.substring(l, r).toCharArray();
            Arrays.sort(ch2);
            boolean flag = true;
            for(int i = 0; i < ch1.length; i++) {
                if(ch1[i] != ch2[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return true;
            }
            l++; r++;
        }
        return false;
    }
}

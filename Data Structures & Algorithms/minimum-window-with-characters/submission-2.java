class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> countS = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int have = 0;
        int need = countT.size();
        int[] res = new int[2];
        int resLength = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        while(r < s.length()) {
            if(countT.containsKey(s.charAt(r))) {
                Character c = s.charAt(r);
                countS.put(c, countS.getOrDefault(c, 0) + 1);
                if(countT.get(c) == countS.get(c)) {
                    have++;
                }
            }
            while(have == need) {
                 if(have == need && resLength > (r-l+1)) {
                res[0] = l;
                res[1] = r;
                resLength = r-l+1;
            }
                if(countT.containsKey(s.charAt(l))) {
                    countS.put(s.charAt(l), countS.getOrDefault(s.charAt(l), 0) - 1);
                    if(countS.get(s.charAt(l)) < countT.get(s.charAt(l))) {
                        have--;
                    }
                }
                l++;
            }
            r++;
        }
        return resLength == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}

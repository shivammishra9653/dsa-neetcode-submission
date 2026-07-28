class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if(set.contains(str)) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(str);
            for(int j = 0; j < str.length(); j++) {
                map1.put(str.charAt(j), map1.getOrDefault(str.charAt(j), 0) + 1);
            }

            for(int k = i+1; k < strs.length; k++) {
                String str1 = strs[k];
                if(str1.length() != str.length()){
                    continue;
                }
                for(int j = 0; j < str1.length(); j++) {
                map2.put(str1.charAt(j), map2.getOrDefault(str1.charAt(j), 0) + 1);
            }
            boolean flag = true;
            for(Character chr : map1.keySet()) {
                if(map1.get(chr) != map2.get(chr)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add(str1);
                set.add(str1);
            }
            map2.clear();

            }
            ans.add(list);
            map1.clear();
        }
        return ans;
    }
}

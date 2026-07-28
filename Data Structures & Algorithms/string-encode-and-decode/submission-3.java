class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) {
            return "";
        }
        StringBuilder sb1 = new StringBuilder();
        for(String str : strs) {
            sb1.append(str.length());
            sb1.append(",");
        }
        sb1.append("#");
        for(String str : strs) {
            sb1.append(str);
        }
        return sb1.toString();
    }

    public List<String> decode(String str) {
        String[] strs = str.split("#", 2);
        String[] numsStr = strs[0].split(",");
        List<String> encoded = new ArrayList<>();
        if(str.length() == 0) {
            return encoded;
        }
        int prev = 0;
        for(int i = 0; i < numsStr.length; i++) {
            int size = Integer.parseInt(numsStr[i]);
            encoded.add(strs[1].substring(prev, size+prev));
            prev += size;
        }
        return encoded;
    }
}

class Solution {

    public boolean isValidChar(char c) {
        return (c >= 'a' && c <= 'z')
        || (c >= 'A' && c <= 'Z')
        || (c >= '0' && c <= '9');
    }

    public String prepareValidString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            if(isValidChar(c)) {
                sb.append(c);
            }
        }
        return sb.toString().toLowerCase();
    }
    public boolean isPalindrome(String s) {
       String str = prepareValidString(s);
       int l = 0;
       int r = str.length() - 1;
       while(l < r) {
        if(str.charAt(l++) != str.charAt(r--)) {
            return false;
        }
       }
       return true;
    }
}

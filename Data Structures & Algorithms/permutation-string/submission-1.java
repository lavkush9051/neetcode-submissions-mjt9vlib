class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashSet<Character> set = new HashSet<>();
        for(char c : s1.toCharArray()){
            set.add(c);
        }

        int left = 0;
        int r = s1.length();
        for(int i=0; i<s2.length(); i++){
            int length = 0;
            StringBuilder sb = new StringBuilder();
            if(s2.length() - r -i < 0){
                return false;
            }
            for(int j=i; j<i+r ; j++){
                if(!set.contains(s2.charAt(j))){
                    break;
                }else{
                    sb.append(s2.charAt(j));
                    length++;
                }
            }
            String newS = sb.toString();
            char[] c1 = s1.toCharArray();
            char[] c2 = newS.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);

            if (s1.length() == r && Arrays.equals(c1, c2)) {
                // Strings are anagrams and have the correct length
                return true;
            }
        }
        return false;
    }
}

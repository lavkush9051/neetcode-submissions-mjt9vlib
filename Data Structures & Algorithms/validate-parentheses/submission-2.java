class Solution {
    public boolean isValid(String s) {
        // char[] arr1 = new char[{'(','{',']'}];
        // char[] arr2 = new char[{')','}', ']'}]
        HashMap<Character, Character> mp = new HashMap<>();
        mp.put(')', '(');
        mp.put('}', '{');
        mp.put(']', '[');

        Stack<Character> st = new Stack<>();

        for(char c : s.toCharArray()){
            if(mp.containsKey(c)){
                if(!st.isEmpty() && st.peek() == mp.get(c)){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(c);
            }
        }
        return st.isEmpty();

    }
}

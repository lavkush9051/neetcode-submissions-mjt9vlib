class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> que = new LinkedList<>();
        Set<String> st = new HashSet<String>();
 
        for(int i=0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        que.add(new Pair(beginWord, 1));
        while(!que.isEmpty()){
            Pair pair = que.remove();
            String word = pair.word;
            int steps = pair.count;

            if(word.equals(endWord)==true) return steps;
            for(int i=0; i<word.length(); i++ ){
                for(char ch = 'a'; ch<='z'; ch++){
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(st.contains(replacedWord)==true){
                        st.remove(replacedWord);
                        que.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;

    }
}

class Pair{
    String word;
    int count;
    public Pair(String s, int count){
        this.word = s;
        this.count = count;
    }
}

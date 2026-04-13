class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] days = new int[temperatures.length];
        
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                days[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return days;
    }
}
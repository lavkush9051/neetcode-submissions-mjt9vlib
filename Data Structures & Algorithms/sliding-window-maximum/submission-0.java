class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k+1];
        Deque<Integer> dq = new LinkedList<>();
        int index = 0;

        for(int i=0; i< nums.length; i++){
            // if value dont fall in window sz , remove it from front
            if(!dq.isEmpty() && dq.peekFirst() <= (i-k)){
                dq.pollFirst();
            }
            // delete from last , where we insert
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            // add current elm
            dq.offerLast(i);

            if(i >= (k-1)){
                res[index++] = nums[dq.peekFirst()];
            }
        }

        return res;

    }

}

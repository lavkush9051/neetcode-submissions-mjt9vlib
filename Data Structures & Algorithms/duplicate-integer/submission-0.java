class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        if(set.size() != nums.length){
            return true;
        }
        return false;
    }
}
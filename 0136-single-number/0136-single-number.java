class Solution {
    public int singleNumber(int[] nums) {
        int singlenum = 0;
        for(int i=0;i<nums.length;i++){
            singlenum ^= nums[i];
        }
        return singlenum;
    }
}
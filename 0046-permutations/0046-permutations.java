class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getperm(nums , res , 0);
        return res;
    }

    private void getperm(int[] nums , List<List<Integer>> res, int idx){

        if(idx == nums.length){
            List<Integer> perm = new ArrayList<>();
            for(int el: nums){
                perm.add(el);
            }
            res.add(perm);
            return;
        }


        for(int i = idx; i < nums.length; i++){
            swap(nums , i , idx);
            getperm(nums , res , idx+1);
            swap(nums , i , idx);
        }
    }

    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
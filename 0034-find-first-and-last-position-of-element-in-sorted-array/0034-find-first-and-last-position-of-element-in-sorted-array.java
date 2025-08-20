class Solution {
    public int findFirst(int[] nums, int target){
        int start = 0, end = nums.length - 1, ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                ans = mid;
                end = mid-1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int findLast(int nums[] , int target){
        int start = 0, end = nums.length-1 , ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                ans = mid;
                start = mid + 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        if (nums == null || nums.length == 0) return res;

        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        return res;
    }
}
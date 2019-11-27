package Array;

/**
 * Created by yuehu on 8/5/19.
 */
public class SearchinRotatedSortedArrayII_81 {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (end -start) / 2 + start;
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
            }else if(nums[start] <= nums[mid]) {
                if(nums[start] <= target && target <= nums[mid]) end = mid;
                else start = mid;
            }else if(nums[mid] <= nums[end]){
                if(nums[mid] <= target && target <= nums[end]) start = mid;
                else end = mid;
            }
        }

        if(nums[start] == target) return true;
        if(nums[end] == target) return true;
        return false;
    }
}

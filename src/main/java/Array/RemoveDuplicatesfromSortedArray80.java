package Array;

import java.util.Arrays;

/**
 * Created by yuehu on 3/25/19.
 *Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example 1:

 Given nums =
 [1,1,1,2,2,3]
              i
            c

 nums = 1,1,2,2,3

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

 It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDuplicatesfromSortedArray80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        int count = 2;
        for(int i = 2; i < nums.length; i++) {
        if(nums[i] != nums[count-2]) {
            nums[count++] = nums[i];
        }
    }
        return count;
}

    public static void main(String args[]){
        int[] b = {0,0,1,1,1,1,2,3,3};

        RemoveDuplicatesfromSortedArray80 s = new RemoveDuplicatesfromSortedArray80();
        int result = s.removeDuplicates(b);
        System.out.println(result);
        int result1[] = Arrays.copyOfRange(b, 0, result);
        System.out.println(Arrays.toString(result1));
    }
}

package Array;

import java.util.Arrays;

/**
 * Created by yuehu on 7/17/19.
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return nums;
        int[] res = new int[nums.length];
        res[0] = 1;
        //left side product
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        //right side product
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] src = {1,2,3,4,5};
        ProductofArrayExceptSelf s = new ProductofArrayExceptSelf();
        System.out.println(Arrays.toString(s.productExceptSelf(src)));
    }
}

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuehu on 7/16/19.
 */
public class CombinationSum_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            list.add(candidates[i]);
            helper(res,list, candidates, target - candidates[i], i+1);
            list.remove(list.size() -1);
        }
    }

    public static void main(String[] args) {
        int[] src = {2,5,1,1,6,7,10};
        CombinationSum_40 s = new CombinationSum_40();
        System.out.println(s.combinationSum2(src, 8));
    }
}

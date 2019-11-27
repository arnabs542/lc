package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 7/25/19.
 */
public class GenerateParenthesis_22 {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res,"",n,n);
        return res;
    }


    public static void helper(List<String> res, String s, int left, int right) {
        if(left > right) {
            return;
        }

        if(left == 0 && right == 0){
            res.add(s);
            return;
        }
        if(left > 0){
            helper(res, s+ "(",left - 1, right);
        }

        if(right > 0) {
            helper(res, s+ ")", left, right -1);
        }
    }
}

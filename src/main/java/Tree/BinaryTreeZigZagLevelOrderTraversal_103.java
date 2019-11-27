package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuehu on 8/8/19.
 */
public class BinaryTreeZigZagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean x = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(x) {
                    list.add(cur.val);
                }else {
                    list.add(0,cur.val);
                }

                if(cur.left != null){
                    queue.offer(cur.left);
                }

                if(cur.right != null){
                    queue.offer(cur.right);
                }
                res.add(list);
                x = x ? false : true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        boolean x = false;
        System.out.println(x = x);
    }

}

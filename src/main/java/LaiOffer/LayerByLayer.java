package LaiOffer;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuehu on 1/25/20.
 */
public class LayerByLayer {

    // iterative
    public List<List<Integer>> layerByLayerI(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // the list storing all the nodes on the current level.
            List<Integer> list = new ArrayList<Integer>();
            // the size of current level
            int size = queue.size();
            //traverse all the nodes on the current level and
            // prepare for the next level.
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                list.add(cur.val);
            }
            res.add(list);
        }
        return res;
    }

    // recursion
    public List<List<Integer>> layerByLayer(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
         if(root == null) return res;
         helper(res,root,0);
         return res;
     }

     public void helper(List<List<Integer>> res, TreeNode root,int level) {
         if(root == null) return;
         if(level == res.size()){
             res.add(new ArrayList<>());
         }
         res.get(level).add(root.val);
         helper(res,root.left,level+1);
         helper(res,root.right,level+1);
     }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(11);
        TreeNode t6 = new TreeNode(71);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);
        TreeNode t9 = new TreeNode(12);
        TreeNode t10 = new TreeNode(13);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
//        t4.left = t9;
        t4.right = t10;

        LayerByLayer s = new LayerByLayer();
        System.out.println(s.layerByLayer(root));

    }
}

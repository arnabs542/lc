package Tree;

/**
 * Created by yuehu on 8/9/19.
 */
public class PopulatingNextringhtPointersinEachNodeII_117 {
    public class TreeLinkNode {
        public int val;
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;

        public TreeLinkNode() {}

    }
    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        while(cur != null) {
            while(cur != null){
                if(cur.left != null){
                    if(pre != null){
                        pre.next = cur.left;
                    }else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }

                if(cur.right != null){
                    if(pre != null) {
                        pre.next = cur.right;
                    }else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }

    }
}

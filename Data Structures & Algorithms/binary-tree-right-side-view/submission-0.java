/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if(root == null){
            return res;
        }

        que.add(root);
        while(que.size() > 0){
            int sz = que.size();
            for(int i=0; i< sz; i++){
                TreeNode temp = que.remove();
                if(i==sz-1){
                    res.add(temp.val);
                }
                if(temp.left!=null){
                    que.add(temp.left);
                }if(temp.right!=null){
                    que.add(temp.right);
                }
            }
        }
        return res;
    }
}

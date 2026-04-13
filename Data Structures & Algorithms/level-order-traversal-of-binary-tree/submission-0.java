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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        que.add(root);

        while(que.size() > 0){
            List<Integer> temp = new LinkedList<>();
            int sz = que.size();
            for(int i=0; i<sz; i++){
                TreeNode node = que.remove();
                temp.add(node.val);
                if(node.left!=null){
                    que.add(node.left);
                }if(node.right!=null){
                    que.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}

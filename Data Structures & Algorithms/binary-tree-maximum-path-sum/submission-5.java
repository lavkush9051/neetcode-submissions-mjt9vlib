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
    public int maxPathSum(TreeNode root) {
        int[] maxi = new int[1];
        maxi[0] = Integer.MIN_VALUE;
        helperFunc(root, maxi);
        return maxi[0];
    }

    public int helperFunc(TreeNode root, int[] maxi){
        if(root == null){
            return 0;
        }
        int ls = Math.max(helperFunc(root.left, maxi),0);
        int rs = Math.max(helperFunc(root.right, maxi),0);

        // if(ls < 0){
        //     ls = 0;
        // }
        // if(rs < 0){
        //     rs = 0;
        // }

        maxi[0] = Math.max(maxi[0], ls + rs + root.val);
        return Math.max(ls, rs) + root.val;
    }
}

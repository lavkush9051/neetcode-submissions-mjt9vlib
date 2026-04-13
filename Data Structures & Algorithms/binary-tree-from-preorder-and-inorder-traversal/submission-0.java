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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> mp){
        
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(0);
        root.val = preorder[preStart];
        int rootIdx = mp.get(preorder[preStart]);
        int numsleft = rootIdx - inStart;

        root.left = buildTree(preorder, preStart+1, preStart+numsleft, inorder, inStart, rootIdx-1, mp);
        root.right = buildTree(preorder, preStart+numsleft+1, preEnd, inorder, rootIdx+1, inEnd, mp);

        return root;
    }
}

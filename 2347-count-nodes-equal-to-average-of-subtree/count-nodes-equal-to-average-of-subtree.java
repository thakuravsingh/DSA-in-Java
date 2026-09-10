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
    public int num(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return 1 + num(root.left) + num(root.right);
    }
    public int sum(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        return root.val + sum(root.left) + sum(root.right);
    }
    public int averageOfSubtree(TreeNode root) {
        if(root == null) return 0;
        int sum = sum(root);
        int n = num(root);
        int cur = (sum / n) == root.val ? 1 : 0;
        int left = averageOfSubtree(root.left);
        int right = averageOfSubtree(root.right); 
        return cur + left + right;
    }
}
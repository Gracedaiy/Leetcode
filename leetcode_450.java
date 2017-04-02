/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
    
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
    
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        
        if(root.val == key){
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode rootLeft = root.left;

            while(rootLeft.right != null){
                rootLeft = rootLeft.right; 
            }
            root.val = rootLeft.val;
            root.left = deleteNode(root.left, root.val);
            
        }
        return root;
    }    

}
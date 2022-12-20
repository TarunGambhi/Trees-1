//TC: o(n)
//sc: o(1)
//https://leetcode.com/problems/validate-binary-search-tree/
class Solution {
    boolean flag;
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        flag = true;
        inorder(root);
        return flag;
    }
    private void inorder(TreeNode root){
        if(root == null || !flag){ return;}
        inorder(root.left);
        if(prev != null && prev.val>= root.val){
            flag = false;
            return;
        }
        prev = root;
        System.out.print(root.val);
        inorder(root.right);
    }
}

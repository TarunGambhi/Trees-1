
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        int rootval = preorder[0];
        int rootIdx = -1;
        TreeNode root = new TreeNode(rootval);
        for(int i=0; i< inorder.length; i++){
            if(inorder[i] == rootval){
                rootIdx = i;
                break;
            }
        }
        
        int[] leftIn = Arrays.copyOfRange(inorder,0,rootIdx);
        int[] rightIn = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
        int[] leftPre = Arrays.copyOfRange(preorder,1,1+leftIn.length);
        int[] rightPre = Arrays.copyOfRange(preorder,leftIn.length+1,preorder.length);
        root.left = buildTree(leftPre,leftIn);
        root.right = buildTree(rightPre,rightIn);
        return root;
    }
}

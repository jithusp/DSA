package org.griddynamics.july16;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class CheckTreeisBST {

    public static boolean isBST(TreeNode root) {
        return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBSTHelper(TreeNode node, long min, long max) {
//        long min=Long.MIN_VALUE,max=Long.MAX_VALUE;
        if (node == null) return true;

        if (node.val <= min || node.val >= max) return false;

        return isBSTHelper(node.left, min, node.val) &&
                isBSTHelper(node.right, node.val, max);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        System.out.println("Is BST: " + isBST(root));
    }
}

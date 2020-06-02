package isSymmetricTree;


import isSymmetricTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

//给定一个二叉树，检查它是否是镜像对称的。

public class Solution {

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(isSymmetric(node0));

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSymmetricTwo(root.left, root.right);


    }

    public static boolean isSymmetricTwo(TreeNode leftRoot, TreeNode rightRoot) {

//        if (leftRoot != null && rightRoot == null) return false;
//        if (leftRoot == null && rightRoot != null) return false;
//        if (leftRoot == null && rightRoot == null) return true;
//        if (leftRoot.val != rightRoot.val) return false;
//
//        if (leftRoot.left != null) {
//            if (rightRoot.right == null) return false;
//            else if (rightRoot.right.val != leftRoot.left.val) return false;
//        } else {
//            if (rightRoot.right != null) return false;
//        }
//
//        if (leftRoot.right != null) {
//            if (rightRoot.left == null) return false;
//            else if (rightRoot.left.val != leftRoot.right.val) return false;
//        } else {
//            if (rightRoot.left != null) return false;
//        }

        if(rightRoot == null && leftRoot == null){
            return true;
        }
        if(rightRoot ==null || leftRoot ==null){
            return false;
        }

        return rightRoot.val == leftRoot.val && isSymmetricTwo(leftRoot.left, rightRoot.right) && isSymmetricTwo(leftRoot.right, rightRoot.left);
    }
}

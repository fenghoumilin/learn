package newcorder;


public class Solution {
    public int run(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.right == null) {
            return run3(root.left) + 1;
        } else if (root.left == null) {
            return run3(root.right) + 1;
        } else {
            return run2(root);
        }
    }

    private int run2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.right == null && root.left == null) {
            return 1;
        }

        int depth = run(root.left);
        depth = Math.min(depth, run(root.right));

        return depth + 1;
    }

    private int run3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.right == null && root.left == null) {
            return 1;
        }

        if (root.right == null) {
            return run3(root.left) + 1;
        } else if (root.left == null) {
            return run3(root.right) + 1;
        }

        int depth = run(root.left);
        depth = Math.min(depth, run(root.right));

        return depth + 1;
    }
}

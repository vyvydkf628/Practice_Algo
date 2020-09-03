package dp;

import java.util.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution {
    static ArrayList<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = ArrayList<>();
        inorder(root);
        return ans;
    }
    public void inorder(TreeNode cur) {
        if (cur == null) return;
        
        inorder(cur.left);
        ans.add(cur.val);
        inorder(cur.right);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 전위TO후위 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree tree = new BinaryTree(Integer.parseInt(br.readLine()));
        String s = "";
        while ((s = br.readLine()) != null && s.length() != 0) {    //EOF까지 입력받음
            tree.addTree(tree.root, Integer.parseInt(s));
        }
        tree.postOrder(tree.root);
	}
	
	
}

class BinaryTree {
	TreeNode root;
	public BinaryTree(int val) {
		root = new TreeNode(val);
	}
	
	public TreeNode addTree(TreeNode cur,int val) {
		if (cur == null) {
			return new TreeNode(val);
		}
		if (cur.val > val) {
			cur.left = addTree(cur.left, val);
		} else {
			cur.right = addTree(cur.right, val);
			
		}
		return cur;
	}
	public static void postOrder (TreeNode cur) {
		if(cur.left != null) {
			postOrder(cur.left);
		}
		if(cur.right != null) {
			postOrder(cur.right);
		}
		System.out.println(cur.val);
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
		// TODO Auto-generated constructor stub
	}
}
